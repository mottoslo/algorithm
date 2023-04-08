class Solution {
    public String solution(int n) {
        String answer = "";
        char[] chrset = {'수','박'};
        int idx = 0;
        while(idx <n){
            answer += chrset[idx%2];
            idx++;
        }
        return answer;
    }
}