def solution(a, b, n):
    answer = 0
    
    while(n >= a):
        change_num = (n // a)
        answer += change_num * b
        n = n - (change_num * a) + (change_num * b)
        
        
    
    return answer