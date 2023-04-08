import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> intStack = new Stack<>();
        int arrlen = arr.length;
        intStack.push(arr[arrlen-1]);
        int idx = arrlen - 2;
        while(idx >=0){
                try{
                    if (!(arr[idx] == intStack.peek())){
                        intStack.push(arr[idx]);
                    }
                } catch(Exception e){
                    idx --;
                    
                } finally{
                    idx --;
                }
        }
        int[] answer = new int[intStack.size()];
        for(int i = 0; i<answer.length; i++){
                answer[i] = intStack.pop();
        }
        return answer;
    }
}