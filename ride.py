"""
ID: yaoameg1
LANG: PYTHON3
TASK: ride
"""
import sys

def userInput(names):
    names = names.split()
    return names[0], names[1]

def nameToNumber(name):
    numberEquivOfName = 1
    letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
    numbers = list(range(1, 27))
    for i in range(len(letters)):
        for j in name:
            if j == letters[i]:
                numberEquivOfName *= numbers[i]
    return numberEquivOfName

def stayOrGo(cometName, groupName):
    groupNameToNum = nameToNumber(groupName)
    cometNameToNum = nameToNumber(cometName)
    if groupNameToNum % 47 == cometNameToNum % 47:
        return "GO"
    else:
        return "STAY"

def main():
    fin = open ('ride.in', 'r')
    fout = open ('ride.out', 'w')
    names = []
    for line in fin:
        names.append(line)
        for i in range(len(names)):
            names[i] = names[i].strip("\n")
    fout.write(stayOrGo(names[0], names[1]) + "\n")

if __name__== "__main__":
    main()