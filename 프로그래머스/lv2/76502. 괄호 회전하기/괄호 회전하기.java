import java.util.*;
class Solution {
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i< s.length(); i++){
            String new_string = s.substring(i, s.length()) + s.substring(0, i);
            if (new_string.charAt(0) == '}' || new_string.charAt(0) == ']'|| new_string.charAt(0) == ')'){
                continue;
            }
            Stack<Character> myStack = new Stack<>();
            for(int j = 0; j< new_string.length(); j++){
                char nowChar = new_string.charAt(j);
                if (myStack.isEmpty()){
                    myStack.push(nowChar);
                    continue;
                }
                switch(nowChar){
                    case ')':
                        if(myStack.pop() == '('){
                            continue;
                        }
                        else{
                            myStack.push(')');
                        }
                        break;

                    case '}':
                        if(myStack.pop() == '{'){
                            continue;
                        }
                        else{
                            myStack.push('}');
                        }
                        break;

                    case ']':
                        if(myStack.pop() == '['){
                            continue;
                        }
                        else{
                            myStack.push(']');
                        }
                        break;
                    default:
                        myStack.push(nowChar);
                }
            }
            if (myStack.isEmpty()){
                answer ++;
            }

        }
        return answer;
    }
}