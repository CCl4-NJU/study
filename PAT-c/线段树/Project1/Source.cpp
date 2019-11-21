#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cstdio>
using namespace std;
const int maxn = 50000 + 5;
int sum[4 * maxn];

//i节点收集子节点的统计结果
void PushUp(int i)
{
	sum[i] = sum[i * 2] + sum[i * 2 + 1];
}
//递归建立线段树
void build(int i, int l, int r)
{
	if (l == r)
	{
		scanf("%d", &sum[i]);
		return;
	}
	int m = (l + r) / 2;
	build(i * 2, l, m);
	build(i * 2 + 1, m + 1, r);
	PushUp(i);//收集子节点的结果
	//要时刻记住维护节点统计信息的正确性!!
}
//在当前区间[l,r]内查询区间[ql,qr]间的目标值
//且能执行这个函数的前提是：[l,r]与[ql,qr]的交集不为空
//其实本函数返回的结果也是 它们交集的目标值
int query(int ql, int qr, int i, int l, int r)
{
	if (ql <= l&&r <= qr)
		return sum[i];
	int m = (l + r) / 2;
	int ans = 0;
	if (ql <= m)
		ans += query(ql, qr, i * 2, l, m);
	if (qr>m)//特别注意此处，不是else!!!!!
		ans += query(ql, qr, i * 2 + 1, m + 1, r);
	return ans;
}
//update这个函数就有点定制的意味了
//本题是单点更新，所以实在区间[l,r]内使得第id数的值+val
//如果是区间更新，可以将函数的id参数变为ql,qr
void update(int id, int val, int i, int l, int r)
{
	if (l == r)
	{
		sum[i] += val;
		return;
	}
	int m = (l + r) / 2;
	if (id <= m)
		update(id, val, i * 2, l, m);
	else
		update(id, val, i * 2 + 1, m + 1, r);
	PushUp(i);//要时刻记住维护节点统计信息的正确性!!
}
int main()
{
	int T, n, kase = 0;;
	cin >> T;
	while (T--)
	{
		cin >> n;
		build(1, 1, n);
		for (int i = 1; i <= n * 2 + 1; i++){
			printf("%d ", sum[i]);
		}
		char str[10];
		int x, y;
		printf("Case %d:\n", ++kase);
		while (cin >> str)
		{
			if (str[0] == 'E')
				break;
			scanf("%d%d", &x, &y);
			if (str[0] == 'A')
				update(x, y, 1, 1, n);
			else if (str[0] == 'Q')
				printf("%d\n", query(x, y, 1, 1, n));
			else if (str[0] == 'S')
				update(x, -y, 1, 1, n);
		}
	}
	return 0;
}
