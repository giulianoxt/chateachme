#ifndef _SCHEDULER_H
#define	_SCHEDULER_H

#include <iostream>
using std::istream;


namespace scheduler
{

void init(istream& config);

void tick();

}

#endif
