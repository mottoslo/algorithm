import java.util.*;
import java.util.*;
class Solution {
    public static int MAXLEN = 5;
    
    public int solution(String word) {
        int wordlen = word.length();
        int answer = 0;
        Map<Character, Integer> rank = new HashMap<>();
        rank.put('A', 0); rank.put('E', 1); rank.put('I', 2);
        rank.put('O', 3); rank.put('U', 4);

        for(int i = 0; i<wordlen; i++){
            char charrank = word.charAt(i);
            answer += rank.get(charrank) * sumsecure(i) + 1;
        }
        return answer;
    }
    public static int sumsecure(int idx){
        int sum = 0;
        for(int i = 0; i<MAXLEN - idx; i++){
            sum += Math.pow(MAXLEN,i);
        }
        System.out.println(sum);
        return sum;
    }
}
