class Solution {
    public int solution(int n) {
        int answer = 0, tirnum = 1, real_n = n;
        while(n / 3 > 0){
            answer /= 3;
            tirnum +=1;
            n /= 3;
        }
        System.out.println(tirnum);
        for (int i = tirnum - 1; i>=0; i--){
            answer += (real_n%3) * Math.pow(3, i);
            real_n /= 3;
            
        }
        return answer;
    }
}