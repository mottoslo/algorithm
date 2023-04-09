import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> sMap = new HashMap<>();
        int sumPlayer = stages.length;
        for(int i = 0; i < sumPlayer ; i++){
            sMap.put(stages[i], sMap.getOrDefault(stages[i], 0) + 1);
        }

        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>();
        
        for(int i = 1; i<N+1; i++){
            int stagenum = sMap.getOrDefault(i,0), afterstage = 0;
            for(int j = i; j<N+2; j++){
                afterstage += sMap.getOrDefault(j, 0);
            }
            
            //현재 stage에 있는 사람 0이면 실패율 0
            double failrate = stagenum == 0?0:afterstage == 0?1:stagenum/(double)afterstage;
            entryList.add(Map.entry(i,failrate));
        }
        
       Comparator<Map.Entry<Integer, Double>> mycmp = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }
                else{
                    return o1.getValue().compareTo(o2.getValue());
                }

            }
        };
        entryList.sort(Collections.reverseOrder(mycmp));
        for(int i = 0; i<answer.length; i++){
            answer[i] = entryList.get(i).getKey();
        }

        return answer;
    }
}