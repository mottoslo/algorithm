class Solution {
    public static int[] SIGN = {1,-1};
    public static int ANSWER = 0;
    
    public int solution(int[] numbers, int target) {
        search(numbers, target, 0, 0, 0);
        search(numbers, target, 0, 1, 0);
        int answer = ANSWER;
        
        return answer;
    }
    
    public static void search(int[] numbers, int target, int numidx, int signidx, int sum){
        if(numidx+1 == numbers.length){
            sum = sum + (numbers[numidx] * SIGN[signidx]);
            if (sum == target){
                ANSWER++;
                return;
            }
            return;
        }
        else{
            sum = sum + (numbers[numidx] * SIGN[signidx]);
            search(numbers, target, numidx + 1, 0,sum);
            search(numbers, target, numidx + 1, 1,sum);
           }
    }
}