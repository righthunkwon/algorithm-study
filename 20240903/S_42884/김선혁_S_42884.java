import java.util.*;

class Solution {
    static class node implements Comparable<node>{
        int x;
        int y;
        node(int x, int y){
            this.x = x;
            this.y =y;
        }
        public int compareTo(node n){
            return this.y - n.y;
        }
        
    }
    static PriorityQueue<node> pq = new PriorityQueue<node>();
    public int solution(int[][] routes) {
        int answer = 0;
        // 나가는 시간을 기준으로 우선순위 큐에 정렬한 후 
        // 그 첫지점에 카메라를 설치한다 생각하면
        // 그 지점보다 x가 적은애들은 pass, 
        // 그 지점보다 뒤에나오면 +1해주고 숫자를 교체
        for(int i = 0;i<routes.length;i++){
            int a = routes[i][0];
            int b = routes[i][1];
            pq.add(new node(a,b));
        }
        // 우선 모두 pq에 더하고 하나씩 꺼내자
        while(true){
            if(pq.size() ==0){
                break;
            }
            node n = pq.poll();
            int line = n.y;
            // 현재 꺼낸점의 y에 카메라를 설치한다 가정하고
            // pq에서 y점보다 큰점이 나올때까지 꺼낸다
            answer ++;
            while(pq.size()>0){
                node tmp = pq.peek();
                // x보다 크다면 break하고 
                // 아니면 해당지점은 포함이라 pq에서 그냥 꺼냄
                if(tmp.x > line){
                    break;   
                }           
                pq.poll();
            }
            
        }
        
        
        return answer;
    }
}
