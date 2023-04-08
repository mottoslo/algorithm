class Solution {
    public String solution(int a, int b) {
        
        String answer = "";
        String days[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int absday = 0;
        absday = ((a-1)/2) * 61 + ((a-1)%2) * 31 + b - 1;
        if (a <3){absday += 1;}
        if (a == 9 || a == 11){ absday += 1;}
        answer = days[absday%7];
        
        return answer;
    }
}