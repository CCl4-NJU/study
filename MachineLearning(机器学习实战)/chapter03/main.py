from chapter03.trees import *

if __name__ == '__main__':
    myDat, labels = createDataSet()
    print(calcShaannonEnt(myDat))