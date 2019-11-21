#include <iostream>
#include <stdio.h>
#include <algorithm>
using namespace std;

#define N 10001

struct Edge{
    int a,b;   //±ß¶¥µãµÄ±àºÅ
    int cost;  //±ß³¤
}edge[6000];
bool rule(Edge a, Edge b){
    return a.cost < b.cost;
}
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
    int n;
    int a,b,c;
    while(scanf("%d", &n)!=EOF && n!= 0){
        for(int i=1;i<=n*(n-1)/2;i++){
            scanf("%d %d %d",&a,&b,&c);
            edge[i].a = a;
            edge[i].b = b;
            edge[i].cost = c;
        }
        sort(edge+1, edge+1+n*(n-1)/2, rule);
        for(int i=1;i<=n;i++){
            Tree[i] = -1;
        }
        int ans = 0;
        for(int i=1;i<=n*(n-1)/2;i++){
            int a = findroot(edge[i].a);
            int b = findroot(edge[i].b);
            if(a!=b){
                Tree[a] = b;
                ans += edge[i].cost;         //生成的树并不是最小生成树，但是路径
                                             //要想取得最小生成树则再弄另一个Tree2[N]
                                             // 把最小生成树放到Tree2中去
            }
        }
        printf("%d\n",ans);
        printf("%d\n",Tree[2]);

    }
    return 0;
}
