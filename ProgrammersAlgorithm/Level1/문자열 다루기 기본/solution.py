"""
문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요.
예를들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
"""
def solution(s):
    answer = True
    s_len = len(s)
    if s_len != 4 and s_len != 6:
        answer = False
    else:
        answer = s.isnumeric()
    return answer
