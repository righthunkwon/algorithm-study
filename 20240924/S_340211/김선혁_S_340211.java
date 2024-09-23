import java.util.*;

class Solution {
    static Queue<int[]>[] q; // 경로를 큐에다가 계속 기록하면서 진행
    static int len; 
    static int answer;

    public int solution(int[][] points, int[][] routes) {
        len = routes.length;
        q = new LinkedList[len];
        // 로봇 x대는 모두 0초에 출발해서 1만큼 좌표 이동
        // 항상 최단경로로 이동하는데 r우선 c 나중
        // 로봇이 물류센터에 도착하면 그대로 끝
        // 두대 이상이 동시에 모이게 되면 위험상황 +1
        
        //로봇하나씩 bfs로 좌표이동
        // 이동하면서 해당 좌표에 no+1의 숫자를 남겨놓고
        // 두개가 겹칠 경우 그 좌표를 true처리해놓음
        // 모든 로봇들을 한번 움직이면 flag 배열 초기화
        // 각 로봇의 경로를 저장할 큐 초기화
        for (int i = 0; i < len; i++) {
            q[i] = new LinkedList<>();
        }
        
        solve(points, routes); 
        
        return answer;      
    }

    // 로봇의 경로를 계산하고 충돌을 카운트하는 메소드
    public void solve(int[][] points, int[][] routes) {
        // 1. 현재 루트에서 첫번째 있는 숫자가 출발점, 두번째가 도착점으로
        // 시작 포인트의 좌표를 points에서 찾아서 큐에다가 넣고 시작
        for (int i = 0; i < len; i++) {
            int x = points[routes[i][0] - 1][0]; 
            int y = points[routes[i][0] - 1][1]; 
            // 현재 출발할 지점을 먼저 큐에다가 넣음
            q[i].add(new int[]{x, y}); 
            // 출발지점 넣고 도착하는 지점의 좌표를 찾음
            for (int j = 1; j < routes[i].length; j++) {
                int nx = points[routes[i][j] - 1][0];
                int ny = points[routes[i][j] - 1][1]; 
                // 좌표를 이동하는데 r이 우선이므로 목적지의 r과 같아질 때까지 이동한다
                // r이동 끝나면 c이동                 
                while (x != nx) {
                    x += (nx > x) ? 1 : -1; 
                    q[i].add(new int[]{x, y}); 
                }
                while (y != ny) {
                    y += (ny > y) ? 1 : -1; 
                    q[i].add(new int[]{x, y}); 
                }
            }
        }

        // 이동 경로를 진행하면서 여러개가 한지점에 모일때를 찾자
        while (true) {
            int[][] map = new int[101][101];
            int cnt = 0; 
            // 비어있는 큐의 수 카운트

            // 각 로봇의 현재 위치를 맵에 기록하는데
            // 만약 큐에 아무것도 없으면 끝난거로 패스하고
            // 있다면 맵에 +1로 기록
            for (int i = 0; i < len; i++) {
                if (q[i].size() ==0) {
                    cnt++;
                    continue; // 큐가 비어있으면 건너뜀
                }
                int[] current = q[i].poll(); // 현재 위치 가져오기
                map[current[0]][current[1]]++; // 맵에 위치 기록
            }
                
            // 모든 로봇이 도착한 경우 종료
            if (cnt == len) {
                break; 
            }
            // 한번 쭉 다 움직였으면
            // 맵을 순회하면서 충돌한 개수를 count 한다.
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    // 어차피 여러개가 한지점에 모여있으면 1이상임
                    if (map[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }
    }
}
