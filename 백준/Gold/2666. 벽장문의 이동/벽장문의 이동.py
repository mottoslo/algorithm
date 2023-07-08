import sys
from itertools import combinations

input = sys.stdin.readline

N = int(input())
l, r = map(int, input().split())
destinationNum = int(input())
destinationList = []
for i in range(destinationNum):
    destinationList.append(int(input()))
ans = 9999999999

def dfs(depth, l, r, moves):
    if depth == destinationNum:
        global ans ; ans = min(ans, moves)
        return 
    else:
        nxtdoor = destinationList[depth]
        if l < nxtdoor < r:
            dfs(depth + 1, l, nxtdoor, moves + abs(r - nxtdoor))
            dfs(depth + 1, nxtdoor, r, moves + abs(l - nxtdoor))
        else:
            if nxtdoor <= l:
                dfs(depth + 1, nxtdoor, r, moves + abs(l - nxtdoor))
            else:
                dfs(depth + 1, l, nxtdoor, moves + abs(r - nxtdoor))

dfs(0, l, r, 0)
print(ans)