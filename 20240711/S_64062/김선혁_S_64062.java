class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        // 하나씩 건너면서 k개만큼 사이에 최대값이
        // 전체에서 최소값인 부분을 찾아야함
        // 애초에 for문을 통해 각 1번부터 전체길이-k까지 최대값써서 찾는게 --> 시간초과
        
        // 반대로 넘어갈 수 있는 인원을 정해서
        // 그 인원만큼의 값을 k개의 연속된 돌의 값을 넘으면
        // 인원늘리고, 적으면 인원줄여서
        int left = 0;
        int right = 200000001; // 2억까지의 자연수
        while(true){
            int middle = (left+ right)/2;
            // 연속된 k개의 값이 middle값을 넘는지 비교
            int tmp = 0;
            for(int i =0;i<stones.length;i++){
                if(stones[i] - middle <= 0){
                    tmp++;
                }
                else{
                    tmp = 0;
                }
                // 중간에 k개 이상이면 인원 줄이기
                if(tmp >= k){
                    right = middle -1;
                    break;
                }
            }
            // 이과정에서 k보다 적다면 인원늘리고 현재값은 기록
            if(tmp < k){
                left = middle+1;
                answer = left; // 이거 맨날 헷갈림
            }
            // 좌측이 우측넘어가면 break
            if(left > right){
                break;
            }
            
        }
        
        
        
        return answer;
    }
}
