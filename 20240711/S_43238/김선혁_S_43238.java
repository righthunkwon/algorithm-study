class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 개어렵다 이분탐색인거 알고 풀음..
        // 시간을 정해놓고 해당 시간일 때 각 times에서 몇명이 return 할 수 있는지 count해서
        // 그 count의 합이 n보다 크다면 시간 줄이고, 반대로 n보다 작으면 시간 늘려서 무한루프
        
        // 우선 n의 배치가 최대로 될 수 있는점을  right로 설정해야함
        long max = 0;
        for(int i = 0 ; i<times.length;i++){
            max = Math.max(max, times[i]);
        }
        long left =0;
        long right = (n/times.length +1) * max;
        // middle에서 각 시간을 다 나눠서 sum에 다 더하고
        // 그 값이 n보다 큰지 비교
        while(true){
            long middle = (left+ right)/2;
            long sum = 0;
            for(int i = 0;i<times.length;i++){
                sum += (middle/times[i]);
            }
            // n보다크면 일단 middle 시간은 넣어놓고 right 줄임
            if(sum >= n){
                right = middle -1;
                answer = middle;
            }
            // 반대로 시간 늘림
            else{
                left = middle +1;
            }
            if(left > right){
                break;
            }
        }
        
        
        return answer;
    }
}
