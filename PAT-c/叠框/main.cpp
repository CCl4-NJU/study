#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    int num;
    char inner,outter;
    char con[81][81];
    while(scanf("%d %c %c", &num, &inner, &outter) != EOF){
        printf("%d %c %c\n", num, inner, outter);
        int k = num/2 + 1;
        for(int j=0;j<=num;j=j+2){
            for(int i=0; i <= j; i++){
                char tmpChar = j/2 % 2 == 0?inner: outter;
                con[k - j/2][k -j/2 + i] = tmpChar;  //ио
                con[k - j/2 + i][k - j/2 + j] = tmpChar; //you
                con[k - j/2 + j][k - j/2 + i] = tmpChar; //xia
                con[k - j/2 + i][k - j/2] = tmpChar; //zuo
            }
        }
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                if((i==1 && j==1) || (i==1&&j==num) || (i==num && j==1) || (i==num&&j==num)){
                    printf(" ");
                }else{
                    printf("%c ", con[i][j]);
                }

            }
            printf("\n");
        }
    }
    return 0;
}
