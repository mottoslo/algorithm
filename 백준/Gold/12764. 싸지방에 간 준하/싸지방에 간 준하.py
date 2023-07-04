from queue import PriorityQueue
import sys

startTimeQueue = PriorityQueue()
endTimeQueue = PriorityQueue()
availableComputer = PriorityQueue()
usageList = list(0 for i in range(1000000))
numComp = 0

#입력
N = int(sys.stdin.readline())
for i in range(N):
    tp = tuple(map(int, sys.stdin.readline().split()))
    startTimeQueue.put(tp)

while(not startTimeQueue.empty()):
    newUser = startTimeQueue.get()
    while(not endTimeQueue.empty()):
        popUser = endTimeQueue.get()
        if popUser[0] >= newUser[0]:
            endTimeQueue.put(popUser)
            break
        else:
            availableComputer.put(popUser[1])

    if(availableComputer.empty()):
        endTimeQueue.put((newUser[1], numComp))
        usageList[numComp] += 1
        numComp += 1

    else:
        computer = availableComputer.get()
        usageList[computer] += 1
        endTimeQueue.put((newUser[1], computer))
    
print(numComp)
for i in range(numComp):
    print(usageList[i], end = " ")





