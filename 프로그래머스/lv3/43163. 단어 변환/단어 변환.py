import sys
from collections import deque

def comp(word1, word2):
    cnt = 0
    for i in range(len(word1)):
        if not word1[i] == word2[i]:
            cnt += 1
    return cnt

def bfs(que, target, words,visited):
    while(len(que) > 0):
        thisword, depth = que.pop()
        if thisword == target:
            return depth
        for w in words:
            if visited.__contains__(w) is False and comp(thisword, w) == 1:
                visited.add(w)
                que.append((w, depth + 1))
                
def solution(begin, target, words):
    if target not in words:
        return 0
    wordlen = len(words)
    que = deque()
    que.append((begin, 0))
    visited = set()
    ans = bfs(que, target, words,visited)
    
    return ans
            
        