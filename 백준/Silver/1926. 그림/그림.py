import sys
sys.setrecursionlimit(1000000)
#입력
N, M = map(int, sys.stdin.readline().split())
visited = [[0] * M for _ in range(N)]

map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
MAXSIZE = 0; size = 0
anscnt = 0

def dfs(x,y):
    global anscnt, size

    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx < N) and (0 <= ny < M) and visited[nx][ny] == 0:
            if map[nx][ny] == 0:
                visited[nx][ny] = 1
                continue
            else:
                visited[nx][ny] = 1
                size += 1
                dfs(nx,ny)


for x in range(N):
    for y in range(M):
        if visited[x][y] == 1:
            continue
        if map[x][y] == 0:
            continue
        else:
            visited[x][y] = 1
            size = 1
            dfs(x,y)
            MAXSIZE = max(MAXSIZE, size)
            anscnt += 1

print(anscnt)
print(MAXSIZE)
