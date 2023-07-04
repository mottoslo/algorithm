import sys
import heapq as hq

startTimeQueue = []; endTimeQueue = []; availableComputer = []
usageList = list(0 for i in range(1000000))
numComp = 0

#입력
N = int(sys.stdin.readline())
for i in range(N):
    tp = tuple(map(int, sys.stdin.readline().split()))
    hq.heappush(startTimeQueue, tp)

while(len(startTimeQueue) != 0):
    newUser = hq.heappop(startTimeQueue)
    while(len(endTimeQueue) != 0):
        popUser = hq.heappop(endTimeQueue)
        if popUser[0] >= newUser[0]:
            hq.heappush(endTimeQueue, popUser)
            break
        else:
            hq.heappush(availableComputer, popUser[1])

    if(len(availableComputer) == 0):
        hq.heappush(endTimeQueue, (newUser[1], numComp))
        usageList[numComp] += 1
        numComp += 1

    else:
        computer = hq.heappop(availableComputer)
        usageList[computer] += 1
        hq.heappush(endTimeQueue, (newUser[1], computer))
    
print(numComp)
for i in range(numComp):
    print(usageList[i], end = " ")