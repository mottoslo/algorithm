import sys
import math

nCrane = int(sys.stdin.readline())
craneMaxList = list(map(int,sys.stdin.readline().split()))
nBox = int(sys.stdin.readline())
boxWeightList = list(map(int,sys.stdin.readline().split()))
boxWeightList.sort(reverse=True)
craneMaxList.sort(reverse=True)

def calculateMinTime(numCrane, numBox):
    return math.ceil(numBox / numCrane)

MINTIME = calculateMinTime(nCrane, nBox)

offset = 0
if boxWeightList[0] > craneMaxList[0]:
    print(-1)
else:
    craneId = 0
    boxId = 0
    while(craneId < nCrane - 1 and boxId < nBox - 1):
        if boxWeightList[boxId + 1] <= craneMaxList[craneId + 1]:
            newTime = calculateMinTime(craneId + 1, boxId + 1)
            MINTIME = max(MINTIME, newTime)
            craneId += 1
        boxId += 1
    newTime = calculateMinTime(craneId + 1, nBox)
    MINTIME = max(MINTIME, newTime)
    print(MINTIME)   # ㅅㅂ 프린트 else문 안에 안넣어서 몇시간날렸을까....