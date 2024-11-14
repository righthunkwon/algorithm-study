class Solution {
    public int solution(String numbers) {
        int answer = 0;
        // 이동하지 않고 제자리에서 다시 누르는 것은 가중치가 1
        // 상하좌우로 인접한 숫자로 이동하여 누르는 것은 가중치가 2
        // 대각선으로 인접한 숫자로 이동하여 누르는 것은 가중치가 3
        
        // 방법 1. 전체 모두 방법을 dfs로 선택한 후 각 방법 실행 결과에 따라
        // 최소값을 갱신 하는 방식
        // -> 시간 초과
        
        // 방법 2. dp 방법으로 푸는 방법 -> 블로그 참고
        
        
        
        return answer;
    }
}
