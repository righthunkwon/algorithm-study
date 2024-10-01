class Solution {
    public int[] solution(int[] prices) {
        // 배열 크기는 완탐 돌려도 상관 없는 크기
        // 역순으로 탐색 하면 좋겠다.
        int n = prices.length; 
        // 완탐 풀이
        int[] answer = new int[n];
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
                if (j == n - 1) {
                    answer[i] = j - i;
                }
            }
        }
        // 스택 풀이
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i < n; i++) {
        //     while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        //         int j = stack.pop();
        //         answer[j] = i - j;
        //     }
        //     stack.push(i);
        // }
        // while (!stack.isEmpty()) {
        //     int j = stack.pop();
        //     answer[j] = n - 1 - j;
        // }
        return answer;
    }
}