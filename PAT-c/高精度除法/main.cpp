#include <iostream>
#include <stdio.h>
#include <string>
#include <math.h>
using namespace std;

struct BigInteger
{
    int digit[100];
    int size;

    void init()
    {
        for(int i=0; i<100; i++)
        {
            digit[i] = 0;
        }
        size = 0;
    }
    void set(string str)
    {
        init ();
        int j = 1;
        int t = 0;
        int tmp = 0;
        for(int i = str.size()-1; i>=0; i--)
        {
            t = str[i] - '0';
            tmp += t*j;
            j *= 10;
            if(j==10000 || i==0)
            {
                j = 1;
                digit[size++] = tmp;
               // printf("%d\n", tmp);
                tmp = 0;
            }
        }
    }
    void output()
    {
        for(int i=size-1; i>=0; i--)
        {
            if(i!=size-1){
                printf("%04d", digit[i]);
            }else{
                printf("%d", digit[i]);
            }

        }
    }
} b;
BigInteger divid(BigInteger b, int n){
    BigInteger ret;
    ret.init();
    int yushu = 0;
    for(int i = b.size -1; i>=0;i--){
        int t = (yushu*10000 + b.digit[i])/n;
        yushu = (yushu*10000 + b.digit[i])%n;
        ret.digit[i] = t;
    }
    for(int i=0; i<100;i++){
        if(ret.digit[i] != 0){
            ret.size = i;
        }
    }
    ret.size++;
    return ret;
}
int main()
{
    string str;
    char a[1000];
    BigInteger c;
    while(scanf("%s", a)!=EOF)
    {
        str = a;
        b.set(str);
        if(str == "0"){
            printf("0\n");
            continue;
        }
        int t = 0;
        string ans;
        while(b.size!=1 || b.digit[0]!=0){
            //printf("b.size = %d\n", b.size);
            ans[t] = b.digit[0]%2 + '0';
            b = divid(b,2);
            t++;
        }
        ans[t] = '\0';
        for(int i=t-1;i>=0;i--){
            printf("%c", ans[i]);
        }
        printf("\n");
    }

    return 0;
}
