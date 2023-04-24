import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double answer[] = new double[2];
        String clstr1 = cleanstr(str1), clstr2 = cleanstr(str2);
        Set<String> components = new HashSet<>();
        Map<String,Integer> str1cnt = cntMap(clstr1, components);
        Map<String,Integer> str2cnt = cntMap(clstr2, components);
        
        for(String elem:components){
            if(str1cnt.containsKey(elem) && str2cnt.containsKey(elem)){
                answer[0] += Math.min(str1cnt.get(elem), str2cnt.get(elem));
                answer[1] += Math.max(str1cnt.get(elem), str2cnt.get(elem));
            }
            else if (str1cnt.containsKey(elem)){
                answer[1] += str1cnt.get(elem);
            }
            else{
                answer[1] += str2cnt.get(elem);
            }
        }
        if(str1cnt.isEmpty() && str2cnt.isEmpty()){
            return 65536;
        }
        int ans = (int)(answer[0] / answer[1] * 65536);
        
        
        return ans;
    }
    
    public Map<String, Integer> cntMap(String str, Set<String> component){
        Map<String,Integer> ansMap = new HashMap<>();
        for(int i =0; i<str.length() - 1; i++){
            String substr = str.substring(i,i+2);
            if (substr.matches("^[a-zA-Z]*$")){
                component.add(substr);
                ansMap.put(substr, ansMap.getOrDefault(substr,0) + 1);
            }
        }
        return ansMap;
    }
    
    public String cleanstr(String str){
        str = str.toLowerCase();
        return str;
        
    }
}