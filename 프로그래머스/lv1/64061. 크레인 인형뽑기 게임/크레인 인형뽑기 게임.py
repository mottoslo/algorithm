def solution(board, moves):
    popcount = []
    basket = []
    for num in moves:
        doll = move_crane(num, board)
        print(doll)
        if doll != 0:
            basket.append(doll)
        clear_basket(basket, popcount)
        
    answer = len(popcount)
    return answer

def move_crane(num, board):
    temp = 0
    for i in range(len(board)):
        if board[i][num - 1] != 0:
            temp = board[i][num - 1]
            board[i][num - 1] = 0    
            return temp
    return temp
        
def clear_basket(basket, popcount):
    if len(basket) < 2:
        pass
    elif basket[-1] == basket[-2]:
        popcount.append(basket.pop())
        popcount.append(basket.pop())
        clear_basket(basket,popcount)
    else:
        return 0