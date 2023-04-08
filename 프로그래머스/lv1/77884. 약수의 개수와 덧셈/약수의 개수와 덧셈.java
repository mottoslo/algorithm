class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<right+1; i++){
            answer += numDivisor(i)%2==0?i: -i;
        }
        return answer;
    }

    public int numDivisor(int num){
        int cnt = 0;
        int idx = 1;
        while(idx <= Math.sqrt(num)){
            if (num % idx ==0){
                cnt += Math.pow(idx,2) == num?1:2;
            }
            idx++;
        }
        return cnt;
    }
}