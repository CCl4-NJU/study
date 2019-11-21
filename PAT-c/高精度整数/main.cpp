#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;

struct bigInteger{
    int digit[10000];  //digit[0] =1234  digit[1] = 5678    -->56781234
    int size; //存放下一个可用的digit
    char input[1000];
    void init(){
        for(int i=0;i<10000;i++){
            digit[i] = 0;
            size = 0;
        }
    }
    void set(){
        scanf("%s", input);
        int value = 0;
        int c = 1;
        for(int i = strlen(input)-1; i>=0; i--){
            int t = (input[i]-'0') * c;
            value += t;
            c *= 10;
            if(c == 10000){
                digit[size++] = value;
                c = 1;
                value = 0;
            }
        }
        if(value!=0){
            digit[size++] = value;
        }
    }
    void output(){
        for(int i = size-1 ;i>=0; i--){
            printf("%d", digit[i]);
        }
    }
}a,b,c,d,e;
bigInteger add(bigInteger a,bigInteger b){
    bigInteger c;
    c.init();
    c.size = max(a.size, b.size);
    int jinwei = 0;
    int i;
    for(i = 0;i < c.size; i++){
        c.digit[i] = a.digit[i] + b.digit[i] + jinwei;
        jinwei = 0;
        if(c.digit[i] > 9999){
            c.digit[i] -= 10000;
            jinwei = 1;
        }
    }
    if(jinwei == 1){
        c.digit[i] = 1;
        c.size += 1;
    }
    return c;
}
bigInteger multiply(bigInteger a, int b){  //某个数乘大数
    bigInteger e;
    e.init();
    int jinwei = 0;
    int i=0;
    for(i=0;i < a.size;i++){
        int val = b*a.digit[i] + jinwei;
        jinwei = 0;
        if(val > 10000){
            jinwei = val / 10000;
            e.digit[e.size++] = val%10000;
        }else{
            e.digit[e.size++] = val;
        }
    }
    while(jinwei != 0){
        e.digit[e.size++] = jinwei%10000;
        jinwei = jinwei/10000;
    }
    return e;
}
int main()
{
    a.init();
    a.set();
    a.output();
    printf("\n");
    b.init();
    b.set();
    b.output();
    printf("\n");
    c = add(a, b);
    c.output();
    printf("\n");

    d = multiply(a, 2);
    d.output();
    printf("\n");
    return 0;
}
