import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())

def dn(n):
    return 1 + 4*(n-1)

def hNext(hN, now):
    return hN + dn(now+1)

hN = 1; i = 1
hval = [] 
while(hN <= N):
    hval.append(hN)
    hN = hNext(hN, i)
    i += 1

anslst = [1,2,3,4,5] + [9999 for _ in range(N)]
for k in hval:
    anslst[k - 1] = 1

for k in hval:
    for i in range(k+1, N):
        anslst[i] = min(anslst[i - k] + 1, anslst[i])

# for i in range(1, N):
#     num = 99999
#     for k in hval:
#         if i < k:
#             break
#         anslst[i] = min(anslst[i - k] + 1, anslst[i])

print(anslst[N-1])