import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<Character> charRank = new ArrayList<>();
        List<String> strRank = new ArrayList<>();
        for (String st:strings){
            charRank.add(st.charAt(n));
            strRank.add(st);
        }
        Collections.sort(charRank);
        Collections.sort(strRank);
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char o1ch = o1.charAt(n);
                char o2ch = o2.charAt(n);
                if (o1ch == o2ch){
                    return strRank.indexOf(o1) - strRank.indexOf(o2);
                }
                else{
                    return charRank.indexOf(o1ch) - charRank.indexOf(o2ch);
                }
            }
        };
        Arrays.sort(strings, cmp);
        return strings;
    }
}