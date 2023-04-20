import java.util.*;
class Solution {
    int MAX = 0;
    
    public int solution(int k, int[][] dungeons) {
        int[] dun_visited = new int[dungeons.length];
        for(int i = 0; i<dungeons.length; i++){
            search(k, dungeons, i, dun_visited, 0);
        }
        return MAX;
    }
    
    public void search(int user_p, int[][] dungeons, int dunidx, int[] dun_visited, int cur){
        if(cur > dungeons.length || user_p < dungeons[dunidx][0]){
            MAX = Math.max(MAX, cur);
            return;
        }
        if(isvisited(dunidx, dun_visited, cur)){return;}
        else{
            dun_visited[cur] = dunidx;
            user_p -= dungeons[dunidx][1];
            for(int i = 0; i<dungeons.length; i++){
                search(user_p, dungeons, i, dun_visited, cur+1);
            }
        }
        return;
    }
    
    public boolean isvisited(int dunidx, int[] visited, int cur){
        for(int i = 0; i<cur;i++){
            if (dunidx == visited[i]){
                return true;
            }
        }
        return false;
    }
}