import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> intMap = new HashMap<>();
        for(int num:nums){
            intMap.put(num, intMap.getOrDefault(num,0) + 1);
        }
        int mymon = 0;
        for(Map.Entry<Integer, Integer> elem:intMap.entrySet()){
            if(mymon < nums.length/2){
                mymon ++;
            }
        }
        return mymon;
    }
}