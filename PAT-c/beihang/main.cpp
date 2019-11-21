#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;


int main(){
   int num;
   scanf("%d", &num);
   for(int i=0;i<num;i++){
        int a,b,c,d,e,f,g,h;
        scanf("%d%d%d%d%d%d%d%d", &a, &b, &c,&d,&e,&f,&g,&h);
        printf("%d\n",(a*c)/b + (d*g*h)/(e*f));
   }
}
