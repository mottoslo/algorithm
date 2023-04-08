class Solution {
    public int[] solution(long n) {
        String intstr = Long.toString(n);
        int strlen = intstr.length();
        int[] answer = new int[strlen];
        for(int i = 0; i < strlen; i++){
            answer[i] = intstr.charAt(strlen-1-i) - '0';
        }
        
        
        return answer;
    }
}