import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> skipchar = new ArrayList<>();
        for(int i = 0; i<skip.length(); i++){
            skipchar.add(skip.charAt(i));
        }
        for(int i = 0; i<s.length();i++){
            char nowchar = s.charAt(i);
            int idx = 0;
            while(idx != index){
                nowchar = nowchar+1<=122 ? (char)(nowchar + 1) : (char)(nowchar - 25);
                if(!skipchar.contains(nowchar)){
                    idx++;
                }
            }
            
            answer += nowchar;
            
        }
        return answer;
    }
}