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
    s.erase(2,3); //ɾ����s[2]��s[4] ���ַ�  123456-->126
    printf("%s\n", s.c_str());

    string a = "asdfggfdsasd";
    string b = "1sd";
    int startPos = 0;
    int pos = a.find(b, startPos);  //�ҵ�b�ַ����������һ�γ��ֵ��±���򷵻�-1
    printf("%d\n", pos);

    string c = "AAAA";
    a.insert(2,c);  //��a[2] ���� c
    printf("%s", a.c_str());


    return 0;
}
