import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] elem:commands){
            List<Integer> intArray = new ArrayList<>();
            for(int i = elem[0]-1; i < elem[1]; i++){
                intArray.add(array[i]);
            }
            Collections.sort(intArray);
            answer[idx] = intArray.get(elem[2]-1);
            idx++;
        }
        return answer;
    }
}