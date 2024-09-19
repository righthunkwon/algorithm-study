// 2분탐색 문제 , 푸는데 걸린시간 : 20분
// 한번에 풀렸는데 left로 설정하니 바로 풀려서 얼떨떨..

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // 계속 퍼즐을 풀면서 time_prev에 누적 시간을 기록해 놓음
        // 현재 3레벨 다음 맵이 5레벨이면 2번 틀려야함. 
        // -> 여태까지의 시간 + time_cur + 여태까지 시간 + time_cur + 여태까지 시간 + time_cur로 해야함
        // -> (diff-level) * (time_cur + time_prev) + time_cur
        
        // limit 내에 퍼즐을 깰 수 있는 숙련도의 최소값
        // 숙련도 범위가 넓다면 이분탐색 사용
        
        // 최대값을 구해 그 점을 right로 두고 진행
        int left = 1;
        int right = 1;
        for(int i = 0 ;i<diffs.length;i++){
            right = Math.max(right, diffs[i]);
        }
        while(true){
            long time = 0;
            int mid = (left + right) /2;
            boolean flag = true;
            // 이제 mid를 가지고 for문을 통해 진행
            for(int i = 0;i<diffs.length;i++){
                // 만약 현재 mid가 퍼즐레벨보다 높으면
                // times[i] 만큼만 추가
                // 반대로 적다면 레벨차이 * (전시간+ 현재시간) + 현재시간만큼 time에 추가
                if(mid >= diffs[i]){
                    time += (long)times[i];
                }
                else {
                    time += (long)(diffs[i] - mid) * (times[i-1] + times[i]) + times[i];
                }
                // 하던도중 limit 넘으면 현재 숙련도가 높아져야하며
                // 반대로 limit보다 적다면 숙련도를 낮춰서 진행
                if(time > limit){
                    flag = false;
                    break;
                }
            }
            // 현재 flag가 false이면 숙련도 높여야한다.
            if(flag){
                right = mid -1;
            }
            else {
                left = mid +1;
            }
            
            // 만약 right가 left보다 적거나 right가 0이되면 끝냄
            if(right < left || right < 1){
                answer = left;
                break;
            }
            
        }
        
        return answer;
    }
}
