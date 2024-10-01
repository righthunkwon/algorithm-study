class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        // 완전탐색..?
        // 무조건 시간초과날듯함.. 시간을 기준으로 이분탐색?
        // 최대 시간이 최대값 20억 x 100000 x2 
        long min =  1;
        long max = 400000000000000L; 
        int len = g.length;
        while(true){
            if(min > max){
                break;
            }
            int gold = 0, silver = 0, sum = 0;
            long mid = (max + min)/2;
            // 방식은 해당 시간동안 각 마을이 몇번돌 수 있는지 확인하고
            // 그 횟수만큼 도시를 순회하여 최대의 자원을 가져옴
            for(int i = 0;i<len;i++){
                int weight = w[i];
                int time = t[i];
                long cnt =  mid/(time*2);
                if(mid % (time*2)>= t[i]){
                    cnt++;
                }
                // 편도 가능한것 고려
                // 이제 각 금 은 두개의 합무게 계산
                gold += Math.min(g[i], weight * cnt);
                silver += Math.min(s[i], weight * cnt);
                sum += Math.min(g[i] + s[i] , weight * cnt);
            }
            // 이러면 모든도시에서 나올 수 있는 합 다 계산함
            // 3가지가 모두 다 만족하면 시간 줄이고, 반대면 시간 늘림
            if(gold>= a && silver >= b && sum >= a+b){
                max = mid-1;
                answer = mid;
            }
            else{
                min = mid +1;
            }
            
        }
        
        return answer;
    }
}
