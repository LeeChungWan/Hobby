"""
올바른 괄호란 두 개의 괄호 '(' 와 ')' 만으로 구성되어 있고, 괄호가 올바르게 짝지어진 문자열입니다.
괄호가 올바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 합니다.
"""
def solution(s):
    answer = True
    isBreak = False
    stack = []
    for i in range(len(s)):
        bracket = s[i:i+1]
        if len(stack) == 0:
            if bracket == ')':
                answer = False
                isBreak = True
                break
            else:
                stack.append(bracket)
        else:
            if bracket == ')':
                stack.pop()
            else:
                stack.append(bracket)
    if isBreak is False:
        if len(stack) != 0:
            answer = False
    return answer
