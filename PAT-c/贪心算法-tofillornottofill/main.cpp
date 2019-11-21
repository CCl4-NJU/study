#include <stdio.h>
#include <algorithm>
#include <math.h>

typedef struct gas_station{
    double price;
    int dis;
    friend bool operator < (struct gas_station a, struct gas_station b){
        return a.dis < b.dis;
    }
} Gs;

int main(){
    //freopen("in/1437.in","r",stdin);
    int Cmax,D,Davg,N;
    Gs gs[510];
    while( scanf("%d %d %d %d",&Cmax,&D,&Davg,&N) !=EOF ){
        for (int i = 0; i < N; ++i) scanf("%lf %d",&gs[i].price, &gs[i].dis) ;
        std::sort(gs,gs+N);
        if(gs[0].dis > 0){
            printf("The maximum travel distance = 0.00\n");
            continue;
        }

        gs[N].dis = D;
        gs[N].price =  999999999.0;
        double sum =0.0, remain_gas = 0.0;
        int step = Cmax * Davg,i,k;
        for ( i = 0; i < N; ++i) {
            k = i+1;
            //arrive at i
            if(i!=0)  remain_gas -= ((double)(gs[i].dis - gs[i-1].dis))/Davg;
            //select next gs to charge and decide charge how much gas at i statition
            for (;k<N && gs[k].price >= gs[i].price ; k++) continue;
            if(gs[k].dis - gs[i].dis > step){
                sum += (Cmax - remain_gas) * gs[i].price;
                remain_gas = Cmax;
            }else{
                double gas_gap_i_to_k = ((double)(gs[k].dis - gs[i].dis))/Davg - remain_gas ;
                if(fabs(gas_gap_i_to_k) >=1e-5 && gas_gap_i_to_k > 0){
                    sum += gas_gap_i_to_k* gs[i].price;
                    remain_gas += gas_gap_i_to_k;
                }
            }

            if(gs[i+1].dis - gs[i].dis > step) {
                printf("The maximum travel distance = %.2f\n",(double)(gs[i].dis+step));
                break;
            }
        }
        if(i==N) printf("%.2f\n",sum);
    }
    return 0;

}
