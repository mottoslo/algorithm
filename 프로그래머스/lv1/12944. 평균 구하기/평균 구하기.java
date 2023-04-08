class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        int len = arr.length;
        for(int i:arr){
            sum += i;
        }
        
        
        return sum / len;
    }
}