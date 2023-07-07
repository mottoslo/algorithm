import sys
from collections import deque
input = sys.stdin.readline

visited = set()
dx = [0,0,-1,1]
dy = [1,-1,0,0]
que = deque()


def bfs(N,M,maps):
    while(len(que) != 0):
        x, y, score = que.popleft()
        if x == N-1 and y == M-1:
            return score
    
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if (0 <= nx < N) and (0<= ny < M):
                if(maps[nx][ny] == 1 and visited.__contains__((nx,ny)) == False):
                    que.append((nx,ny, score + 1))
                    visited.add((nx,ny))
    return -1
    
    


def solution(maps):
    N = len(maps)
    M = len(maps[0])
    
    que.append((0,0, 1))
    visited.add((0,0))
    answer = bfs(N,M,maps)
    return answer