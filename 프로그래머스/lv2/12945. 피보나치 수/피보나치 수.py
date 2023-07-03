def solution(n):
    if n == 2:
        return 1
    fL = 1; fR = 1
    answer = 0
    for i in range(3, n + 1):
        answer = (fL + fR) % 1234567
        fL = fR
        fR = answer
    return answer