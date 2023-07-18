import sys
from collections import deque
input = sys.stdin.readline

W, H = map(int,input().split())
N = int(input())
ENERGY = [[0 for _ in range(H)] for _ in range(W)]
INFO = [[0 for _ in range(H)] for _ in range(W)]
redstone_dust = set()
redstone_block = set()
redstone_lamp = set() # 불이 꺼진 lamp들을 모아놓기
                      # lamp는 한번 불이켜지면 계속 켜진다. (block이 계속 에너지 주니까)

# dust = 1 block = 2 lamp = 3
actionque = deque()

for i in range(N):
    stone, x, y = input().split()
    x, y = map(int,(x, y))
    if stone == 'redstone_dust':
        INFO[x][y] = 1
        redstone_dust.add((x,y))
    
    elif stone == 'redstone_block':
        ENERGY[x][y] = 15
        INFO[x][y] = 2
        actionque.append((x,y,2))  # redstone block은 actionque에 최초 1회만 넣어줌
                                    # 최초 1회 전달에서 안되면 그 이후에도 안되기때문

    elif stone == 'redstone_lamp':
        INFO[x][y] = 3
        redstone_lamp.add((x,y))

########################################################################################
dx = [1,-1,0,0]
dy = [0,0,1,-1]

def do_dust(x, y, actionque):
    myenergy = ENERGY[x][y]
    if myenergy > 1:
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < W and 0 <= ny < H:
                if INFO[nx][ny] == 1 and myenergy - 1 > ENERGY[nx][ny] :
                    ENERGY[nx][ny] = myenergy - 1
                    actionque.append((nx, ny, 1))
                elif INFO[nx][ny] == 3:
                    actionque.append((nx, ny, 3))

def do_block(x, y, actionque):
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < W and 0 <= ny < H:
            if INFO[nx][ny] == 1:   #dust
                ENERGY[nx][ny] = 15
                actionque.append((nx, ny, 1))
            elif INFO[nx][ny] == 3:  #lamp
                actionque.append((nx, ny, 3))

def do_lamp(x, y, lampset : set):
    lampset.discard((x,y))

while(len(actionque) > 0 and len(redstone_lamp) > 0):
    x, y, type = actionque.popleft()
    if type == 1:
        do_dust(x, y, actionque)
    elif type == 2:
        do_block(x, y, actionque)
    elif type == 3:
        do_lamp(x, y, redstone_lamp)

if len(redstone_lamp) == 0:
    print('success')
else:
    print('failed')



    