import java.util.*;

class Solution {
    static class node implements Comparable<node>{
        int st;
        int en;
        node(int st, int en){
            this.st = st;
            this.en = en;
        }
        
        @Override
        public int compareTo(node o){
            return this.en - o.en;
        }  
    }
    static PriorityQueue<node> pq = new PriorityQueue<>();
    public int solution(int[][] targets) {
        int answer = 0;
        // A나라에서 발사한 미사일은 x축에 평행한 직선형태
        // B나라는 특정x좌표에서 y축에 수평이 되게 발사하며 모든 폭격 미사일 관통하여 한번에 요격 가능
        // 다만 개구간의 범위에서는 요격 불가능
        
        // 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return
        
        // 미사일이 발사되는 지점은 .5라고 가정하고 모든 미사일을 우선순위 큐에넣어
        // 큐를 끝지점이 오름차순되게 정렬하고
        // 첫번째 미사일부터 꺼내면서 해당 미사일 격추했을때 격추불가능한 시점의 정수까지 미사일 격추 진행 반복
        for(int i = 0 ;i<targets.length;i++){
            int st = targets[i][0];
            int en = targets[i][1];
            pq.add(new node(st,en));
        }
        // 모든 타겟을 넣었으니 하나씩 꺼내면서 진행
        int pos = 0;
        while(pq.size()>0){
            node n = pq.poll();
            // System.out.println(n.st +" "+ n.en);
            // 해당지점까지 격추 가능하면 continue;
            if(n.st < pos){
                continue;
            }
            // 해당 미사일은 격추안되는 것으로
            // answer+1하고 pos 갱신해준다.
            answer ++;
            pos = n.en;           
        }
        
        
        
        return answer;
    }
}
