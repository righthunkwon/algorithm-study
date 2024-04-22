import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] arr= s.toCharArray();        
        Stack<Character> st=new Stack();
        boolean answer = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(')st.add('(');
            else {
                if(st.isEmpty()) {
                    answer=false;
                    break;
                }
                st.pop();
            }
        }

        if(st.size()>0) answer=false;

        return answer;
    }
}
