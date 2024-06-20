import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        //큰 수부터 나오는 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        //pq에 works 다 넣기
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        while(n>0){
            int a = pq.poll();
            if(a==0){ //뻈는데 0이면 works 전부 다 0인 상태
                return 0;
            }
            a--;
            pq.add(a);
            n--;
        }
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a==0)break; //0나오면 뒤 더 볼 필요x
            answer+=a*a; 
        }
        
        return answer;
    }
}
