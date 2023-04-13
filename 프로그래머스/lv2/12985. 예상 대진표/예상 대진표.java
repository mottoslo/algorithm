class Solution
{
    public int solution(int n, int a, int b)
    {
        a = a-1;
        b = b-1;
        int answer = 1;
        while(a/2 != b/2){
            a /= 2;
            b /= 2;
            answer +=1;
        }

        return answer;
    }
}