import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        //그냥 works 중에 최댓값 계속 찾아서 줄이기
        //우선순위큐에 넣자
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);    
        }
        for(int i=0;i<n;i++){
            if(pq.isEmpty()) return 0;
            int work=pq.poll();
            if(work==1) continue;
            pq.add(work-1);
        }
        long answer = 0;
        while(!pq.isEmpty()){
            int t=pq.poll();
            answer+=t*t;
        }
        return answer;
    }
}
