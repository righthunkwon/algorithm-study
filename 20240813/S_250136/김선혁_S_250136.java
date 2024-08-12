import java.util.*;

class Solution {
    static int[][] land;
    static int n;
    static int m;
    static boolean[] visited; // 번호에 대한 방문처리
    static ArrayList<Integer> ar;
    public int solution(int[][] land) {
        int answer = 0;
        // 먼저 각각 덩어리들 번호 붙인 다음에
        // 번호는 2~
        
        // arr리스트 하나만들어서 
        // 0,0 넣어놓고 2번쨰부터 각 번호에 해당하는 값 넣어놓음
        // 그리고 매번 수직 횟수마다 flag 배열로 방문처리해서 개수 찾자
        
        // 번호붙이기
        this.land = land;
        n = land.length;
        m = land[0].length;
        ar = new ArrayList<Integer>();
        ar.add(0);
        ar.add(0);
        int index =2;
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(land[i][j] == 1){
                    // 1만나면 해당 위치를 모두 번호로 교환
                    // 번호 붙이기 + 개수 count
                    num(index, i,j);
                    index ++;
                }
            }
        }
        // 이제 한줄씩 시작
        visited = new boolean[index];
        int sum = 0;
        for(int j = 0;j<m;j++){
            visited = new boolean[index];
            sum = 0;
            // 한줄을 골랐을 때 
            // 그 수가 0이 아니면 그 번호에 해당하는
            // 기름 값더하고 방문처리
            for(int i=0;i<n;i++){
                if(land[i][j] == 0 || visited[land[i][j]]){
                    continue;
                }
                sum += ar.get(land[i][j]);
                visited[land[i][j]] = true;
            }
            answer = Math.max(sum, answer);
        }
        
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         System.out.print(land[i][j]+" ");
        //     }
        //    System.out.println();
        // }
        // for(int i = 0;i<ar.size();i++){
        //     System.out.println(i+" "+ ar.get(i));
        // }
        
        
        return answer;
    }
    static void num(int index , int i, int j) {
        // count를 먼저하는데 지나가는 위치를 큐에 넣고 index로 바꿈
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        
        qx.add(i);
        qy.add(j);
        land[i][j] = index;
        int count = 1;
        while(true){
            if(qx.size() == 0){
                break;
            }
            int x = qx.poll();
            int y = qy.poll();
            for(int in = 0;in<4;in++){
                int nx = x+dx[in];
                int ny = y+dy[in];
                // 조건 확인하고
                // 조건만족하면 방문처리하고 큐에 추가
                if(nx<0 || ny <0 || nx>=n || ny>=m || land[nx][ny] !=1){
                    continue;
                }
                qx.add(nx);
                qy.add(ny);
                count ++;
                land[nx][ny] = index;
            }
        }
        // qx2에있는거 모두 꺼내서 
        ar.add(count);
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    
}
