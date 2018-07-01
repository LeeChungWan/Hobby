def solution(strings, n):
    strings.sort()
    answer = sorted(strings, key = lambda strings: strings[n])
    return answer
