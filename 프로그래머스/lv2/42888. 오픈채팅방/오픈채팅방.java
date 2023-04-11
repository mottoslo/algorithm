import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userdb = new HashMap<>();
        int recnum = 0;
        for (String rec:record){
            String[] recarr = rec.split(" ");
            switch(recarr[0]){
                case "Enter":
                    userdb.put(recarr[1], recarr[2]);
                    recnum ++;
                    break;
                case "Change":
                    userdb.put(recarr[1], recarr[2]);
                    break;
                case "Leave":
                    recnum++;
                    break;
            }
        }
        String[] answer = new String[recnum];
        int idx = 0;
        for (String rec:record){
            String[] recarr = rec.split(" ");
        
            switch(recarr[0]){
                case "Enter":
                    answer[idx] = String.format("%s님이 들어왔습니다.",userdb.get(recarr[1]));
                    idx++;
                    break;
                case "Leave":
                    answer[idx] = String.format("%s님이 나갔습니다.",userdb.get(recarr[1]));
                    idx++;
                    break;
            }
        }
        
        
        return answer;
    }
    
    
}