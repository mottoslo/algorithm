import java.util.*;
class Solution {
    public static int MAXREG = 0;
    public static int MAXREV = 0;
    public static int[] RATES = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] rates = new int[emoticons.length];
        for(int i = 0; i< RATES.length; i++){
            search(users, emoticons, rates, 0, i);
        }
        
        answer[0] = MAXREG;
        answer[1] = MAXREV;
        return answer;
    }
    
    public static void search(int[][] users, int[] prices, int[] rates, int cur, int idx){
        rates[cur] = RATES[idx];
        if (cur + 1 == rates.length){
            int[] infos = calculate(users, prices, rates);
            if (infos[0] > MAXREG){
                MAXREG = infos[0];
                MAXREV = infos[1];
            }
            else if (infos[0] == MAXREG){
                MAXREV = Math.max(MAXREV, infos[1]);
            }
        }
        else{
            for(int i = 0; i<RATES.length; i++){
                search(users, prices, rates, cur + 1, i);
            }
        }
    }
    
    public static int[] calculate(int[][] users, int[] prices, int[] rates){
        int[] ans = {0,0};
        
        for (int[] user:users){
            int buyrate = user[0];
            int buylimit = user[1];
            int pricesum = 0;
            for(int i = 0; i<prices.length; i++){
                if(rates[i] >= buyrate){
                    pricesum += (100 - rates[i]) * prices[i] / 100;
                }
            }
            if (pricesum >= buylimit){
                ans[0] += 1;
                pricesum = 0;
            }
            else{
                ans[1] += pricesum;
            }
        }
        return ans;
        
    }
}