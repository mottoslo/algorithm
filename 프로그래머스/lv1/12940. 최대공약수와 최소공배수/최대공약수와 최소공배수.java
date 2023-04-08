class Solution {
    public int[] solution(int n, int m) {
        int idx = 1;
        int MCF = 1;
        while(idx <= Math.max(n,m)){
            if (n % idx == 0 && m % idx ==0){
                MCF = idx;
            }
            idx++;
        }
        int[] answer = {MCF, n*m/MCF};
        
        return answer;
    }
}