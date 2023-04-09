class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        String[] strarr1 = toStrArr(arr1, n);
        String[] strarr2 = toStrArr(arr2, n);
        for(int i = 0; i<arr1.length; i++){
            String tempstr = "";
            for(int j = 0; j<strarr1[i].length(); j++){
                // System.out.println(strarr1[i].charAt(j));
                tempstr += (strarr1[i].charAt(j) == '1' || strarr2[i].charAt(j) == '1')?"#":" ";
            }
            answer[i] = tempstr;
        }
        
        return answer;
    }
    
    public static String toBinary(int num, int n){
        int binLen = 1;
        int tempnum = num;
        while(tempnum / 2 > 0){
            tempnum /= 2;
            binLen +=1;
        }
        char[] charr = new char[n];
        for (int i = 0; i<n - binLen; i++){
            charr[i] = '0';
        }
        for (int i = n-1; i>=n - binLen; i--){
            charr[i] = (char)(num%2 + '0');
            num /=2;
        }
        // System.out.println(String.valueOf(charr));
        return String.valueOf(charr);
    }
    
    public static String[] toStrArr(int nums[], int n){
        String[] starr = new String[nums.length];
        for (int i = 0; i<nums.length; i++){
            starr[i] = toBinary(nums[i], n);
        }
        return starr;
    }
    
    
}