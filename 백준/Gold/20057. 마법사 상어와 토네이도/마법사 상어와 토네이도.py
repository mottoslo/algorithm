import sys

input = sys.stdin.readline

N = int(input())
sands = [list(map(int,input().split())) for _ in range(N)]

dx = [-1,1,0,0]; dy = [0,0,-1,1] #상, 하, 좌, 우
percentage = [0.01, 0.01, 0.02, 0.07, 0.07, 0.02, 0.1, 0.1, 0.05]
right_dx = [-1,1,-2,-1,1,2,-1,1,0]; right_dy = [-1,-1,0,0,0,0,1,1,2] #direction 오른쪽 기준
left_dx, left_dy = [-1,1,-2,-1,1,2,-1,1,0], [1,1,0,0,0,0,-1,-1,-2]
up_dx, up_dy = [1,1,0,0,0,0,-1,-1,-2], [-1,1,-2,-1,1,2,-1,1,0]
down_dx, down_dy = [-1,-1,0,0,0,0,1,1,2], [-1,1,-2,-1,1,2,-1,1,0]
ANSWER = 0

def do_tornado(origin_x, origin_y, place_x, place_y, percentage): #움직이기 이전의 x,y
    global N, ANSWER
    sand = int(sands[origin_x][origin_y] * percentage)
    if 0 <=place_x < N and 0 <=place_y < N:
        sands[place_x][place_y] += sand
    else:
        ANSWER += sand
    return sand

def do_alpha(origin_x, origin_y, direction, sum_sand):
    global ANSWER
    alpha_x, alpha_y = origin_x + dx[direction], origin_y + dy[direction]
    leftover = sands[origin_x][origin_y] - sum_sand
    if 0 <= alpha_x < N and 0 <= alpha_y < N:
        sands[alpha_x][alpha_y] += leftover
    else:
        ANSWER += leftover

def move(before_x, before_y, direction):
    origin_x, origin_y = before_x + dx[direction], before_y + dy[direction]
    sum_sand = 0
    for i in range(9):
        if direction == 0:
            sum_sand += do_tornado(origin_x, origin_y, origin_x + up_dx[i], origin_y + up_dy[i], percentage[i])
        elif direction == 1:
            sum_sand += do_tornado(origin_x, origin_y, origin_x + down_dx[i], origin_y + down_dy[i], percentage[i])
        elif direction == 2:
            sum_sand += do_tornado(origin_x, origin_y, origin_x + left_dx[i], origin_y + left_dy[i], percentage[i])
        elif direction == 3:
            sum_sand += do_tornado(origin_x, origin_y, origin_x + right_dx[i], origin_y + right_dy[i], percentage[i])
    do_alpha(origin_x, origin_y, direction, sum_sand)
    sands[origin_x][origin_y] = 0
    if before_x == 0 and before_y == 1:
        print(ANSWER)
        sys.exit()

layer_length = 1
x, y = int(N/2), int(N/2)
while True:
    for _ in range(layer_length):
        move(x, y, 2); y -= 1
    for _ in range(layer_length):
        move(x, y, 1); x += 1
    layer_length += 1
    for _ in range(layer_length):
        move(x, y, 3); y += 1
    for _ in range(layer_length):
        move(x, y, 0); x -= 1
    layer_length += 1
