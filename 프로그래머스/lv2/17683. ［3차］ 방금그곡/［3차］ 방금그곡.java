import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        //m : 1~ 1439    musicinfos < 100
        String answer = "";
        int maxlen = 0;
        
        List<Map.Entry<String, String>> melodies = new LinkedList<>();
        for(String info:musicinfos){
            listAdd(melodies, info, m);
            
        }
        if(melodies.size() == 0){
            return "(None)";
        }
        else{
            Collections.sort(melodies, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    
                    return o1.getKey().length() - o2.getKey().length();
                }
            });
        }
        for(Map.Entry<String, String> entry:melodies){
            if (maxlen < entry.getKey().length()){
                answer = entry.getValue();
                maxlen = entry.getKey().length();
            }
        }
        return answer;
    }
    
    public static void listAdd(List<Map.Entry<String, String>> lst, String info, String m){
        String[] infosplit = info.split(",");
        String encoded_m = encode(m);
        int len = getTimeDiff(infosplit[0], infosplit[1]);
        String new_melody = encode(infosplit[3]);
        String melody_long = new_melody.repeat(len/new_melody.length() + 1).substring(0,len);
        if(melody_long.contains(encoded_m)){
            lst.add(Map.entry(melody_long, infosplit[2]));
        }
    }
    
    public static int toAbsMin(String time){
        String[] hrmin = time.split(":");
        int hour = Integer.parseInt(hrmin[0]);
        int min = Integer.parseInt(hrmin[1]);
        return hour * 60 + min;
    }
    
    public static int getTimeDiff(String time1, String time2){
        int abs1 = toAbsMin(time1);
        int abs2 = toAbsMin(time2);
        return abs2 >= abs1? abs2-abs1: 1440 -(abs1-abs2);
    }
    public static String encode(String melody){
        String newMelody = melody.replaceAll("C#", "H").replaceAll("D#","I").replaceAll("F#","J").replaceAll("G#","K").replaceAll("A#","L");
        return newMelody;
    }
    
    
}