import java.util.*;
class Solution {
    public static int[] solution(String s) {
        List<Integer> tuple = new ArrayList<>();

        String regex = "^\\{\\{|}}$";  // s 시작의 {{, 끝의 }}를 지워줌
        String[] toarr = s.replaceAll(regex,"").split("},\\{");
        Arrays.sort(toarr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(String set:toarr){
            String[] nums = set.split(",");
            for(String num:nums){
                int intNum = Integer.parseInt(num);
                if (!tuple.contains(intNum)){
                    tuple.add(intNum);
                    break;
                }
            }
        }
        int[] answer = new int[tuple.size()];
        for(int i = 0; i< tuple.size(); i++){
            answer[i] = tuple.get(i);
        }

        return answer;
    }
}