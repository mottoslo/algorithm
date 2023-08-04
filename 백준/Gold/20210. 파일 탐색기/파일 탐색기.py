import sys
from functools import cmp_to_key

input = sys.stdin.readline

N = int(input())

words = [input().strip() for _ in range(N)]

def compare(x, y):
    xLength = len(x)
    yLength = len(y)
    x_idx, y_idx = 0, 0 
    while(x_idx < xLength and y_idx < yLength):
        x_char, y_char = x[x_idx], y[y_idx]
        #comparing logic, break when decided
        if '0' <= x_char <= '9' and '0' <= y_char <= '9':
            x_idx, y_idx, result = do_number(x, y, x_idx, y_idx, xLength, yLength)
            if result != 0:
                return result
        elif x_char == y_char:
            pass
        else:
            return compare_char(x_char, y_char)
        x_idx += 1; y_idx += 1
    
    #when one string is longer than another
    if x_idx == xLength: #if x ended first
        return -1
    elif y_idx == yLength: #if y ended first
        return 1

def do_number(x, y, x_idx, y_idx, xLength, yLength):
    x_prev, y_prev = x_idx, y_idx
    x_num, y_num = '', ''
    while x_idx < xLength and '0' <= x[x_idx] <= '9':
        x_num += x[x_idx]
        x_idx += 1
    while y_idx < yLength and '0' <= y[y_idx] <= '9':
        y_num += y[y_idx]
        y_idx += 1
    result = 0
    x_num, y_num = int(x_num), int(y_num)
    if x_num < y_num:
        result = -1
    elif y_num < x_num:
        result = 1
    else:
        if (x_idx - x_prev) < (y_idx - y_prev):
            result = -1
        elif (x_idx - x_prev) > (y_idx - y_prev):
            result = 1

    return x_idx - 1, y_idx - 1, result # returns index where number ends both for x and y
    

def compare_char(x,y):
    x_low = x.lower()
    y_low = y.lower()
    if x_low == y_low:
        return -1 if x < y else 1
    else:
        return -1 if x_low < y_low else 1
    
words.sort(key=cmp_to_key(compare))
for word in words:
    print(word)
