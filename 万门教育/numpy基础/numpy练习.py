import numpy as np
import array

a = array.array('i', range(10))
print(a[0])

a_list = list(range(10))
b = np.array(a_list)
print(b)

print(np.zeros((4, 4), dtype=int))
print(np.zeros((4, 4), dtype=float))
print(np.ones((4, 4), dtype=float))
print(np.full((4, 3), 3.14))
print(np.full((4, 3), 3.14))
print(np.zeros_like(b))
print(np.ones_like(b))
print(np.full_like(b, 5, dtype=float))

print(np.random.random((3, 3)))
print(np.random.randint(0, 10, (3, 3)))

print(list(range(0, 10, 2)))  # 范围取值 步长为2

print(np.arange(0, 10, 2))  #
print(np.linspace(0, 10, 20))  # 范围取值 20个
print(np.eye(5))  # 5阶单位矩阵

a = np.array(np.random.random((3, 4)))
print(a)
print(a[:2, :2])  # 前两行前两列
print(a[:, 2])  # 所有行第二列
print(a.ndim)  # 维度
print(a.shape)
print(a.size)  # 行*列
print(a.dtype)
print(np.sum(a))  # 全部
print(np.sum(a, axis=1))  # 行
print(np.sum(a, axis=0))  # 列
print(a > 0.5)
print(np.all(a > 0.5))
print(np.any(a > 0.5))

print(a.reshape(1, 12))
print(np.sort(a))

print(np.concatenate([a, a, a], axis=0)) #拼接
