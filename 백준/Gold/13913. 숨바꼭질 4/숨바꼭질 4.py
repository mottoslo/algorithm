import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int,input().split())
path = dict()
que = deque()

if K == N:
    print(0)
    print(K)
    sys.exit()
if K < N:
    print(N-K)
    temp = []
    for i in range(N-K+1):
        temp.append(N-i)
    print(' '.join(map(str,temp)))
    sys.exit()

visited = [0 for i in range(100001)]
que.append((K, 0))
visited[K] = 1

while que:
    now, distance = que.popleft()
    if now == N:
        print(distance)
        break
    if now % 2 == 0 and visited[int(now / 2)] == 0:
        next = int(now / 2)
        que.append((next, distance + 1))
        path[next] = now
        visited[next] = 1
    if now + 1 < 100001 and visited[now + 1] == 0:
        next = now + 1
        que.append((next, distance + 1))
        path[next] = now
        visited[next] = 1
    if 0 <= now - 1 and visited[now - 1] == 0:
        next = now - 1
        que.append((next, distance + 1))
        path[next] = now
        visited[next] = 1

print(N, end = ' ')
idx = N
while path[idx] != K:
    new = path[idx]
    print(new, end = ' ')
    idx = new
print(K)

