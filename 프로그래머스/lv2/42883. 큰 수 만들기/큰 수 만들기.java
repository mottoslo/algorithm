import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int numlen = number.length();
        int anslen = numlen - k;
        int tempmax = 0;
        int idx = 0;
        int charcount = 0;
        while(answer.length() != anslen){
            int remaining = anslen - charcount;
            if(idx == numlen - remaining){
                break;
            }
            for(int i = idx; i<number.length() - remaining+1; i++){
                if(number.charAt(i) - '0' > tempmax){
                    tempmax = number.charAt(i) - '0';
                    idx = i;
                }
            }
            answer += number.charAt(idx);
            idx++; charcount++;
            tempmax = 0;
        }
        if(answer.length() < anslen){
            answer += number.substring(idx);
        }
        
       
        return answer;
    }
}