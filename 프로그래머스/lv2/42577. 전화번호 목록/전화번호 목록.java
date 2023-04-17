import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> keyset = new HashSet<>();
        for(int i = 0; i<phone_book.length; i++){
            for(int j = 1;j<phone_book[i].length();j++){
                keyset.add(phone_book[i].substring(0, j));
            }
        }
        for(int i = 0; i<phone_book.length; i++){
            if (keyset.contains(phone_book[i])){
                return false;
            }
        }
        
        return true;
    }
}