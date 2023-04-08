def solution(participant, completion):
    
    participant.sort()
    completion.sort()
    if len(completion) == 0:
        return participant[0]
    if participant[-1] != completion[-1]:
        return participant[-1]
    else:
        for i,name in enumerate(participant):
            if name != completion[i]:
                return name
        
    answer = participant[0]
    return answer
    
        
            