case = int(input().strip())
while case:
    size1, size2 = list(map(int, input().strip().split()))

    num1 = list(map(int, input().strip().split()))
    num2 = list(map(int, input().strip().split()))
    result = []
    for i in range(len(num2)):
        if num2[i] in num1:
            count = num1.count(num2[i])
            for j in range(0, count):
                print(num2[i], end=" ")
                num1.remove(num2[i])
    num1.sort()
    for i in range(len(num1)):
        if i == len(num1) -1:
            print(num1[i])
        else:
            print(num1[i], end= " ")
    case -= 1