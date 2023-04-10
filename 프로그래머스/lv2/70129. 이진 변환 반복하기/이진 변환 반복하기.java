import java.util.*;
class Solution {
        public int[] solution(String s) {
        
        int numcnt = 0, tcnt = 0;
        while(!s.equals("1")){
            tcnt +=1;
            int slen = s.length();
            s = s.replaceAll("0","");
            
            numcnt += slen - s.length();
            s = Integer.toBinaryString(s.length());
            
        }
        int[] answer = {tcnt, numcnt};
        
        return answer;
    }
}