import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String longstr = Long.toString(n);
        char[] charr = longstr.toCharArray();
        Arrays.sort(charr);
        char[] new_charr = new char[charr.length];
        for (int i=0; i<charr.length; i++){
            new_charr[charr.length -1 - i] = charr[i];
        }
        answer = Long.parseLong(String.valueOf(new_charr));

        return answer;
    }
}