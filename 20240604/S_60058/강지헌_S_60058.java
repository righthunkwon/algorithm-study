import java.util.Stack;

public class Solution {
    
    public String solution(String p) {
        return dfs(p);
    }
    
    public String dfs(String arr){
        if(arr.length() == 0) return "";
        int c = 0, t = 0;
        Stack<Character> st = new Stack<>();
        while (true) {
            st.add(arr.charAt(c));
            if(arr.charAt(c++) == '(') t++;
            else t--;
            if(t==0) break;
        }
        t = 0;
        boolean f = true;
        while (!st.isEmpty()){
            char p = st.pop();
            if(p == ')') t++;
            else t--;
            if(t < 0){
                f = false;
                break;
            }
        }

        if(f) return arr.substring(0, c) + dfs(arr.substring(c));
        
        String ans = "";
        for(int i = 0; i < arr.substring(1,c-1).length(); i ++) {
            if(arr.substring(1,c-1).charAt(i) == '(') ans = ans + ")";
            else ans = ans + "(";
        }
        return "(" + dfs(arr.substring(c)) + ")" + ans;
    }
}
