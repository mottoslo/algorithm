import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i<s.length();i++){
            char nowchar = s.charAt(i);
            int idx = 0;
            while(idx != index){
                nowchar = (char) (nowchar+1);
                nowchar = nowchar<=122 ? nowchar : (char)(nowchar - 26);
                if(!skip.contains(String.valueOf(nowchar))){
                    idx++;
                }
            }
            
            answer += nowchar;
            
        }
        return answer;
    }
}