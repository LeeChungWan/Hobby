def solution(n):
    n_to_list = ([x for x in str(n)])
    sorted_list = sorted(n_to_list, reverse = True)
    return int(''.join(sorted_list))
