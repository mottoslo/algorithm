class Solution {
    public static String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        System.out.println("1단계 이후 : " + new_id);
        //2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        System.out.println("2단계 이후 : " + new_id);
        //3단계
        new_id = new_id.replaceAll("\\.+",".");
        System.out.println("3단계 이후 : " + new_id);
        //4단계
        new_id = new_id.replaceAll("^\\.|\\.$","");
        System.out.println("4단계 이후 : " + new_id);
        //5단계
        new_id = new_id.length() == 0?"a":new_id;
        System.out.println("5단계 이후 : " + new_id);
        //6단계
        new_id = new_id.substring(0, Math.min(15, new_id.length()));
        new_id = new_id.replaceAll("^\\.|\\.$","");
        System.out.println("6단계 이후 : " + new_id);
        //7단계
        int nowlen = new_id.length();
        for(; new_id.length() < 3; ){
            new_id += new_id.charAt(nowlen - 1);
        }
        System.out.println("7단계 이후 : " + new_id);
        return new_id;
    }
}