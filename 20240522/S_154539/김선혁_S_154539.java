import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 숫자를 다 스택에 넣으면서
        // peek에 있는 숫자보다 크면 -1, size 0이어도 -1
        // 아니면 그 숫자 빼면서 기록
        
        Arrays.fill(answer, -1); // 초기값을 -1로 세팅
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<numbers.length;i++){
            while(true){
                // 크기가 0이거나 현재숫자가 적으면 그 숫자 기록하면 되므로 break
                 if(st.size() ==0 || numbers[st.peek()] >= numbers[i]){
                    break;
                 }
                 answer[st.pop()] = numbers[i];
             }
            st.push(i);
            }
        return answer;
    }
}
