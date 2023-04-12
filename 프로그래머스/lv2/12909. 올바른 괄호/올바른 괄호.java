import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> myStack = new Stack<>();
        for(int i = 0 ; i<s.length(); i++){
            char nowchar = s.charAt(i);
            if(myStack.isEmpty()){
                myStack.push(nowchar);
            }
            else{
                switch(nowchar){
                    case '(':
                        myStack.push(nowchar);
                        break;
                    case ')':
                        if(myStack.pop() != '('){
                            myStack.push(nowchar);
                        }
                }
            }
        }
        return myStack.isEmpty();
    }
}