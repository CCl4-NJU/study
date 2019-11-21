#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>
using namespace std;

int main()
{
    int a,b;
    char str[100];
    scanf("%d %s %d",&a, str, &b);
    int length = strlen(str);
    char str2[100];
    printf("length: %d\n", length);
    int tmp = 0;
    for(int i=0,j=length; i<length;i++,j--){
        if(str[i]>='0' && str[i] <='9'){
            tmp = tmp + (str[i]-'0')*pow(a, j-1);
        }else if(str[i]>='a' && str[i]<='z'){
            tmp = tmp + (str[i]-'a' + 10)*pow(a, j-1);
        }else if(str[i]>='A' && str[i] <= 'Z'){
            tmp = tmp + (str[i]-'A' + 10)*pow(a, j-1);
        }
    }
    int i = 0;
    printf("%d\n", tmp);
    while(tmp != 0){
        if(tmp%b < 9){
             str2[i] = tmp % b + '0';
             tmp = tmp/b;
        }else{
            str2[i] = tmp % b -10 + 'A';
            tmp = tmp/b;
        }
        i++;
    }
    str2[i] = '\0';
    for(int i=strlen(str2)-1;i>=0;i--){
        printf("%c", str2[i]);
    }

    return 0;
}
