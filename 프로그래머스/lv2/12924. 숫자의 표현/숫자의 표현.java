class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 1){return 1;}
        for(int i = 1; i<= n/2 + 1; i++){
            int j = i+1;
            while((i + j) * (j-i+1) / 2 <= n){
                if ((i + j) * (j-i+1) / 2 == n){
                    answer ++;
                }
                j++;
            }
        }
        answer++;
        return answer;
        
    }
}