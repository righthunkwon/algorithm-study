import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> st = new Stack<Integer>();
        int cnt = 0;
        for(int i = 0; i < number.length(); i++) {
            int t = number.charAt(i)-'0';
            while (!st.isEmpty() && cnt < k && t > st.peek()) {
                st.pop();
                cnt++;
            }
            if (st.size() < number.length() - k) st.push(t);
        }  
        for (int num : st) answer.append(num);
        return answer.toString();
    }
}
