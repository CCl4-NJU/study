#include <iostream>
#include <stdio.h>
#include <string.h>
#include <algorithm>

#define ISYEARP(x) x%100!=0 && x%4==0 || x%400 == 0?1:0
int dayOfMonth[13][2] = {
    0,0,
    31,31,
    28,29,
    31,31,
    30,30,
    31,31,
    30,30,
    31,31,
    31,31,
    30,30,
    31,31,
    30,30,
    31,31,
};
struct Date{
    int day;
    int month;
    int year;
    void nextDay(){
        day++;
        if(day > dayOfMonth[month][ISYEARP(year)]){
            day = 1;
            month++;
            if(month > 12){
                month = 1;
                year++;
            }
        }
    }
};
int buf[5000][13][32];

char monthName[13][20] = {
    "",
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
};
char week[7][20] = {
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
};

using namespace std;

int main()
{
    Date tmp;
    tmp.day = 1;
    tmp.month = 0;
    tmp.year = 0;
    int cnt = 0;
    char s[20];
    int d;
    int y;
    int m;
    while(tmp.year != 5000){
        buf[tmp.year][tmp.month][tmp.day] = cnt;
        tmp.nextDay();
        cnt++;
    }
    while(scanf("%d%s%d", &d, s, &y) !=EOF){
        for(int i=0;i<13;i++){
            if( strcmp(s, monthName[i]) == 0){
                m = i;
            }
        }
        int cha = buf[y][m][d]- buf[2018][4][8];//找一个周日
        printf("%s\n", week[((cha%7)+7)%7]);
    }
    return 0;
}
