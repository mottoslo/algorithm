import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> dList = new ArrayList<>();
        for (int num:d){
            dList.add(num);
        }
        Collections.sort(dList);
        int idx = 0;
        do{
            budget -= dList.get(idx);
            idx++;
            answer++;
        }while(budget >= 0 && idx < dList.size());
        
        return budget<0?answer-1:answer;
    }
}