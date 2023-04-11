import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> corpus = new HashSet<>();
        corpus.add(words[0]);
        char nowchar = words[0].charAt(words[0].length() - 1);
        for(int i = 1; i<words.length; i++){
            String nowword = words[i];
            char newchar = nowword.charAt(0);
            if (nowchar != newchar || corpus.contains(nowword)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            else{
                corpus.add(nowword);
                nowchar = nowword.charAt(nowword.length() - 1);
            }
        }
        return answer;
        
    }
}