from fractions import gcd
def solution(n, m):
    answer = [gcd(n,m),n*m/gcd(n,m)]
    """
    c, d = max(n, m), min(n, m)
    t = 1
    while t > 0:
        t = c % d
        c, d = d, t
    answer = [c, int(a*b/c)]
    """
    return answer
