import java.util.*;
class Solution {
    public int solution(int n) {
        if(n == 1 || n ==2){
            return n;
        }
        
        int[] anslist = new int[n];
        anslist[0] = 1;
        anslist[1] = 2;
        int idx = 2;
        // while(idx != n){
        //     anslist.add(anslist.get(idx-1) + anslist.get(idx-2));
        //     idx++;
        // }
        for(int i = 2; i<n;i++){
            // anslist.add((anslist.get(i-1) + anslist.get(i-2)) % 1000000007);
            anslist[i] = ((anslist[i-1] + anslist[i-2]) % 1000000007);
        }
        return anslist[n-1];
    }
}