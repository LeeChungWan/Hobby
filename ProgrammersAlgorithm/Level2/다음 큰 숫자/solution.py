def solution(n):
    binary_num = bin(n)[2:]
    arr_num = [int(x) for x in binary_num]
    num_of_one = sum(arr_num)
    while True:
        n += 1
        compare_num = sum([int(x) for x in bin(n)[2:]])
        if num_of_one == compare_num:
            return n
"""
def solution(n):
    binary_num = bin(n).count('1')
    while True:
        n += 1
        compare_num = bin(n).count('1')
        if binary_num == compare_num:
            return n
"""
