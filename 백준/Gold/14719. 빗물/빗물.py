import sys

H, W = map(int,sys.stdin.readline().split())

heightList = list(map(int, sys.stdin.readline().split()))

water = 0
heightdict = {}

def calcLevelWater(walls):
    if len(walls) == 0:
        return
    tmpidx = walls[0]
    
    for i in range(1,len(walls)):
        global water
        water += walls[i] - tmpidx - 1
        tmpidx = walls[i]

for i,height in enumerate(heightList):
    if height == 0:
        continue
    if heightdict.get(height):
        heightdict[height].append(i)
    else:
        heightdict[height] = [i]

walls = []
for level in reversed(range(1,H+1)):
    if heightdict.get(level):
        walls.extend(heightdict.get(level))
        walls.sort()
    calcLevelWater(walls)
    
    

print(water)
