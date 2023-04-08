import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        List<Integer> winNum = new ArrayList<>();
        int cnt = 0;
        int numZero =0;
        for(int num:win_nums){
            winNum.add(num);
        }
        for(int num:lottos){
            numZero += (num == 0)?1:0;
            cnt += winNum.contains(num)?1:0;
        }
        int[] result = {6,6,5,4,3,2,1};
        int[] answer = {result[cnt + numZero], result[cnt]};
        return answer;
    }
}