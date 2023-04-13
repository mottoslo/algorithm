class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliversum = 0, pickupsum = 0;
        int maxgo = 0;
        
        for(int i = deliveries.length - 1; i>=0; i--){
            deliversum += deliveries[i];
            pickupsum += pickups[i];
            int delivernum = deliversum % cap ==0?deliversum/cap : deliversum/cap + 1;
            int pickupnum = pickupsum % cap ==0? pickupsum/cap : pickupsum/cap + 1;
            int maxnow = Math.max(delivernum, pickupnum);
            if (maxnow > maxgo){
                int multiplier = maxnow - maxgo;
                maxgo = maxnow;
                answer += (i+1)*2 * multiplier;
            }
        }
        
        return answer;
    }
}