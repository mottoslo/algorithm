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
    if n == N-1:
        if T[n] == 1:
            return P[n]
        else:
            return 0
    
    p_n = P[n]
    endDate = n + T[n] - 1
    freeDate = endDate + 1
    afterProfit = F[freeDate] if freeDate <= N-1 else 0
    if endDate <= N-1:
        return max(p_n + afterProfit, F[n+1])
    else:
        return F[n+1]
    

for day in range(N-1, -1,-1):
    F[day] = calcF(day)
print(F[0])