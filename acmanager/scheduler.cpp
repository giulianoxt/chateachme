#include "scheduler.h"
#include "net_udp.h"

#include <ctime>
#include <cstring>
#include <cstdlib>
#include <cstdio>
typedef tm datetime;

#include <map>
#include <list>
#include <string>
#include <sstream>
#include <iomanip>
using namespace std;


int datetime_cmp(const datetime& a, const datetime& b);
ostream& operator<<(ostream& out, const datetime& dt);


namespace scheduler
{

void turn_on(const string& ac_id);
void turn_off(const string& ac_id);

struct ac_device
{
    string host;
    int port;
    int priority;
};

struct ac_task
{
    string ac_id;
    datetime start, end;

    bool operator< (const ac_task& task) const
    {
        int cmp_st  = datetime_cmp(start, task.start);
        int cmp_end = datetime_cmp(end, task.end);
        return cmp_st < 0 || (cmp_st == 0 && cmp_end < 0);
    }

    bool operator== (const ac_task& task) const
    {
        int cmp_st  = datetime_cmp(start, task.start);
        int cmp_end = datetime_cmp(end, task.end);
        return ac_id == task.ac_id && !cmp_st && !cmp_end;
    }

    bool is_active(const datetime& dt) const
    {
        return datetime_cmp(start, dt) <= 0 && datetime_cmp(dt, end) < 0;
    }
};

enum algorithm_t
{
    STATIC,
    EDF
};

typedef list<ac_task> tasklist;


/**
 * Mapeamento id -> ac_device
 */
map<string, ac_device> ac_devices;

/**
 * Número máximo de ar-condicionados ligados
 */
int ac_limit;

/**
 * Algoritmo de escalonamento escolhido
 */
algorithm_t algorithm;

/**
 * Lista de todas as ativações (não muda depois do init)
 */
tasklist ac_tasks;

/**
 * Próxima tarefa a ser analisada em ac_tasks
 */
tasklist::iterator next_task;

/**
 * Ar-condicionados que estão ligados
 */
tasklist running;

/**
 * Ar-condicionados que estão esperando para serem ligados
 * (está sendo ativado atualmente ou foi preemptado recentemente)
 */
tasklist pending;


/**
 * Lê as configurações de um arquivo texto
 */
void init(istream& config)
{
    time_t tt_now = time(0);
    const datetime& now = *localtime(&tt_now);

    ac_devices.clear();
    ac_tasks.clear();
    running.clear();
    pending.clear();

    string op;
    while (config >> op) {
        if (op == "#") {
            getline(config, op);
        }
        else if (op == "ac") {
            string id;
            ac_device ac;

            config >> id >> ac.host >> ac.port >> ac.priority;

            ac_devices[id] = ac;            
        }
        else if (op == "turn_on") {
            ac_task task;
            string start, end;

            config >> task.ac_id >> start >> end;

            task.start.tm_hour = atoi(start.substr(0, 2).c_str());
            task.start.tm_min  = atoi(start.substr(3, 2).c_str());
            task.start.tm_sec  = atoi(start.substr(6, 2).c_str());

            task.end.tm_hour = atoi(end.substr(0, 2).c_str());
            task.end.tm_min  = atoi(end.substr(3, 2).c_str());
            task.end.tm_sec  = atoi(end.substr(6, 2).c_str());

            ac_tasks.push_back(task);
        }
        else if (op == "limit") {
            config >> ac_limit;
        }
        else if (op == "algorithm") {
            config >> op;
            if (op == "static") {
                algorithm = STATIC;
            }
            else if (op == "edf") {
                algorithm = EDF;
            }
        }
    }

    ac_tasks.sort();
    next_task = ac_tasks.begin();

    for (tasklist::iterator it = ac_tasks.begin(); it != ac_tasks.end(); ++it) {
        if (it->is_active(now) || datetime_cmp(it->end, now) > 0) {
            next_task = it;
            break;
        }
    }
}


/**
 * Atualiza os estados dos ar-condicionados de acordo com as ativações
 */
void tick()
{
    time_t tt_now = time(0);
    const datetime& now = *localtime(&tt_now);

    cout << "tick() " << now << endl;

    for (tasklist::iterator it = running.begin(); it != running.end(); ) {
        if (!it->is_active(now)) {
            turn_off(it->ac_id);
            it = running.erase(it);
        }
        else {
            ++it;
        }
    }

    while (next_task != ac_tasks.end()) {
        if (next_task->is_active(now)) {
            pending.push_back(*(next_task++));
        }
        else {
            break;
        }
    }

    if (next_task == ac_tasks.end()) {
        next_task = ac_tasks.begin();
    }

    for (tasklist::iterator it = pending.begin(); it != pending.end(); ) {
        if (!it->is_active(now)) {
            it = pending.erase(it);
        }
        else if (running.size() < ac_limit) {
            turn_on(it->ac_id);
            running.push_back(*it);
            it = pending.erase(it);
        }
        else if (algorithm == STATIC) {
            tasklist::iterator min_p = running.begin();

            for (tasklist::iterator it2 = ++running.begin(); it2 != running.end(); ++it2) {
                const ac_device& min_dev = ac_devices[min_p->ac_id];
                const ac_device& it_dev  = ac_devices[it2->ac_id];

                if (it_dev.priority < min_dev.priority) {
                    min_p = it2;
                }
            }
            
            const ac_device& min_dev = ac_devices[min_p->ac_id];
            const ac_device& pen_dev = ac_devices[it->ac_id];

            if (pen_dev.priority > min_dev.priority) {
                turn_off(min_p->ac_id);
                running.erase(min_p);

                turn_on(it->ac_id);
                running.push_back(*it);
                it = pending.erase(it);
            }
            else {
                ++it;
            }
        }
        else if (algorithm == EDF) {
            tasklist::iterator max_dl = running.begin();

            for (tasklist::iterator it2 = ++running.begin(); it2 != running.end(); ++it2) {
                if (datetime_cmp(it2->end, max_dl->end) > 0) {
                    max_dl = it2;
                }
            }

            if (datetime_cmp(it->end, max_dl->end) < 0) {
                turn_off(max_dl->ac_id);
                running.erase(max_dl);

                turn_on(it->ac_id);
                running.push_back(*it);
                it = pending.erase(it);
            }
            else {
                ++it;
            }
        }
        else {
            cout << "algorithm not defined" << endl;
        }
    }
}


void turn_on(const string& ac_id)
{
    cout << ac_id << " on" << endl;
    net_udp::turn_on(ac_devices[ac_id].host, ac_devices[ac_id].port);
}


void turn_off(const string& ac_id)
{
    cout << ac_id << " off" << endl;
    net_udp::turn_off(ac_devices[ac_id].host, ac_devices[ac_id].port);
}


}


int datetime_cmp(const datetime& a, const datetime& b)
{
    if (a.tm_hour != b.tm_hour) {
        return a.tm_hour - b.tm_hour;
    }
    else if (a.tm_min != b.tm_min) {
        return a.tm_min - b.tm_min;
    }
    else if (a.tm_sec != b.tm_sec) {
        return a.tm_sec - b.tm_sec;
    }
    else {
        return 0;
    }
}

ostream& operator<<(ostream& out, const datetime& dt)
{
    return out << setw(2) << setfill('0') << dt.tm_hour << ':'
               << setw(2) << setfill('0') << dt.tm_min  << ':'
               << setw(2) << setfill('0') << dt.tm_sec;
}
