import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0){
            return 5 * cities.length;
        }
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for (int i = 0 ; i<cities.length; i++){
            String nowcity = cities[i].toLowerCase();
            if (cache.contains(nowcity)){
                cache.remove(nowcity);
                cache.add(nowcity);
                answer += 1;
            }
            else{
                answer += 5;
                if (cache.size() < cacheSize){
                    cache.add(nowcity);
                }
                else{
                    cache.remove(0);
                    cache.add(nowcity);
                }
            }
        }
        return answer;
    }
}