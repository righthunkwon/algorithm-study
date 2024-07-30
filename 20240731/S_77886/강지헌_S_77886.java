import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;
        for(int i=0; i<s.length; i++) {
            String st = s[i];
            Stack<Character> stack = new Stack<>();
            int t = 0;
            boolean f = false;
            for(int j=0; j<st.length(); j++) {
                char c = st.charAt(j);
                if(stack.size()>=2) {
                    char b = stack.pop(),a = stack.pop();
                    if(a=='1' && b=='1' && c=='0') t++;
                    else {
                        stack.push(a);
                        stack.push(b);
                        stack.push(c);
                    }
                }
                else stack.push(c);
            }
            int o = stack.size();
            sb = new StringBuilder();
            while(!stack.isEmpty()) {
                if(!f && stack.peek()=='1') o--;
                if(!f && stack.peek()=='0') f = true;
                sb.insert(0, stack.pop());
            }
            if(t>0) {
                for(int j=t;j>0;j--,o+=3) sb.insert(o, "110");
                answer[i] = sb.toString();
            }
            else answer[i] = s[i];
            
        }
        return answer;
    }
}
