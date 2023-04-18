import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> mylist = new LinkedList<>();
        for(int i = 0; i<numbers.length; i++){
            mylist.add(String.valueOf(numbers[i]));
        }
        Collections.sort(mylist, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(String elem:mylist){
            answer += elem;
        }
        
        answer = answer.replaceAll("^[0]+$","0");
        
        
        return answer;
    }
}