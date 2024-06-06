import java.util.*;
import java.io.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeStr(m);
        String answer = "(None)";
        int longTime = 0;
        for (String music : musicinfos) {
            String[] arr = music.split(",");
            String[] arr0 = arr[0].split(":");
            String[] arr1 = arr[1].split(":");
            int time = (Integer.parseInt(arr1[0])-Integer.parseInt(arr0[0])) * 60
                + Integer.parseInt(arr1[1])-Integer.parseInt(arr0[1]);
            String musicinfo=changeStr(arr[3]);
            String musicinfoStr = "";
            for(int i=0;i<time/musicinfo.length();i++){
                musicinfoStr+=musicinfo;
            }
            for(int i=0;i<time%musicinfo.length();i++){
                musicinfoStr+=musicinfo.charAt(i);
            }
            if(musicinfoStr.contains(m) && longTime < time){
                longTime=time;
                answer = arr[2];
            } 
        }
        return answer;
    }
    public static String changeStr(String str){
            StringBuilder sb = new StringBuilder(str);
             while(true){
                int index= sb.indexOf("#");
                if(index == -1) break;   
                sb.setCharAt(index - 1, (char)(sb.charAt(index - 1) + 32));
                sb.deleteCharAt(index);
            }
        return sb.toString();     
    }
}
