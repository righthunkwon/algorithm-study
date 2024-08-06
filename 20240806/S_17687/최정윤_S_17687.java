import java.io.*;
import java.util.*;


class Solution {
    public String solution(int n, int t, int m, int p) {
        int start=0;
        StringBuilder sb=new StringBuilder();
        //미리 1~ sb에 담아놓는다
        while(true){
            //진수변환
            String str=Integer.toString(start,n);
            sb.append(str);
            //구해야하는 개수보다 많으면 그만
            if(sb.length()>m*t) break;
            start++;
        }
        //p번째만 정답에 담기
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<t;i++){
            ans.append(sb.substring(p+(m*i)-1,p+(m*i)));
        }
        //대문자변환
        String answer = ans.toString().toUpperCase();
        return answer;
    }
}
