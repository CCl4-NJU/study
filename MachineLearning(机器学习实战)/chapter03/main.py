from chapter03.trees import *
from chapter03.treePlotter import *

if __name__ == '__main__':
    myDat, labels = createDataSet()
    print(calcShannonEnt(myDat))
    print(splitDataSet(myDat, 0, 1))
    myTree = retrieveTree(0)
    createPlot(myTree)