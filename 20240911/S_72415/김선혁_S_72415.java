import java.util.*;
class Solution {
   
    static class pair {
        public int x, y;
        pair(int x, int y){
            this.x = x; 
            this.y = y;
        }
    }
    static int p[] = new int[6];
    static boolean isused[] = new boolean[7]; // 사용된 카드 체크
    static int n = 0;
    static int ans = Integer.MAX_VALUE;
    static pair occur[][] = new pair[7][2]; // 카드 위치 저장
    static int[][] bboard = new int[4][4]; // 원본 보드
    static int rr, cc; // 현재 커서 위치
    
   
    public int solution(int[][] board, int r, int c) {
        // 좌표를 저장하는 pair 클래스 정의해서
        // BFS를 사용하여 시작 좌표에서 목표 좌표까지의 최단 거리를 계산해서
        // 최적의 카드 제거 순서를 찾고, 그에 따른 최소 이동 거리를 계산
        rr = r; cc = c; // 커서 초기 위치 설정
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                bboard[i][j] = board[i][j]; // 원본 보드 복사
        for(int i = 0; i < 7; i++){
            occur[i][0] = new pair(-1, -1); // 카드 위치 초기화
            occur[i][1] = new pair(-1, -1);      
        }
        
        // 보드에서 카드의 위치를 저장
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j] == 0) continue;
                if(occur[board[i][j]][0].x == -1){
                    occur[board[i][j]][0] = new pair(i, j);
                    n++;
                }
                else
                    occur[board[i][j]][1] = new pair(i, j);
            }
        }
        
        solve(0); // 순열 생성 후 최적의 카드 순서 찾기
        return ans + 2 * n; // 최종 이동 횟수 반환 (카드 선택 횟수 포함)
    }
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    
     // 순열을 이용해 최적의 카드 순서를 찾아내는 함수
    static void solve(int idx){
       
        if(idx == n){ // 모든 카드 순서를 정한 경우
            int myboard[][] = new int[4][4]; // 작업할 보드 복사
            for(int i = 0; i < 4; i++)
                for(int j = 0; j < 4; j++)
                    myboard[i][j] = bboard[i][j];
            int d[][] = new int[6][2]; // 카드 선택에 따른 거리 배열
            
            // 첫 번째 카드에 대한 거리 계산
            d[0][0] = dist(myboard, new pair(rr, cc), occur[p[0]][0]) + dist(myboard, occur[p[0]][0], occur[p[0]][1]);
            d[0][1] = dist(myboard, new pair(rr, cc), occur[p[0]][1]) + dist(myboard, occur[p[0]][1], occur[p[0]][0]);
            myboard[occur[p[0]][0].x][occur[p[0]][0].y] = 0; // 카드를 제거
            myboard[occur[p[0]][1].x][occur[p[0]][1].y] = 0;
            
            // 그 이후 카드들에 대한 거리 계산
            for(int i = 1; i < n; i++){
                d[i][0] = Math.min(d[i-1][0] + dist(myboard, occur[p[i-1]][1], occur[p[i]][0]), 
                                   d[i-1][1] + dist(myboard, occur[p[i-1]][0], occur[p[i]][0])) 
                                   + dist(myboard, occur[p[i]][0], occur[p[i]][1]);
                d[i][1] = Math.min(d[i-1][0] + dist(myboard, occur[p[i-1]][1], occur[p[i]][1]), 
                                   d[i-1][1] + dist(myboard, occur[p[i-1]][0], occur[p[i]][1])) 
                                   + dist(myboard, occur[p[i]][1], occur[p[i]][0]);
                // 카드를 제거
                myboard[occur[p[i]][0].x][occur[p[i]][0].y] = 0;
                myboard[occur[p[i]][1].x][occur[p[i]][1].y] = 0;    
            }
            ans = Math.min(Math.min(ans, d[n-1][0]), d[n-1][1]); // 최소 이동 거리 갱신
        }
        
        // 순열을 생성하여 카드 순서를 설정
        for(int i = 1; i <= 6; i++){
            if(occur[i][0].x == -1 || isused[i]) continue; // 카드가 없는 경우
            p[idx] = i; // 카드 선택
            isused[i] = true;
            solve(idx+1);
            isused[i] = false;            
        }
    }
    
     // dst까지의 최단 거리를 구하는 함수
    static int dist(int[][] board, pair src, pair dst){
        int d[][] = new int[4][4]; // 거리 배열
        // 방문하지 않은 곳을 -1로 초기화
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                d[i][j] = -1;
        d[src.x][src.y] = 0; // 시작 위치의 거리를 0으로 설정
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src.x, src.y)); // 시작 위치를 큐에 추가
        while(!q.isEmpty()){
            pair cur = q.poll(); // 현재 위치
            for(int dir = 0; dir < 4; dir++){ // 4방향 탐색
                int en = 0; // dir 방향으로 이동할 거리
                while(true){
                    int nx = cur.x + dx[dir] * en;
                    int ny = cur.y + dy[dir] * en;
                    // 이동 범위가 벗어나거나 카드에 도달하면 멈춤
                    if(OOB(nx + dx[dir], ny + dy[dir]) || (en != 0 && board[nx][ny] != 0)) break;
                    en++;
                }
                // 1칸 또는 카드를 넘어서 이동 시도
                for(int i = 0; i < 2; i++){
                    int z = (i == 1) ? en : 1; // 1칸 이동 또는 최대로 이동
                    int nx = cur.x + dx[dir] * z;
                    int ny = cur.y + dy[dir] * z;
                    if(OOB(nx, ny)) continue;
                    if(d[nx][ny] == -1){ // 방문하지 않은 경우만 처리
                        d[nx][ny] = d[cur.x][cur.y] + 1;
                        q.add(new pair(nx, ny)); // 다음 위치를 큐에 추가
                    }
                }                
            }
        }
        return d[dst.x][dst.y]; // 목적지까지의 최단 거리 반환
    }
    
     // 범위를 벗어나는지 확인하는 함수 (Out of Bounds)
    static boolean OOB(int x, int y){
        return x < 0 || x > 3 || y < 0 || y > 3;
    }
    
}
