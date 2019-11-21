#include <windows.h>
#include <stdio.h>
#include <string.h>
char YN(int k) {
    FILE *f;
    char fn[40];
    char ln[80];
    char yn;
    int n;
    yn='N';
    sprintf(fn,"d:\\ping%d.txt",k);
    f=fopen(fn,"r");
    if (NULL!=f) {
        n=0;
        while (1) {
            if (NULL==fgets(ln,80,f)) break;//
            if (strstr(ln,"ms ")) {
                yn='Y';
                break;//
            }
            n++;
            if (n>=4) break;//
        }
        fclose(f);
    }
    return yn;
}
void main(int argc,char **argv) {
    char cmdstr[256];
    int i;
    int IP[3];
    char c;
    if (argc<2) {
    USAGE:
        printf("Usage example:\n    %s 192.168.60.\nto test 192.168.60.1-254\n",argv[0]);
        return;
    }
    if (4==sscanf(argv[1],"%d.%d.%d%c",&IP[0],&IP[1],&IP[2],&c)) {
        if (0<=IP[0] && IP[0]<=255
         && 0<=IP[1] && IP[1]<=255
         && 0<=IP[2] && IP[2]<=255
         && '.'==c) {
            for (i=1;i<255;i++) {
                sprintf(cmdstr,"cmd /c ping %s%d -n 1 -w 1000 >d:\\ping%d.txt",argv[1],i,i);
                WinExec(cmdstr,SW_HIDE);
            }
            Sleep(3000);
            for (i=1;i<255;i++) {
                printf("%c %s%d\n",YN(i),argv[1],i);
            }
            Sleep(3000);
            WinExec("cmd /c del /q d:\\ping*.txt",SW_HIDE);
        } else goto USAGE;
    } else goto USAGE;
}
