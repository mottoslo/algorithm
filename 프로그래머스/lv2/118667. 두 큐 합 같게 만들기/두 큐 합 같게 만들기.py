import collections
def solution(queue1, queue2):
    answer = -1
    q1length = len(queue1)
    q2length = len(queue2)
    totalq = queue1 + queue2
    p1 = 0;
    p2 = q1length;
    tempsum = sum(queue1)
    totalsum = sum(totalq)
    targetsum = totalsum / 2
    if (totalsum % 2)!=0:
        return -1
    
    while((tempsum != targetsum) and (p1 <= p2)):
        if tempsum > targetsum:
            tempsum -= totalq[p1]
            p1 +=1
        else:
            if p2 < len(totalq):
                tempsum += totalq[p2]
                p2 += 1
            else:
                p2 += 1
                break
    if (targetsum == tempsum):
        return (p1) + ((p2) % q1length)
    else:
        return -1
