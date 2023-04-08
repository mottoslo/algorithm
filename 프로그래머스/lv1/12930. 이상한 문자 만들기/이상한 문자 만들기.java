class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        int word_idx = 0;
        while(idx < s.length()){
            String chr = s.substring(idx, idx+1);
            if (chr.equals(" ")){
                answer += " ";
                word_idx = 0;
                idx++;
            }
            else{
                answer += (word_idx%2 == 0)?chr.toUpperCase():chr.toLowerCase();
                word_idx++;
                idx++;
            }
        }
        return answer;
    }
}