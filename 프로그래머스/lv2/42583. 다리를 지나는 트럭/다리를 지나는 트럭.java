import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int noweight = 0;
        int nowtime = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int idx = 0;
        
        while(idx < truck_weights.length){
            nowtime++;
            if(nowtime > bridge_length){
                noweight -= bridge.poll();
            }
            if(truck_weights[idx] + noweight <= weight){
                bridge.add(truck_weights[idx]);
                noweight += truck_weights[idx];
                idx++;
            }
            else{
                bridge.add(0);
            }
        }
        return nowtime + bridge_length;
    }

}