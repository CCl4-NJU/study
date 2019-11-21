#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cstdio>
using namespace std;
const int maxn = 50000 + 5;
int sum[4 * maxn];

//i�ڵ��ռ��ӽڵ��ͳ�ƽ��
void PushUp(int i)
{
	sum[i] = sum[i * 2] + sum[i * 2 + 1];
}
//�ݹ齨���߶���
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
	PushUp(i);//�ռ��ӽڵ�Ľ��
	//Ҫʱ�̼�סά���ڵ�ͳ����Ϣ����ȷ��!!
}
//�ڵ�ǰ����[l,r]�ڲ�ѯ����[ql,qr]���Ŀ��ֵ
//����ִ�����������ǰ���ǣ�[l,r]��[ql,qr]�Ľ�����Ϊ��
//��ʵ���������صĽ��Ҳ�� ���ǽ�����Ŀ��ֵ
int query(int ql, int qr, int i, int l, int r)
{
	if (ql <= l&&r <= qr)
		return sum[i];
	int m = (l + r) / 2;
	int ans = 0;
	if (ql <= m)
		ans += query(ql, qr, i * 2, l, m);
	if (qr>m)//�ر�ע��˴�������else!!!!!
		ans += query(ql, qr, i * 2 + 1, m + 1, r);
	return ans;
}
//update����������е㶨�Ƶ���ζ��
//�����ǵ�����£�����ʵ������[l,r]��ʹ�õ�id����ֵ+val
//�����������£����Խ�������id������Ϊql,qr
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
	PushUp(i);//Ҫʱ�̼�סά���ڵ�ͳ����Ϣ����ȷ��!!
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
