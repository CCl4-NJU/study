#include <iostream>
#include <stdio.h>
using namespace std;

#define N 1000001

int Tree[N];
int findroot(int x){
    if(Tree[x] == -1) return x;
    else{
        int tmp = findroot(Tree[x]);
        Tree[x] = tmp;
        return tmp;
    }
}
int main()
{
    int n,a,b;

    while(scanf("%d", &n)!=EOF){
        int sum[n];
        for(int i=0;i<n;i++){
            Tree[i] = -1;
            sum[i] = 1;
        }
        for(int i=1;i<=n;i++){
            scanf("%d %d", &a, &b);
            a = findroot(a);
            b = findroot(b);
            if(a!=b){
                Tree[a] = b;
                sum[b] += sum[a];
            }
        }
        int ans = 1;
        int maxValue = 0;
        for(int i=1;i<=n;i++){
            maxValue = max(maxValue, sum[i]);
        }
        printf("%d\n", maxValue);
    }

    return 0;
}
