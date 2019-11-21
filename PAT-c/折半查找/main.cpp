#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>

using namespace std;
struct stu{
    char id[1000];
    char name[10];
    char sex[10];
    int age;
}buf[1000];

bool rule(stu A, stu B){
    return (strcmp(A.id, B.id)<0);
}

int main()
{
    int N,M;
    scanf("%d", &N);
    for(int i=0;i<N ;i++){
        scanf("%s %s %s %d", buf[i].id, buf[i].name, buf[i].sex, &buf[i].age);
    }
    sort(buf, buf+N, rule);
    /*for(int i=0;i<N;i++){
        printf("%s %s %s %d\n", buf[i].id, buf[i].name, buf[i].sex, buf[i].age);
    }*/
    scanf("%d", &M);
    char want[1000];

    for(int i=0;i<M;i++){
        scanf("%s", want);
        printf("want:%s\n", want);
        //ÕÛ°ë²éÕÒ
        int start = 0;
        int last = N-1;
        int mid = (start + last)/2;
        int ans = 0;
        while(start <= last){
            if(strcmp(buf[mid].id, want) < 0){
                start = mid+1;
                mid = (start+last)/2;
            }else if(strcmp(buf[mid].id, want) > 0){
                last = mid-1;
                mid = (start+last)/2;
            }else{
                printf("%s %s %s %d\n", buf[mid].id, buf[mid].name, buf[mid].sex, buf[mid].age);
                ans = -1;
                break;
            }
        }
        if(ans == 0){
            printf("NO Answer!\n");
        }

    }
    return 0;
}
