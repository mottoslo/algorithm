import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> mystack = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char nowchar = s.charAt(i);
            if(mystack.isEmpty()){
                mystack.push(nowchar);
            }
            else{
                if(mystack.peek() == nowchar){
                    char tempchar = nowchar;
                    while (!mystack.isEmpty() && mystack.peek() == tempchar){
                        tempchar = mystack.pop();
                    }
                }
                else{
                    mystack.push(nowchar);
                }
            }
        }

        return mystack.isEmpty()?1:0;
    }
}