import java.io.*;
import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        dfs(p);
        answer=dfs(p);
        return answer;
    }
    
    static Stack<Character> s;
    
    public static int div(String p){
        s =new Stack();
        int idx=0;
        int start=0;
        int end=0;
        while(true){
            if(p.charAt(idx)=='('){
                start++;
            }
            else{
                end++;
            }
            if(start==end) break;
            idx++;
        }
        return idx;
    }
    public static String dfs(String p){
         if(!p.trim().equals("")){
            int idx = div(p);
            String u=p.substring(0,idx+1);
            if(check(u)){
                return u+dfs(p.substring(idx+1));
            }
            else{
                String str = "";
                for(int i = 1; i < u.length()-1; i++) {
                     if(u.charAt(i) == '(') str = str + ")";
                     else str = str + "(";
                }
                return "(" + dfs(p.substring(idx+1)) + ")" +str;
            }
        }
        return "";
    }
    public static boolean check(String u){
         s =new Stack();
         int idx=0;
         while(idx<u.length()){
           if(u.charAt(idx)=='('){
               s.add('(');
           }
            else{
                if(!s.isEmpty()){
                    s.pop();
                }else{
                    return false;
                }
            }
            idx++; 
         }
        if(!s.isEmpty()) return false;
        return true;
    }
}
