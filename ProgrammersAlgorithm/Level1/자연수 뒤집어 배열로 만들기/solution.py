def solution(n):
    answer = []
    intTostr = str(n)
    for i in range(len(intTostr)):
        answer.insert(0, int(intTostr[i]))
    return answer
#   return [int(x) for x in str(n)[::-1]]
