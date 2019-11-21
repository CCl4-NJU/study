#include <iostream>
#include <stdio.h>
#include <stack>
#include <string.h>
#include <math.h>
using namespace std;
stack<char> symbol;
stack<double> num;

int main()
{
    char str[1000];
    symbol.push('#');
    while(gets(str)){
        if(strcmp(str,"0") == 0){
            break;
        }
        else{
            for(int i=0;str[i] !='\0';i++){
                if(str[i]>='0' && str[i] <='9'){
                    double in = 0.0;
                    int j=0;
                    for(j=i; str[j]!=' '&&str[j] !='\0';j++){
                    }
                    int tmp = j;
                    j = j - i;
                    printf("J:%d\n", j);
                    for(;str[i]!=' '&&str[i]!='\0'&&j>=0;j--){
                        in = in + (str[i]-'0') * pow(10,j-1);
                        i++;
                    }
                    printf("in:%lf\n",in);
                    num.push(in);
                }else if(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/'){
                    if(str[i] == '+' || str[i] == '-'){
                        char top = symbol.top();
                        if(top == '#' || top == '+' || top == '-'){
                            symbol.push(str[i]);
                        }else{
                            symbol.pop();
                            double two = num.top();
                            num.pop();
                            double one = num.top();
                            num.pop();
                            if(top == '*'){
                                num.push(one*two);
                            }else if(top == '/'){
                                num.push(one/two);
                            }
                            symbol.push(str[i]);
                        }
                    }else if(str[i] == '*' || str[i] == '/'){
                        symbol.push(str[i]);
                    }

                }
            }
            while(symbol.top() != '#'){
                char top = symbol.top();
                symbol.pop();
                double two = num.top();
                num.pop();
                double one = num.top();
                num.pop();
                if(top == '*'){
                    num.push(one*two);
                }else if(top == '/'){
                    num.push(one/two);
                }else if(top == '+'){
                    num.push(one+two);
                }else if(top == '-'){
                    num.push(one - two);
                }
            }
            printf("%.2lf\n", num.top());
        }
    }
    return 0;
}
