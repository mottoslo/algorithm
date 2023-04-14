import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int elemlen = elements.length;
        List<Integer> numList = new ArrayList<>();
        Set<Integer> numset = new HashSet<>();
        for(int i = 0; i<2*elemlen - 1; i++){
            numList.add(elements[i % elemlen]);
        }
        int idx = 0;
        while(idx <elemlen){
            int tempsum = 0;
            for(int i = 0; i<elemlen; i++){
                tempsum += numList.get(idx + i);
                numset.add(tempsum);
            }
            idx++;
        }

        return numset.size();
    }
}