def solution(s, n):
    # 아스키코드 a-z : 97-122, A-Z : 65-90
    answer = ''
    for word in s.split(' '):
        for i in range(len(word)):
            changed = ord(word[i]) + n
            # 대문자인 경우.
            if word[i].isupper():
                if changed > 90:
                    changed -= 26
            else:
                if changed > 122:
                    changed -= 26
            answer += chr(changed)
        answer += ' '
    return answer[:-1]
