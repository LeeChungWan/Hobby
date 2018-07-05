def solution(n):
    count = 1
    for i in range(1, n):
        j = i
        added = j
        while added != n:
            j += 1
            added += j
            if added == n:
                count += 1
                break
            elif added > n:
                break
    return count
