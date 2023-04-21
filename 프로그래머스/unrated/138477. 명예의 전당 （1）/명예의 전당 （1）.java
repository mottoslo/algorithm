import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> mjun = new ArrayList<>();
        for(int i = 0; i<score.length; i++){
            if(i < k){
                mjun.add(score[i]);
            }
            else{
                if(mjun.get(0) < score[i]){
                    mjun.remove(0);
                    mjun.add(score[i]);
                }
            }
            Collections.sort(mjun);
            answer[i] = mjun.get(0);
        }
        
        return answer;
    }
}