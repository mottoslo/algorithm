import sys

class node:
    def __init__(self, character, end = False):
        self.now = character
        self.next = {}
        self.end = end

    def check_next(self, character):
        if character in self.next:
            return True
        else:
            return False
        
    def set_next(self, character, end = False):
        self.next[character] = node(character, end)
        return self.next[character]

    def get_node(self, character):
        return self.next[character]

    def is_end(self):
        return self.end
    
    def set_end(self):
        self.end = True
    
def check_word(start_node, word):
    if len(word) == 1 and start_node.check_next(word):
        return -1

    first_char = word[0]
    if start_node.check_next(first_char):
        now = start_node.get_node(first_char)
    else:
        now = start_node.set_next(first_char)
    
    for char in word[1:]:
        if now.is_end():
            return -1
        else:
            if now.check_next(char):
                now = now.get_node(char)
            else:
                now = now.set_next(char)
    
    if len(now.next) != 0:
        return -1
    now.set_end()
    return True

if __name__ == "__main__":
    input = sys.stdin.readline
    t = int(input())
    for i in range(t):
        N = int(input())
        start_node = node("-1")
        loop_flag = True
        numbers = [input().strip() for _ in range(N)]
        for number in numbers:
            flag = check_word(start_node, number)
            if flag == -1:
                loop_flag = False
                print("NO")
                break
        if loop_flag:
            print("YES")