from numpy import *


array1 = random.rand(4, 4)
print(array1)

randMat = mat(array1)  # 数组转化为矩阵matrix
print(randMat.I)  # 矩阵的逆
print(randMat * randMat.I)  #矩阵乘矩阵的逆

eye = eye(4)  # 4*4单位矩阵
print(eye)
print(randMat * randMat.I - eye)