import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        List<Character> charr = new ArrayList<>();
        for (int i =0; i<s.length(); i++){
            charr.add(s.charAt(i));
        }
        charr.sort(Collections.reverseOrder());
        for(Character elem:charr){
            answer += elem;
        }

        return answer;
    }
}