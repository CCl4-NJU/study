#include <iostream>
#include <queue>
#include <stdio.h>
using namespace std;
//  ´ó¶¥¶Ñ priority_queue <int> Q;
priority_queue <int, vector<int>, greater<int> > Q;

int main()
{
    int num;
    while(!Q.empty()) Q.pop();
    while(scanf("%d", &num)!=EOF){
        printf("num: %d",num);
        int layer[num];
        int ans = 0;
        for(int i=0;i<num;i++){
            scanf("%d", &layer[i]);
            Q.push(layer[i]);
            printf("%d", layer[i]);
        }
        printf("\n");
        while(Q.size()>1){
            int one = Q.top();
            printf("one: %d\n", one);
            Q.pop();
            int two = Q.top();
            printf("two: %d\n", two);
            Q.pop();
            ans =ans + one + two;
            printf("ans: %d\n", ans);
            Q.push(one + two);
        }
        printf("%d\n", Q.top());

    }
    return 0;
}
