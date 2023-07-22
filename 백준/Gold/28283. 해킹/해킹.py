import sys
from collections import deque
from collections import defaultdict
input = sys.stdin.readline

N, M, X, Y = map(int,input().split())

value = list(map(int,input().split()))
network = defaultdict(list)

for i in range(M):
    s, e = map(int,input().split())
    network[s-1].append(e-1)
    network[e-1].append(s-1)

B = list(map(int,input().split()))
unprotected_computers = set(range(0, N))
time_boan = [999999 for _ in range(N)]
boan_visited = [0 for _ in range(N)]
boan_que = deque()
for b in B:
    boan_visited[b - 1] = 1
    time_boan[b - 1] = 0.5
    boan_que.append((b - 1, 0.5))
    unprotected_computers.remove(b - 1)

while boan_que:
    this_computer, nowtime = boan_que.popleft()
    for connected_computer in network[this_computer]:
        if boan_visited[connected_computer] == 0:
            time_boan[connected_computer] = nowtime + 1
            boan_que.append((connected_computer, nowtime + 1))
            boan_visited[connected_computer] = 1
            unprotected_computers.remove(connected_computer)

if len(unprotected_computers) != 0: #보안이 안닿는 컴퓨터가 있어도 얻을 수 있는돈이 무한인지는 확인해봐야함
    for unprotected_computer in unprotected_computers:
        if value[unprotected_computer] != 0:
            print(-1)
            sys.exit()

anstable = sorted((int(time_boan[i]) * value[i] for i in range(N)), reverse=True)
print(sum(anstable[:X]))