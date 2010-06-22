#include "scheduler.h"

#include <ctime>
#include <cstring>
#include <cstdlib>
#include <cstdio>
typedef tm datetime;

#include <map>
#include <list>
#include <string>
#include <sstream>
using namespace std;


int datetime_cmp(const datetime& a, const datetime& b);
ostream& operator<<(ostream& out, const datetime& dt);


namespace scheduler
{

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
    MONOTONIC_RATE
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
        else if (op == "static") {
            algorithm = STATIC;
        }
        else if (op == "monotonic_rate") {
            algorithm = MONOTONIC_RATE;
        }
    }

    ac_tasks.sort();
    next_task = ac_tasks.begin();
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
            cout << it->ac_id << " off" << endl;
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
            cout << it->ac_id << " on" << endl;
            running.push_back(*it);
            it = pending.erase(it);
        }
        else if (algorithm == STATIC) {
            tasklist::iterator min_p = running.begin();

            for (tasklist::iterator it2 = ++running.begin(); it2 != running.end(); ++it2) {
                const ac_device& min_dev = ac_devices[min_p->ac_id];
                const ac_device& it_dev    = ac_devices[it2->ac_id];

                if (it_dev.priority < min_dev.priority) {
                    min_p = it2;
                }
            }
            
            const ac_device& min_dev = ac_devices[min_p->ac_id];
            const ac_device& pen_dev = ac_devices[it->ac_id];

            if (pen_dev.priority > min_dev.priority) {
                cout << min_p->ac_id << " off" << endl;
                running.erase(min_p);

                cout << it->ac_id << " on" << endl;
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
    return out << dt.tm_hour << ':' << dt.tm_min << ':' << dt.tm_sec;
}
