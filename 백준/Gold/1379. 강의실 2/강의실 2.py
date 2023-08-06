import sys
import heapq

input = sys.stdin.readline

N = int(input())

classes = [list(map(int,input().split())) for _ in range(N)]

classes.sort(key=lambda x : x[1])

cnt = 1
pq = []
INFO = [0 for _ in range(N)]
heapq.heappush(pq, (classes[0][2], 1)) # 끝나는시간만 삽입
INFO[classes[0][0] - 1] = 1
for i in range(1,len(classes)):
    new_class = classes[i]
    if pq[0][0] <= new_class[1]:
        _, classroom = heapq.heappop(pq)
        heapq.heappush(pq,(new_class[2], classroom))
        INFO[new_class[0] - 1] = classroom
    else:
        cnt +=1
        heapq.heappush(pq,(new_class[2], cnt))
        INFO[new_class[0] - 1] = cnt

print(cnt)
for classroom in INFO:
    print(classroom)




