import java.util.*;
class Solution {
    public static int solution(int[] people, int limit) {

        Arrays.sort(people);
        int idx_L = 0;
        int idx_R = people.length- 1;
        int cnt = 0;

        while(idx_L <= idx_R){
            int Lperson = people[idx_L];
            int Rperson = people[idx_R];
            if (idx_L == idx_R){
                cnt ++;
                break;
            }
            if (Lperson + Rperson <= limit){
                idx_L++;    
            }
            
            idx_R --;
            cnt++;
            }
        return cnt;
        }
}