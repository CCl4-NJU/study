import numpy as np
import operator
import os


# 创造数据集，为其打标签
def createDataSet():
    group = np.array([[1.0, 1.1], [1.0, 1.0], [0, 0], [0, 0.1]])
    labels = ['A', 'A', 'B', 'B']
    return group, labels


def classify0(inX, dataSet, labels, k):
    dataSetSize = dataSet.shape[0]
    diffMat = np.tile(inX, (dataSetSize, 1)) - dataSet
    sqDiffMat = diffMat ** 2
    sqDistances = sqDiffMat.sum(axis=1)  # [2.21, 2., 0., 0.01]
    distances = sqDistances ** 0.5  # [1.48660687, 1.41421356, 0. , 0.1]
    sortedDistIndicies = distances.argsort()  # [2 3 1 0] 索引根据数值大小排序
    classCount = {}
    for i in range(k):
        voteIlabel = labels[sortedDistIndicies[i]]
        classCount[voteIlabel] = classCount.get(voteIlabel, 0) + 1  # dic.get(key, 0)不存在则返回0

    sortedClassCount = sorted(classCount.items(), key=operator.itemgetter(1), reverse=True)  # 字典排序
    return sortedClassCount[0][0]


def file2matrix(filename):
    fr = open(filename)
    arrayOLines = fr.readlines()
    numberOfLines = len(arrayOLines)
    returnMat = np.zeros((numberOfLines, 3))
    classLabelVector = []
    index = 0
    for line in arrayOLines:
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index, :] = listFromLine[0:3]
        classLabelVector.append(int(listFromLine[-1]))
        index += 1
    return returnMat, classLabelVector


def autoNorm(dataSet):
    minVals = dataSet.min(0)
    maxVals = dataSet.max(0)
    ranges = maxVals - minVals
    normDataSet = np.zeros(np.shape(dataSet))
    m = dataSet.shape[0]
    normDataSet = dataSet - np.tile(minVals, (m, 1))
    normDataSet = normDataSet / np.tile(ranges, (m, 1))
    return normDataSet, ranges, minVals


def datingClassTest():
    hoRaio = 0.1
    datingDataMat, datingLabels = file2matrix('../machinelearninginaction/Ch02/datingTestSet2.txt')
    normMat, ranges, minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int(m * hoRaio)
    errorCount = 0.0
    for i in range(numTestVecs):
        classifierResult = classify0(normMat[i, :], normMat[numTestVecs:m, :], datingLabels[numTestVecs:m], 3)
        print("the classifier came back with: %d, the real answer is: %d" % (classifierResult, datingLabels[i]))
        if (classifierResult != datingLabels[i]):
            errorCount += 1.0
    print("the total error rate is: %f" % (errorCount / float(numTestVecs)))


def classifyPerson():
    resultList = ['not at all', 'in small does', 'in large soses']
    percentTats = float(input("percentage of time spent playing video games?"))
    ffMiles = float(input("frequent flier miles earned per year?"))
    iceCream = float(input("liters of ice cream consumed per year?"))
    datingDataMat, datingLabels = file2matrix("../machinelearninginaction/Ch02/datingTestSet2.txt")
    normMat, ranges, minVals = autoNorm(datingDataMat)
    inArr = np.array([ffMiles, percentTats, iceCream])
    classifierResult = classify0(inArr - minVals, normMat, datingLabels, 3)
    print("You will probably like this person: ", resultList[classifierResult - 1])


def img2vector(filename):
    returnVect = np.zeros((1, 1024))
    print(returnVect)
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVect[0, 32 * i + j] = int(lineStr[j])
    return returnVect


def handwritingClassTest():
    hwLabels = []
    traingFileList = os.listdir('../machinelearninginaction/Ch02/digits/trainingDigits')
    m = len(traingFileList)
    traingMat = np.zeros((m, 1024))
    for i in range(m):
        fileNameStr = traingFileList[i]
        print(fileNameStr)
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        traingMat[i, :] = img2vector("../machinelearninginaction/Ch02/digits/trainingDigits/" + fileNameStr)

    testFileList = os.listdir('../machinelearninginaction/Ch02/digits/testDigits')
    errorCount = 0.0
    mTest = len(testFileList)
    for i in range(mTest):
        fileNameStr = testFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        vectorUnderTest = img2vector("../machinelearninginaction/Ch02/digits/testDigits/" + fileNameStr)
        classifierResult = classify0(vectorUnderTest, traingMat, hwLabels, 3)
        print("the classifier came back with:%d, the real answer is: %d" % (classifierResult, classNumStr))
        if(classifierResult != classNumStr):
            errorCount += 1.0
    print("\nthe total number of errors is:%d" % errorCount)
    print("\nthe total number of errors rate is:%f" % (errorCount/float(mTest)))