#arr은 [0,11] 순서대로 왼쪽손,오른쪽손의 현재 위치를 기록
# * = 10, # = 11

def solution(numbers, hand):
    answer = ''
    dict = make_dict()
    hand_pos = [10,11]
    for num in numbers:
        if num in [1,4,7,10]:
            answer += (left_finger(num, hand_pos))
        elif num in [3,6,9,11]:
            answer += right_finger(num, hand_pos)
        else:
            L_distance = find_distance(hand_pos[0], num, dict)
            R_distance = find_distance(hand_pos[1], num, dict)
            if L_distance > R_distance:
                answer += right_finger(num, hand_pos)
            elif R_distance > L_distance:
                answer += left_finger(num, hand_pos)
            else:
                if hand == 'right':
                    answer += right_finger(num, hand_pos)
                else:
                    answer += left_finger(num, hand_pos)
                    
    return answer

def right_finger(num, arr):
    arr[1] = num
    return 'R'

def left_finger(num, arr):
    arr[0] = num
    return 'L'

def make_dict():
    dict = {}
    key_pad = [1,2,3,4,5,6,7,8,9,10,0,11]
    for num in key_pad:
        idx = key_pad.index(num)
        dict[num] = ((idx // 3), (idx % 3) )   # (0,1)이면 0번째줄 가운데
    # print(dict)
    return dict

def find_distance(num1,num2,dict):
    pos_num1 = dict[num1]
    pos_num2 = dict[num2]
    distance = abs(pos_num1[0] - pos_num2[0]) + abs(pos_num1[1] - pos_num2[1])
    return distance
    
        
        