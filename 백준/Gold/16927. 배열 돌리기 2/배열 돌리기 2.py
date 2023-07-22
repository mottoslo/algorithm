import sys

input = sys.stdin.readline

N, M, R = map(int,input().split())
max_layer = int(min(N,M) / 2)
x_max = N-1
y_max = M-1

original = []
for i in range(N):
    original.append(list(map(int,input().split())))
new = [[0 for _ in range(M)] for _ in range(N)]

for layer in range(max_layer):
    x_edge = [layer, N - 1 - layer]
    y_edge = [layer, M - 1 - layer]
    W = M - (layer * 2)
    H = N - (layer * 2)
    ROUND = 2 * (W + H) - 4
    r = R % ROUND
    x,y = layer, layer
    roundnums = []
    for i in range(H-1):
        roundnums.append(original[x + i][y])
    for i in range(W-1):
        roundnums.append(original[x + H - 1][y + i])
    for i in range(H-1, 0, -1):
        roundnums.append(original[x + i][y + W - 1])
    for i in range(W-1, 0, -1):
        roundnums.append(original[x][y + i])
    #### make new
    idx = 0
    for i in range(H-1):
        new[x + i][y] = roundnums[idx - r] if (idx - r) >= 0 else roundnums[-(r - idx)]
        idx += 1
    for i in range(W-1):
        new[x + H - 1][y + i] = roundnums[idx - r] if (idx - r) >= 0 else roundnums[-(r - idx)]
        idx += 1
    for i in range(H-1, 0, -1):
        new[x + i][y + W - 1] = roundnums[idx - r] if (idx - r) >= 0 else roundnums[-(r - idx)]
        idx += 1
    for i in range(W-1, 0, -1):
        new[x][y + i] = roundnums[idx - r] if (idx - r) >= 0 else roundnums[-(r - idx)]
        idx += 1

for line in new:
    print(*line, sep = ' ')

