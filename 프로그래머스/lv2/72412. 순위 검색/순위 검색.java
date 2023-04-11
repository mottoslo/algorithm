import java.util.*;
class Solution {
    public static int[] solution(String[] info, String[] query) {
        //initialize codeMap
        codeMap.put("cpp",'1'); codeMap.put("java",'2'); codeMap.put("python",'3');
        codeMap.put("frontend",'4'); codeMap.put("backend",'5'); codeMap.put("senior",'6');
        codeMap.put("junior",'7'); codeMap.put("chicken",'8'); codeMap.put("pizza",'9'); codeMap.put("-",'-');
        int[] answer = new int[query.length];
        //Map 생성, key permutation별로 전부 삽입해주기
        Map<String, List<Integer>> keyMap = new HashMap<>();
        for (String inf:info){
            int score = getScore(inf);
            String[] encoded = encode_info(inf);
            for (String key:encoded){
                if (!keyMap.containsKey(key)){
                    keyMap.put(key, new ArrayList<Integer>());
                }
                keyMap.get(key).add(score);
            }
        }
        ///key별로 미리 정렬해놓기
        for (String elem:keyMap.keySet()){
            Collections.sort(keyMap.get(elem));
        }
        //query를 돌면서 이분탐색 진행
        int ansidx = 0;
        for (String qr:query){
            int cut = getScore(qr);
            qr = encode_query(qr);
            if (keyMap.containsKey(qr)){
                List<Integer> lst = keyMap.get(qr);
                answer[ansidx] = countscore(lst, cut);
                ansidx++;
            }
            else{
                answer[ansidx] = 0;
                ansidx++;
            }
        }
        return answer;
    }

    public static Map<String, Character> codeMap = new HashMap<>();

    public static char stringTocode(String code){

        return codeMap.get(code);
    }

    public static String[] encode_info(String info){

        String[] tempsplit = info.replaceAll(" [0-9]+", "").split(" ");
        int idx = 0;
        String[] permutations = new String[16];
        for (int i = 0; i<2; i++){
            char[] encoded = new char[4];
            encoded[0] = (i == 1)?stringTocode(tempsplit[0]):'-';
            for(int j = 0; j<2; j++){
                encoded[1] = (j == 1)?stringTocode(tempsplit[1]):'-';
                for(int k = 0; k < 2; k++){
                    encoded[2] = (k == 1)?stringTocode(tempsplit[2]):'-';
                    for(int n = 0; n<2; n++){
                        encoded[3] = (n == 1)?stringTocode(tempsplit[3]):'-';
                        permutations[idx] = String.valueOf(encoded);
                        idx++;
                    }
                }
            }
        }
        return permutations;
    }

    public static String encode_query(String query){
        String encoded = "";
        String[] tempsplit = query.replaceAll(" [0-9]+","").split(" and ");
        for (String sp:tempsplit){
            encoded += stringTocode(sp);
        }
        return encoded;
    }

    public static int getScore(String info){
        return Integer.parseInt(info.replaceAll("[^0-9*]",""));
    }

   public static int countscore(List<Integer> arr, int score){
        
	int mid=0;
    int end = arr.size();
	int start = 0;
        
    while (end > start) // end가 start보다 같거나 작아지면, 그 값이 Lower Bound이므로 반복을 종료한다.
	{
		mid = (start + end) / 2; 
       		if (arr.get(mid) >= score) // 중간값이 원하는 값보다 크거나 같을 경우, 끝값을 중간값으로 설정하여 다시 탐색한다.
			end = mid;
		else start = mid + 1; // 중간값이 원하는 값보다 작을 경우, 시작값을 중간값+1로 설정하여 다시 탐색한다.
	}
	return arr.size()-start;
        
    }
}