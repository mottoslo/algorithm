import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sumset = new HashSet<>();
        for(int i =0; i<numbers.length -1; i++){
            int num1 = numbers[i];
            for(int j =i+1; j<numbers.length; j++){
                sumset.add(num1 + numbers[j]);
            }
        }
        List<Integer> sumList = new ArrayList<>(sumset);
        Collections.sort(sumList);
        int[] answer = new int[sumList.size()];
        for (int i = 0; i<sumList.size(); i++){
            answer[i] = sumList.get(i);
        }
        
        return answer;
    }
}