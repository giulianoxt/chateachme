#ifndef _NET_UDP_H
#define	_NET_UDP_H

#include <string>
using namespace std;


namespace net_udp
{

void init();

void turn_on(const string& host, const int port);

void turn_off(const string& host, const int port);

}


#endif
