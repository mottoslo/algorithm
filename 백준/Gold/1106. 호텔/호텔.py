import sys

input = sys.stdin.readline

C,N = map(int,input().split())
cost = []
client = []

max_client = 0

for i in range(N):
    a, b = map(int,input().split())
    cost.append(a)
    client.append(b)
    max_client = max(max_client, b)

DP = [999999 for _ in range(C + max_client)]
DP[0] = 0

for target in range(C + max_client):
    for n,c in sorted(zip(client,cost), key = lambda x : x[0] / x[1]):
        if target - n >= 0:
            DP[target] = min(DP[target], DP[target-n] + c)

print(min(DP[C:]))

    