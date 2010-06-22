#include "net_udp.h"

#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <cstdlib>
#include <cstring>
#include <cstdio>


namespace net_udp
{

sockaddr_in from_host(const string& host, const int port);

const int SERVER_PORT = 3323;
const char TURN_ON_CMD = 45;
const char TURN_OFF_CMD = 54;

int sock;


void init()
{
    if ((sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1) {
        perror("init::socket()");
        exit(1);
    }
}


void turn_on(const string& host, const int port)
{
    sockaddr_in host_addr = from_host(host, port);

    if (sendto(sock, &TURN_ON_CMD, 1, 0, (sockaddr*)&host_addr, sizeof host_addr) == -1) {
        perror("turn_on::sendto()");
        exit(1);
    }
}


void turn_off(const string& host, const int port)
{
    sockaddr_in host_addr = from_host(host, port);

    if (sendto(sock, &TURN_OFF_CMD, 1, 0, (sockaddr*)&host_addr, sizeof host_addr) == -1) {
        perror("turn_off::sendto()");
        exit(1);
    }
}


sockaddr_in from_host(const string& host, const int port)
{
    sockaddr_in host_addr;
    memset(&host_addr, 0, sizeof host_addr);

    host_addr.sin_family = AF_INET;
    host_addr.sin_port = htons(port);
    inet_aton(host.c_str(), &host_addr.sin_addr);

    return host_addr;
}

}
