def solution(n):
    if n == 0 :
        return 0
    elif n <= 2:
        return 1
    else:
        arr = [1,1]
        for i in range(n-2):
            arr.append(arr[i] + arr[i+1])
        return arr.pop() % 1234567
"""
def fibonacci(num):
    a,b = 0,1
    for i in range(num):
        a,b = b,a+b
    return a
"""
