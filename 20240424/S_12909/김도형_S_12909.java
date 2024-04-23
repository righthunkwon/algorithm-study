import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> st = new Stack<>();
        int l = s.length();
    loof:for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                if(c ==')'){
                    answer = false;
                    break loof;
                }else{
                    st.add(c);
                }
            }else{
            	if(c =='(') {
            		st.add(c);
            	}else {
            		st.pop();
            	}
            }
        }
        
        if(!st.isEmpty()){
            answer=false;
        }
        
        return answer;
    }
}
