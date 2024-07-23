import java.util.*;

class Solution {
    static int[][] arr;
    static int n;
    static int min;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        // 각 지점마다 현재 지점까지 걸린 돈을 저장해서 백트래킹 하는방식?
        arr = new int[n+1][n+1];
        // fares에서 먼저 보기쉽게 바꾸면서 fare로 이동
        for(int i = 0 ;i<fares.length;i++){
            arr[fares[i][0]][fares[i][1]] = fares[i][2];
            arr[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        // 이동완료
        min = Integer.MAX_VALUE;
        
        
        // 각 모든 점에서 시작해서 s랑 a랑 b까지 가는 값들의 합에서 최소값을 찾으면됨
        int[] disA = new int[n + 1];
        int[] disB = new int[n + 1];
        int[] disS = new int[n + 1];

        disS = solve(s,disS);
        disA = solve(a, disA);
        disB = solve(b, disB);
        // 각각 a,b,s에서 뻗어나간 지점 다 값을 구해놓고 
        // i번째가 중간지점이 된다 가정하고
        // 최소값 구하기
        for(int i=1;i<=n;i++){
            // i에서 시작해서 모든 지점까지의 값을 구해놓고
            // a랑 b랑 s까지 최소로 이어지는 지점 최소값 구하기
            int price = disA[i] + disB[i] + disS[i];
            // -> s에서 i까지의 거리의 값 + i에서 각각 a랑 b까지 가는값
            if(price < min){
                min = price;
            }
            
        }
        
        
        return min;
    }
    
    static int[] solve(int start, int[] dis){        
       Arrays.fill(dis, Integer.MAX_VALUE);
        //전부 최대값 채워놓고
        // pq에는 현재까지의 값이 적은게먼저 오도록 설정해놓고
        // 시작지점은 0으로 설정하고 pq에서 시작
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        pq.offer(new int[]{0, start});
        dis[start] = 0;

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int st = now[1]; // 시작점을 꺼내서 시작
            // 만약 방문했으면 continue
            if(dis[st] < now[0]){
                continue;
            }
            
            for(int i = 0;i<=n;i++){
                // 만약 갈수 없는곳이면 continue;하고
                // 갈 수 있으면 현재 저장값보다 적으면 갱신
                if(arr[st][i] ==0){
                    continue;
                }
                // 갱신되면 현재 값과 위치를 pq에 추가
                if(dis[i] > dis[st] + arr[st][i]){
                    dis[i] = dis[st] + arr[st][i];
                    pq.add(new int[]{dis[i], i});
                }
                
            }
           
        }
        return dis;
    }
    
}
