class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i<n+1;i++){
            answer += isPrime(i)?1:0;
        }
        return answer;
    }
    
    public boolean isPrime(int num){
        if (num == 1){return true;}
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