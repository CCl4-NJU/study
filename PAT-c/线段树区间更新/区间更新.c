#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <algorithm>
#include <iostream>
#define MAXD  50001;

using namespace std;


struct Node{
	int l, r;
	int sum;
	int max, min;
	int add;
}tree[50001 * 4];

void pushUp(int index){
	tree[index].sum = tree[index * 2].sum + tree[index * 2 + 1].sum;
	tree[index].max = max(tree[index * 2].max, tree[index * 2 + 1].max);
	tree[index].min = min(tree[index * 2].min, tree[index * 2 + 1].min);
}
void pushDown(int index){
	if (tree[index].add > 0){
		tree[index * 2].sum += (tree[index * 2].r - tree[index * 2].l + 1)*tree[index].add;
		tree[index * 2 + 1].sum += (tree[index * 2 + 1].r - tree[index * 2 + 1].l + 1)*tree[index].add;
		tree[index * 2].min += tree[index].add;
		tree[index * 2].max += tree[index].add;
		tree[index * 2].add += tree[index].add;
		tree[index * 2 + 1].max += tree[index].add;
		tree[index * 2 + 1].min += tree[index].add;
		tree[index * 2 + 1].add += tree[index].add;
		tree[index].add = 0;
	}

}
void build(int l, int r, int index){
	tree[index].l = l;
	tree[index].r = r;
	tree[index].add = 0;
	if (l == r){
		scanf("%d", &tree[index].sum);
		tree[index].max = tree[index].min = tree[index].sum;
		return;
	}
	int mid = (l + r) / 2;
	build(l, mid, index * 2);
	build(mid +1, r, index * 2+1);
	pushUp(index);
}

void update(int l, int r, int index,int val){
	if (l <= tree[index].l && r >= tree[index].r){
		tree[index].sum += (tree[index].r - tree[index].l + 1)*val;
		tree[index].max += val;
		tree[index].min += val;
		tree[index].add += val;
		return;
	}
	pushDown(index);
	int mid = (tree[index].l + tree[index].r) / 2;
	if (l <= mid){
		update(l, r, index*2, val);
	}
	if (r > mid){
		update(l, r, index * 2+1, val);
	}
	pushUp(index);
}

int query(int l, int r, int index){
	if (l <= tree[index].l && r >= tree[index].r){
		return tree[index].sum;
	}
	pushDown(index);
	int mid = (tree[index].l + tree[index].r) / 2;
	int ans = 0;
	if (l <= mid){
		ans += query(l, r,index * 2);
	}
	if (r > mid){
		ans += query(l, r, index * 2 + 1);
	}
	return ans;
}

int main(){
	int T;
	scanf("%d", &T);
	int j = 1;
	while (T--){
		printf("Case %d:\n", j++);
		int N;
		scanf("%d", &N);
		build(1, N, 1);
		char str[100];
		int a, b, z;
		while (scanf("%s", str)!=EOF){
			if (str[0] == 'Q'){
				scanf("%d%d", &a, &b);
				cout << query(a, b, 1) << endl;
			}
			else if (str[0] == 'A'){
				scanf("%d%d", &a, &b);
				update(a, a, 1, b);
			}else if (str[0] == 'S'){
				scanf("%d%d", &a, &b);
				update(a, a, 1, -b);
			}
			else if (str[0] == 'E'){
				break;
			}
		}
		
	}
}