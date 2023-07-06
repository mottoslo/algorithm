import sys
sys.setrecursionlimit(1000000)
#입력
N, M = map(int, sys.stdin.readline().split())
coordSet = set()
for i in range(N):
    for j in range(M):
        coordSet.add((i,j))

map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
MAXSIZE = 0; size = 0
anscnt = 0

def dfs(x,y):
    global anscnt, size


    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx < N) and (0 <= ny < M) and coordSet.__contains__((nx, ny)):
            if map[nx][ny] == 0:
                coordSet.remove((nx,ny))
                continue
            else:
                coordSet.remove((nx,ny))
                size += 1
                dfs(nx,ny)


while(len(coordSet) != 0):
    x,y = coordSet.pop()
    if map[x][y] == 0:
        continue
    else:
        size = 1
        dfs(x,y)
        MAXSIZE = max(MAXSIZE, size)
        anscnt += 1

print(anscnt)
print(MAXSIZE)


