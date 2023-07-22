import sys

input = sys.stdin.readline

N, C = map(int,input().split())

#각 마을에서 도착지점을 확인해서 그리디하게 싣으면 안됨 (1번마을에서 맨끝마을에 9999개 배송시, 끝까지 칸을 차지하게 됨)
#애초에 계획을 세우고 가야한다. (도착지가 2번마을인거 최대한 많이 싣고 출발) -> 2번마을에서 내리고, 다음 가까운 도착지별로 싣는다고 (가정)한다. 출발지를 고려하지 않아야함

M = int(input())
INFO = []
for i in range(M):
    INFO.append(tuple(map(int,input().split())))

INFO.sort(key = lambda x : (x[1], x[0]))

#[도착지1, 도착지2 ...]
plan_idx = 0
now_idx = 1
capacity = C
nowbox = 0
shipoff = [0 for _ in range(N+1)]
result = 0
while(now_idx < N+1):
    if shipoff[now_idx] > 0:
        nowbox -= shipoff[now_idx]

    while(nowbox < C and plan_idx < M):
        departure, destination, numbox = INFO[plan_idx]
        if departure < now_idx:
            plan_idx += 1
            continue
        if numbox + nowbox <= C:
            nowbox += numbox
            shipoff[destination] += numbox
            plan_idx +=1
        else:
            INFO[plan_idx] = (departure, destination, numbox - (C-nowbox))
            shipoff[destination] += C - nowbox
            nowbox = C
    now_idx += 1

print(sum(shipoff))
    

