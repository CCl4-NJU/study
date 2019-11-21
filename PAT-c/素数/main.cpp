#include <iostream>
#include <stdio.h>
using namespace std;

int prime[10000]; //保存筛选的素数
bool mark[10001];
int primeSize = 0; //保存素数的个数

int main()
{
    int i;
    for(i=2; i<10000; i++){
       mark[i] = false;
    }
    for(i=2; i<10000; i++){
        if(mark[i] == true){
            continue;
        }
        prime[primeSize ++] = i;
        for(int j=i;j<10000;j = j+i){
            mark[j] = true;
        }
    }
    for(i=0;i<100;i++){
        if(prime[i]<100 && prime[i] %10 ==1){
            printf("%d ", prime[i]);
        }
    }
    return 0;
}
