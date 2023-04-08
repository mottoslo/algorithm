class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0, y = 0;
        s = s.toLowerCase();
        for (int i =0 ; i<s.length(); i++){
            if (s.charAt(i) == 'p'){p++;}
            if (s.charAt(i) == 'y'){y++;}
        }
        
        return p==y;
    }
}