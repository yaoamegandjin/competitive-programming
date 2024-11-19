# Problem link: https://open.kattis.com/problems/antipalindrome?tab=submissions
import re

def antiPalindrome(text):
    c = ""
    joinedText = ""
    nonAlphabetic = re.findall(r'[^a-zA-Z]', text)
    for i in nonAlphabetic:
        c += i
    newText = text.lower().split()
    for j in range(len(newText)):
        newText[j] = newText[j].strip(c)
    for m in newText:
        joinedText += m
    k = "Anti-palindrome"
    for n in range(len(joinedText)):
        if n + 1 <= len(joinedText) - 1:
             if joinedText[n] == joinedText[n + 1]:
                k = "Palindrome"
        if n + 2 <= len(joinedText) - 1:
           if joinedText[n] == joinedText[n + 2]:
                k = "Palindrome"
    return k

userInput = input("")
palinOrNot = antiPalindrome(userInput)
print(palinOrNot)
