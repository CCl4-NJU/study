
#include <iostream>
#include <stdio.h>

using namespace std;

int primeSize = 0;
int prime[10000];
bool mark[10000];
void init(){
    for(int i=0;i<10000;i++){
        mark[i] = false;
    }
    for(int i=2;i<10000;i++){
        if(mark[i] == true){
            continue;
        }
        prime[primeSize++] = i;
        for(int j = i;j<10000;j =j + i){
            mark[j] = true;
        }
    }
}
int main(){
   int n,a;
   init();
   scanf("%d %d",&n, &a);
   int atmp = a;
   int ntmp = n;
   int azi[a];
   int ndezhi[a];
   for(int i=0;i<=a;i++){
     azi[i] = 0;
   }
    for(int i=0;i<=n;i++){
     ndezhi[i] = 0;
   }
   for(int i=0;i<a;){
    if(a%prime[i] == 0){
        a = a/prime[i];
        azi[prime[i]] += 1;
        i = 0;
    }else{
        i++;
    }
   }
   for(int i=2;i<=n;i++){
        int tmp = i;
        for(int j=0;j<tmp;){
            if(tmp%prime[j] == 0){
                tmp = tmp/prime[j];
                ndezhi[prime[j]] = ndezhi[prime[j]] + 1;
                j = 0;
            }else{
                j++;
            }
        }
   }
   int result = 1000;
   for(int i=2;i<=atmp; i++){
    if(azi[i]!=0){
     result = min(result, ndezhi[i]);
    }
   }
   printf("%d\n", result);

}
