# https://open.kattis.com/problems/apivotalquestion
def aPivotalQuestion(string):
    string = string.split()
    for i in range(len(string)):
        string[i] = int(string[i])
    sizeOfArray = string[0]
    array = string[1:]
    potentialPivotValues = 0
    pivotValues = ""
    maxValue = array[0]
    minValue = 2147483647
    maxValues = []
    minValues = []
    for i in range(sizeOfArray):
        if array[i] >= maxValue:
            maxValue = array[i]
            maxValues.append(maxValue)
        else:
             maxValues.append(maxValue)
        if array[sizeOfArray - i - 1] <= minValue:
            minValue = array[sizeOfArray - i -1]
            minValues.append(minValue)
        else:
             minValues.append(minValue)
    for m in range(sizeOfArray):
        if maxValues[m] <= array[m] and array[m] <= minValues[sizeOfArray - m  - 1]:
                potentialPivotValues += 1
                if potentialPivotValues <= 100:
                    pivotValues = pivotValues + " " + str(maxValues[m])
    return str(potentialPivotValues) + pivotValues
userInput = input("")
output = aPivotalQuestion(userInput)
print(output)
