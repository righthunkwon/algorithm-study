class Solution {
   public int solution(int[] stones, int k) {
        
        int answer = 0;
       
        int min = 0;
        int max = 200000000;
       
       //이분탐색으로 건널 사람 수의 최대값 구함
        while(min <= max) {
            int mid = (min + max) / 2;
            if(isPossible(mid, k, stones)) {
                answer = mid; //다 건널 수 있으면 정답 갱신
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    
    public boolean isPossible(int mid, int k, int[] stones) {
        int count = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < mid) { //mid보다 작으면 해당 돌 밟을 수 없음
                count++; //건너뛰어야 할 돌 갯수 +1
                if(count >= k) return false; 
            } else count = 0; //다시 초기화
        }
        return true;
    }
}
