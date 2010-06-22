#include <cstdlib>
#include <iostream>
#include <fstream>
using namespace std;

#include "scheduler.h"


const int refresh_time = 1; // sec


void die(char const* msg)
{
    cout << msg << endl;
    exit(1);
}

int main(int argc, char** argv)
{
    if (argc != 2) {
        die("usage: acmanager config_file");
    }

    fstream config(argv[1], ios_base::in);

    if (config.fail()) {
        die("invalid config file");
    }

    scheduler::init(config);
    config.close();

    while (true) {
        scheduler::tick();
        sleep(refresh_time);
    }

    return 0;
}
