class Solution {
    public int solution(int[] arr) {
        int allCM = 1;
        for(int i = 0; i<arr.length; i++){
            allCM = LCM(allCM, arr[i]);
        }
        return allCM;
        
    }
    
    public static int LCM(int num1, int num2){
        int gcd = 1;
        int idx = 1;
        while(idx <= Math.min(num1,num2)){
            if (num1%idx == 0 & num2%idx == 0){
                gcd = idx;
            }
            idx++;
        }
        return num1 * num2 / gcd;
    }
}