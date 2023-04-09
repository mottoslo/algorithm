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
                S(mystack);
            } else if (ch == 'D') {
                D(mystack);
            } else if (ch == 'T') {
                T(mystack);
            } else if (ch == '*') {
                star(mystack, idx, dartResult);
            } else if (ch == '#') {
                sharp(mystack, idx, dartResult);
            }
            idx++;
        }
        int answer = 0;
        while (!mystack.isEmpty()) {
            System.out.println("stack 거꾸로 : " + mystack.peek());
            answer += mystack.pop();
        }
        return answer;
    }

    public static void S(Stack<Integer> mystack) {
        mystack.push(mystack.pop());
    }

    public static void D(Stack<Integer> mystack) {
        Integer before = mystack.pop();
        mystack.push(before * before);
    }

    public static void T(Stack<Integer> mystack) {
        Integer before = mystack.pop();
        mystack.push(before * before * before);
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