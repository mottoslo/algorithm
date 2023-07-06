import sys
from collections import Counter

nA, nB = map(int,sys.stdin.readline().split())
A = Counter(map(int,sys.stdin.readline().split()))
B = Counter(map(int,sys.stdin.readline().split()))

print(len(A - B) + len(B - A))