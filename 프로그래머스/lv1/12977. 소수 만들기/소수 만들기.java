import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i<nums.length - 2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    numList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        for(int num:numList){
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }
    public static boolean isPrime(int num){
        boolean result = true;
        int idx = 2;
        while(idx <= Math.sqrt(num)){
            if (num % idx == 0){
                return false;
            }
            idx++;
        }
        return result;
    }
}