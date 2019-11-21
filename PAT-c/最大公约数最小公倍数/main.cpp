#include <iostream>
#include <stdio.h>
using namespace std;
int GFD(int a, int b){
    if(b==0) return a;
    else return GFD(b, a%b);
}
int main()
{
    int a;int b;
    while(scanf("%d %d", &a, &b)!=EOF){
        printf("GFD: %d\n", GFD(a,b));
        printf("SFD: %d\n", a*b/GFD(a, b));
    }
    return 0;
}
