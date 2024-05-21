import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!st.isEmpty() && numbers[st.peek()] < numbers[i]) answer[st.pop()] = numbers[i];
            st.push(i);
        }
        return answer;
    }
}
