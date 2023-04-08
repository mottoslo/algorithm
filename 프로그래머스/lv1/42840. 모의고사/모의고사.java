class Solution {
    public int[] solution(int[] answers) {
        int[] numcorrect = new int[3];
        int[] for2 = {1,3,4,5};
        int[] for3 = {3,1,2,4,5};
        for (int i = 0; i< answers.length; i++){
            numcorrect[0] += (answers[i] == i%5 + 1)?1:0;
            numcorrect[1] += (i%8%2 ==0)?(answers[i] == 2?1:0):(for2[i%8/2] == answers[i]?1:0);
            numcorrect[2] += (for3[i%10/2] == answers[i])?1:0;
        }
        int max = 0;
        for(int num:numcorrect){
            max = Math.max(num, max);
        }
        int cnt = 0;
        for(int num:numcorrect){
            if (num == max){
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        int personidx = 0;
        int ansidx = 0;
        while(personidx <3){
            if(numcorrect[personidx] == max){
                answer[ansidx] = personidx+1;
                ansidx ++;
            }
            personidx++;
        }
        
        
        return answer;
    }
    
    
    
}