#include <iostream>
#include <stdio.h>
#include <algorithm>

using namespace std;

struct time{
    int startTime;
    int endTime;
}buf[101];

bool rule(time A, time B){
    return A.endTime<B.endTime;
}

int main()
{
    int num;
    int currectEndTime = -1;
    int shownum = 0;
    while(scanf("%d", &num)!= EOF){
        if(num == 0){
            break;
        }
        for(int i=0;i<num;i++){
            scanf("%d %d", &buf[i].startTime, &buf[i].endTime);
        }
        sort(buf, buf+num, rule);
        /*for(int i=0;i<num;i++){
            printf("%d %d\n", buf[i].startTime, buf[i].endTime);
        }*/
        for(int i=0;i<num;i++){
            if(buf[i].startTime >= currectEndTime){
                currectEndTime = buf[i].endTime;
                shownum ++;
            }
        }
        printf("%d\n", shownum);
    }
    return 0;
}
