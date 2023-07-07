import sys
from collections import deque

que = deque()
def bfs(numbers, target):
    ans = 0
    length = len(numbers)
    que.append((numbers[0], 0))
    que.append((-numbers[0], 0))
    while(len(que) > 0):
        total, depth = que.popleft()            
        if depth == length - 1:
            if total == target:
                ans += 1
        else:
            que.append((total + numbers[depth + 1], depth+1))
            que.append((total - numbers[depth + 1], depth+1))
    return ans
    
            

def solution(numbers, target):
    ans = bfs(numbers, target)
    return ans