import java.util.*;
class Solution {
    public int solution(String dartResult) {
        Stack<Integer> mystack = new Stack<>();
        Integer idx = 0;

        while (idx < dartResult.length()) {
            char ch = dartResult.charAt(idx);

            if (ch == '1' && dartResult.charAt(idx + 1) == '0') {
                mystack.push(10);
                idx++;
            } else if ('0' <= ch && ch <= '9') {
                mystack.push(ch - '0');
            } else if (ch == 'S') {
                mystack.push(S(mystack));
            } else if (ch == 'D') {
                mystack.push(D(mystack));
            } else if (ch == 'T') {
                mystack.push(T(mystack));
            } else if (ch == '*') {
                star(mystack, idx, dartResult);
            } else if (ch == '#') {
                sharp(mystack, idx, dartResult);
            }
            idx++;
        }
        int answer = 0;
        while (!mystack.isEmpty()) {
            answer += mystack.pop();
        }
        return answer;
    }

    public static Integer S(Stack<Integer> mystack) {
        Integer before = mystack.pop();
        return before;
    }

    public static Integer D(Stack<Integer> mystack) {
        Integer before = mystack.pop();
        return before * before;
    }

    public static Integer T(Stack<Integer> mystack) {
        Integer before = mystack.pop();
        return before * before * before;
    }

    public static void star(Stack<Integer> mystack, Integer idx, String result) {
        if (mystack.size()< 2){
            mystack.push(mystack.pop() * 2);
        }
        else{
            Integer before1 = mystack.pop();
            Integer before2 = mystack.pop();
            mystack.push(before2 * 2);
            mystack.push(before1 * 2);
        }
    }

    public static void sharp(Stack<Integer> mystack, Integer idx, String result) {
        mystack.push(-mystack.pop());
    }
}