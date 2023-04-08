import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i< name.length; i++){
            scoreMap.put(name[i], yearning[i]);
        }
        // System.out.println(scoreMap.toString());
        for (String[] pic:photo){
            int yearningSum = 0;
            
            for (String person:pic){
                
                if (scoreMap.containsKey(person)){
                    yearningSum += scoreMap.get(person);
                }
            }
            answer[idx] = yearningSum;
            idx +=1;
            
        }
        
        return answer;
    }
}