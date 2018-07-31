def solution(s):
    stack = []
    isCorrect = False
    isBreak = False
    for bracket in s:
        if bracket == '(':
            stack.append(bracket)
        else:
            if len(stack) is 0:
                isBreak = True
                break
            else:
                stack.remove('(')
    if isBreak:
        return False
    if len(stack) is 0:
        return True
    return False
