def solution(s):
    arr = [int(x) for x in s.split()]
    min_num = min(arr)
    max_num = max(arr)
    return str(min_num) + " " + str(max_num)
