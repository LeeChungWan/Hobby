def solution(n):
    intToStr = str(n)
    answer = 0
    for i in range(len(intToStr)):
        answer += int(intToStr[i])
    return answer
