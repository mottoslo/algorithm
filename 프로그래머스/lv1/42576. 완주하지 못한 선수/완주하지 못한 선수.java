import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        // System.out.println(Arrays.toString(participant));
        // System.out.println(Arrays.toString(completion));
        int temp = 0;
        for (int i = 0; i < completion.length; i++){
            // System.out.println(completion[i]);
            // System.out.println(participant[i]);
            if (completion[i].equals(participant[temp])){
                temp +=1;
            }
            else{
                break;
            }
        }
        answer = participant[temp];
        return answer;
    }
}