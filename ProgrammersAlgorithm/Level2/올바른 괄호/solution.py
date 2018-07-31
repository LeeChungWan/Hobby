def solution(s):
    stack = 0
    isCorrect = False
    isBreak = False
    if len(s) % 2 is 1:
        return False
    for bracket in s:
        if bracket == '(':
            stack += 1
        else:
            if stack is 0:
                isBreak = True
                break
            else:
                stack -= 1
    if isBreak:
        return False
    if stack is 0:
        return True
    return False
