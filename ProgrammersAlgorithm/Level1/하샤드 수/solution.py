def solution(x):
    sum_list = sum([int(x) for x in str(x)])
    if x % sum_list == 0 :
        return True
    return False
