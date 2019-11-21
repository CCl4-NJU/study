#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

int main()
{
    string s;
    cin>>s;
    s += '$';
    s += "abc";
    cout<<s<<endl;
    printf("%s\n", s.c_str());
    for(int i=0;i<s.size();i++){
        char c = s[i];
    }
    s.erase(2,3); //删除从s[2]到s[4] 的字符  123456-->126
    printf("%s\n", s.c_str());

    string a = "asdfggfdsasd";
    string b = "1sd";
    int startPos = 0;
    int pos = a.find(b, startPos);  //找到b字符串返回其第一次出现的下标否则返回-1
    printf("%d\n", pos);

    string c = "AAAA";
    a.insert(2,c);  //从a[2] 插入 c
    printf("%s", a.c_str());


    return 0;
}
