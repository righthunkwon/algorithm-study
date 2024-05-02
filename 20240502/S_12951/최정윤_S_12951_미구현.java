import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr=s.split(" ");
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
           
            if(arr[i].length()>0){
           char start=arr[i].charAt(0);
            if(start-'0'>=0&&start-'0'<=9){
                answer+=start;
            }else{
                answer+=Character.toUpperCase(start);
            }
            if(arr[i].length()>1) answer+=arr[i].substring(1).toLowerCase();
            }
        if(i!=arr.length-1) answer+=" ";
        }
        if(arr[arr.length-1].length()==0) answer+=" ";
        return answer;
    }
}
