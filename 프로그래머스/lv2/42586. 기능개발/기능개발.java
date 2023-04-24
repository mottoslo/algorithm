import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> anslst = new ArrayList<>();
        Queue<Integer> myQ = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                myQ.add((100 - progresses[i]) / speeds[i]);
            }
            else{
                myQ.add((101 - progresses[i]) / speeds[i] + 1);   
            }
        }
        System.out.println(myQ.toString());
        int nownum = myQ.poll();
        int cnt = 1;
        while(!myQ.isEmpty()){
            if(myQ.peek() > nownum){
                 anslst.add(cnt);
                 cnt = 1;
                 nownum = myQ.poll();
             }
            else{
                myQ.poll();
                cnt++;
            }
        }
        anslst.add(cnt);
        int[] answer = new int[anslst.size()];
        for(int i = 0;i<anslst.size(); i++){
            answer[i] = anslst.get(i);
        }
        
        
        return answer;
    }
}