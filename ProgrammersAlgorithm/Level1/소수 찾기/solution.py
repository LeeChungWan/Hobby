def solution(n):
    isPrime = [0,0]
    for i in range(n-1):
        isPrime.append(1)
    for j in range(2, n):
        if isPrime[j] == 1:
            index = j + j
            while index <= n:
                isPrime[index] = 0
                index += j
    return sum(isPrime)
