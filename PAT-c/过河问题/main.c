#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <algorithm>
#include <iostream>

using namespace std;
int a[1001];
int main(){
	int T;
	int N;
	scanf("%d", &T);
	while (T--){
		scanf("%d", &N);
		for (int i = 0; i < N; i++){
			scanf("%d", &a[i]);
		}
		sort(a, a + N);
		int f = 0;
		while (N){
			if (N == 1){
				f += a[0];
				break;
			}
			if (N == 2){
				f += a[1];
				break;
			}
			if (N == 3){
				f += a[0] + a[1] + a[2];
				break;
			}
			if (N >= 4){
				f += min(2 * a[0] + a[N - 1] + a[N - 2], 2*a[1] + a[0] + a[N - 1]);
				N = N - 2;
			}
		}
		cout << f << endl;
	}
}