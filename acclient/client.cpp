#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <iostream>
using namespace std;

const char TURN_ON_CMD = 45;
const char TURN_OFF_CMD = 54;

int main(int argc, char** argv) {
    if (argc != 2) {
        cout << "usage: acclient port" << endl;
    }

    int sock;
    int port = atoi(argv[1]);

    if ((sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1) {
        perror("socket()");
        exit(1);
    }

    sockaddr_in client_addr;
    memset(&client_addr, 0, sizeof client_addr);

    client_addr.sin_family = AF_INET;
    client_addr.sin_port = htons(port);
    client_addr.sin_addr.s_addr = htonl(INADDR_ANY);

    if (bind(sock, (sockaddr*)&client_addr, sizeof client_addr) == -1) {
        perror("bind()");
        exit(1);
    }

    cout << "init: turned off" << endl;

    while (true) {
        char cmd;
        recv(sock, &cmd, 1, 0);

        if (cmd == TURN_ON_CMD) {
            cout << "turned on" << endl;
        }
        else {
            cout << "turned off" << endl;
        }
    }

    return 0;
}
