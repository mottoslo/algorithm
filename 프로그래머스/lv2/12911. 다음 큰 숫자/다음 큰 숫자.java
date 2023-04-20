class Solution {
    public int solution(int n) {
        int numOnes = countOnes(Integer.toBinaryString(n));
        while(true){
            n++;
            if(countOnes(Integer.toBinaryString(n)) == numOnes){
                break;
            }
        }
        return n;
    }
    
    public int countOnes(String biNum){
        int cnt = 0;
        for(int i = 0; i<biNum.length(); i++){
            if(biNum.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }
}