import sys

S=list(input())
T=list(input())
ans = 0

def dfs(t,s):
    global ans
    if t==s:
        ans += 1
    if len(t)==0:
        return 0
    if t[-1]=='A':
        dfs(t[:-1], s)
    if t[0]=='B':
        dfs(t[1:][::-1], s)

dfs(T,S)
if ans > 0:
    print(1)
else:
    print(0)