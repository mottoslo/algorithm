class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        for(int w = 3; w< (brown+yellow) / 3 + 1; w++){
            for(int h = 3; h <= Math.min((brown+yellow) / w + 1,w); h++){
                if(w*h == brown+yellow){
                    if ((w-2) * (h-2) == yellow){
                        answer[0] = Math.max(w,h);
                        answer[1] = Math.min(w,h);
                    }
                }
            }
        }
        return answer;
    }
}