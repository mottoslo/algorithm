import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char o1ch = o1.charAt(n);
                char o2ch = o2.charAt(n);
                if (o1ch == o2ch){
                    return o1.compareTo(o2);
                }
                else{
                    return o1ch - o2ch;
                }
            }
        };
        Arrays.sort(strings, cmp);
        return strings;
    }
}