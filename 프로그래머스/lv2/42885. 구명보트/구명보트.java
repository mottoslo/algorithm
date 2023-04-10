import java.util.*;
class Solution {
    public static int solution(int[] people, int limit) {

        List<Integer> pplList = new ArrayList<Integer>();
        for (int ppl:people){
            pplList.add(ppl);
        }
        int idx_L = 0;
        int idx_R = pplList.size()- 1;
        int cnt = 0;
        Collections.sort(pplList, Collections.reverseOrder());

        while(idx_L <= idx_R){
            int Lperson = pplList.get(idx_L);
            int Rperson = pplList.get(idx_R);
            if (idx_L == idx_R){
                cnt ++;
                break;
            }
            if (Lperson + Rperson <= limit){
                idx_R --;
            }
            idx_L++;
            cnt++;
            }
        return cnt;
        }
}