#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    string str;
    char c[100];
    while(gets(c)){
        str = c;
        int startPos = 0;
        int pos = -1;
        while(str.find("in", startPos) != string::npos){
            pos = str.find("in", startPos);
            str.erase(pos, 2);
        }
        while(str.find("In", startPos) != string::npos){
            pos = str.find("In", startPos);
            str.erase(pos, 2);
        }
        while(str.find("IN", startPos) != string::npos){
            pos = str.find("IN", startPos);
            str.erase(pos, 2);
        }
        while(str.find("iN", startPos) != string::npos){
            pos = str.find("iN", startPos);
            str.erase(pos, 2);
        }
        printf("%s\n",str.c_str());
    }
    return 0;
}
