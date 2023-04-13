import java.util.*;
class Solution {
    public int solution(String s) {
        int min = 1001;
        for(int scanLen = 1; scanLen<=s.length() / 2 + 1; scanLen++){
            List<Map.Entry<String, Integer>> storage = new ArrayList<>();
            int idx = 0;
            int count = 0;
            String comp = s.substring(idx, idx + scanLen);
            while(idx + scanLen <= s.length()){
                if (comp.equals(s.substring(idx, idx+scanLen))){
                    count++;
                    idx += scanLen;
                }
                else{
                    storage.add(Map.entry(new String(comp),count));
                    comp = s.substring(idx, idx+scanLen);
                    count = 0;
                }
            }
            storage.add(Map.entry(new String(comp),count));
            if (idx < s.length()){
                storage.add(Map.entry(s.substring(idx,s.length()),1));
            }
            String compressed = new String("");
            for(Map.Entry<String, Integer> entry:storage){
                if (entry.getValue() !=1)
                    compressed += String.valueOf(entry.getValue()) + entry.getKey();
                else
                    compressed += entry.getKey();
            }
            // System.out.println(compressed);
            min = Math.min(compressed.length(), min);
        }
        return min;
    }
}