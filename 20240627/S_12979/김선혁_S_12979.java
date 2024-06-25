class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 그냥 쭉 탐색하다가 false인 곳보이면 -> 선언하면 시간초과 index로 놀아야할듯
        // wx2 만큼 true 바꾸고 그 다음부터 시작
        int index = 1;
        int stidx = 0;
        while(true){
            // 처음부터 진행 시작
            if(index > n){
                break;
            }
           // 조건 2가지 - 1. answer가 올라갈 조건  2. stidx만 올라갈조건
            // 1. 현재 stidx번째 해당하는 값 - w보다 index가 적어야함(stidx의 값이 끝까지 간경우)
            // answer ++ 해주고 현재위치 + (2*w) +1 로 이동
            
            // 2. 기지국 범위 내인 경우
            // stidx ++ 해주고 stidx번째 값 + w +1 의 위치로 이동
            if(stidx >= stations.length || index < stations[stidx] - w ){
                answer ++;
                index += 2*w + 1;
            }
            else{
                // 나머지 경우(2)
                index = stations[stidx] + w +1;
                stidx ++;    
            }
        }
        
        return answer;
    }
}
