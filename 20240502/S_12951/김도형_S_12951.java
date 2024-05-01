import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        
        char[]arr = s.toCharArray();
        int idx = 0;
        int len = arr.length;
        boolean flag = true; //첫글자는 대문자니까 true로 초기화
        
        for(int i=0;i<len;i++){
            char x = arr[i];
            if(x==' '){ //띄어쓰기면 다음문자 대문자로하기위해 flag true
                flag = true;
            }else if(flag){
                x = Character.toUpperCase(x);
                flag=false;
            }
            sb.append(x);
        }
        
        String answer = sb.toString();
        return answer;
    }
}
