import sys
from collections import deque

N, M, T = map(int,sys.stdin.readline().split())
world = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

ans = 999999
def bfs():
    global ans
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    queue = deque()
    queue.append((0, 0, 0))
    world[0][0] = 1
    
    while queue:
        x, y, count = queue.popleft()
        if count > T:
            return count
        if x == N-1 and y == M-1:
            return count
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0<= nx < N) and (0 <= ny < M) and (world[nx][ny] != 1):
                queue.append((nx, ny, count + 1))
                if world[nx][ny] == 2:
                    ans = min(ans, count + 1 + N-1-nx + M-1-ny)
                world[nx][ny] = 1
    return ans

cnt = bfs()
ans = min(ans,cnt)
if ans > T:
    print('Fail')
else:
    print(ans)

        
