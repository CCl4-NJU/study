#include <stdio.h>
#define INF 0x7fffffff
int max(int a,int b){
	return a>b?a:b;
}
struct E{
	int w;
	int v;
}list[101];
int dp[101][1001];

int main(){
	int s,n;
	int i,j;
	while(scanf("%d%d", &s,&n)!=EOF){
		for(i=1;i<=n;i++){
			scanf("%d%d", &list[i].w, &list[i].v);
		}
		for(i=0;i<=s;i++){
			dp[0][i] = 0;
		}  //³õÊ¼»¯×´Ì¬
		for(i=1;i<=n;i++){
			for(j=s;j>=list[i].w;j--){
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-list[i].w]+list[i].v);
			}
			for(j=list[i].w-1;j>=0;j--){
				dp[i][j] = dp[i-1][j];
			}
		}
		printf("%d\n",dp[n][s]);
	}
	return 0;
}
