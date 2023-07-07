from collections import deque
import sys
sys.setrecursionlimit(10000000)

def dfs(computers, thisComp, compSet):
    for i, network in enumerate(computers[thisComp]):
        if network == 1 and compSet.__contains__(i):
            compSet.remove(i)
            dfs(computers, i, compSet)

def solution(n, computers):
    ans = 0
    compSet = set()
    for i in range(n):
        compSet.add(i)
    
    while(len(compSet) > 0):
        thisComp = compSet.pop()
        dfs(computers, thisComp, compSet)
        ans += 1
    
    return ans