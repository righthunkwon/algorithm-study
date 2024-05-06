import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] arr=s.toCharArray();
        Stack<Character> st=new Stack();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty())st.add(arr[i]);
            else{
                if(st.peek()==arr[i]) st.pop();
                else st.add(arr[i]);
            }
        }
        if(st.size()==0) answer=1;
        else answer=0;
        return answer;
    }
}
