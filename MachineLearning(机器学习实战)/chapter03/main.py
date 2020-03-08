from chapter03.trees import *
from chapter03.treePlotter import *

if __name__ == '__main__':
    myDat, labels = createDataSet()
    myTree = createTree(myDat, labels)
    print(myTree)
    createPlot(myTree)