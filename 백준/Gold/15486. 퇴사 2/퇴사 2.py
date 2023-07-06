import sys

N = int(sys.stdin.readline())
T = []
P = []
F = [0 for _ in range(N)]

for i in range(N):
    t, p = map(int, sys.stdin.readline().split())
    T.append(t)
    P.append(p)
    

def calcF(n):

    p_n = P[n]
    endDate = n + T[n] - 1
    freeDate = endDate + 1
    afterProfit = F[freeDate] if freeDate <= N-1 else 0
    if endDate <= N-1:
        return max(p_n + afterProfit, F[n+1])
    else:
        return F[n+1]
    

if T[-1] == 1:
    F[-1] = P[-1]
else:
    F[-1] = 0

for day in range(N-2, -1,-1):
    F[day] = calcF(day)

print(F[0])
    
    
    

