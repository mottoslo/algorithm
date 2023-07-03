def solution(seoul):
    answer = 1
    for i in range(len(seoul)):
        if seoul[i] == "Kim":
            answer = f'김서방은 {i}에 있다'
    return answer