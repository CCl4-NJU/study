#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>

using namespace std;

struct E{
    char name[100];
    int age;
    int grade;
}buf[1000];  //接着定义数组

bool cmp(E a, E b){
    if(a.grade != b.grade){
        return a.grade < b.grade;
    }

    int bijiao = strcmp(a.name, b.name);
    //若参数s1和s2字符串相同则返回0.s1若大于s2则返回大于0的值.s1若小于s2则返回小于0的值.
    if(bijiao != 0){
        return bijiao < 0;
    }else{
        return a.age < b.age;
    }
}

int main()
{
    int num;
    cin>>num;
    for(int i=0;i<num;i++){
        scanf("%s%d%d", buf[i].name, &buf[i].age, &buf[i].grade);
    }

    sort(buf, buf+num, cmp);
    for(int i=0;i<num;i++){
        printf("%s %d %d\n", buf[i].name, buf[i].age, buf[i].grade);
    }
    return 0;
}
