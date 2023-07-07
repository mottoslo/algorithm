from collections import Counter, defaultdict, deque
import heapq

def bfs(que, dic, tickets, target):
    answers = []
    while(len(que) > 0):
        usedTickets, now = que.pop()
        if len(usedTickets) == target:
            answers.append([destination for depart, destination in usedTickets])
        else:
            for destination in dic[now]:
                if usedTickets.count((now, destination)) < dic[now].count(destination):
                    que.append((usedTickets + [(now, destination)], destination))
    
    answers.sort()
    return answers[0]
def solution(tickets):
    answer = 0
    target = len(tickets)
    dic = defaultdict(list)
    for ticket in tickets:
        dic[ticket[0]].append(ticket[1])
    que = deque()
    for i in range(len(dic["ICN"])):
        start = dic["ICN"][i]
        que.append(([("ICN", start)], start))
    answer = bfs(que, dic, tickets, target)
    return ["ICN"] + answer