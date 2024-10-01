rimport java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<prices.length;i++) {
            while(!st.isEmpty()) {
                if(st.peek()[1]<=prices[i]) break;
                int[] t = st.pop();
                answer[t[0]]=i-t[0];
            }
            st.push(new int[]{i,prices[i]});
        }
        while(!st.isEmpty()) {
            int[] t=st.pop();
            answer[t[0]]=prices.length-t[0]-1;
        }
        return answer;
    }
}
