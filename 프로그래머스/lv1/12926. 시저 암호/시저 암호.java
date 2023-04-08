import java.util.*;
class Solution {
    public String solution(String s, int n) {
            String answer = "";
            char[] chArr = s.toCharArray();
            for (int i = 0; i<chArr.length; i++){
                if (chArr[i] == ' '){
                    continue;
                }
                else if(chArr[i] < 91){
                    chArr[i]+= (chArr[i] + n <= 90?n:-(26-n));
                }
                else{
                    chArr[i]+= (chArr[i] + n <= 122?n:-(26-n));
                }
            }
            answer = String.valueOf(chArr);
            return answer;
    }
}