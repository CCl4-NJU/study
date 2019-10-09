import matplotlib
import matplotlib.pyplot as plt
from chapter02.kNN import *
import numpy as np

if __name__ == '__main__':
    testVector = img2vector("../machinelearninginaction/Ch02/digits/testDigits/0_13.txt")
    print(testVector[0,0:31])
    handwritingClassTest()
