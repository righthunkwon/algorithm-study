import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 최대한 제곱되는 숫자가 최소한이 되게 만들어야함
        // 우선순위큐에 넣어가지고
        // n 번만큼 큰것들에서 -1씩 하면될듯
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 반대로해줘야 큰거부터 나옴
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        // 큐에 다 집어넣고 
        // for문으로 n번만큼 반복
        for(int i = 0;i<n;i++){
            int tmp = pq.poll();
            // 0이 되는게 있으면 전체 종료
            if(tmp ==0){
                break;
            }
            pq.add(tmp-1);
        }
        // 이제 answer계산
        while(pq.size()>0){
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
                
        return answer;
    }
}
