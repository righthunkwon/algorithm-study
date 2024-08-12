class Solution {
     static int[][] arr;
    static int rx, ry;
    static int bx, by;
    static boolean rflag, bflag;
    static int n, m;
    static boolean[][][] flag; // 0이 r 1이 b
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        // 일반적으로 둘이 하나씩 움직이고
        // 현재 같은 위치인지랑
        // 위치가 서로 바뀐건지만 백트래킹
        
        // 추가로 도착했으면 true처리로
        // 더 못움직이게 해야할듯
        n = maze.length;
        m = maze[0].length;
        arr = new int[n][m];
        flag = new boolean[2][n][m];
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = maze[i][j];
                if(arr[i][j] == 1){
                    rx = i;
                    ry = j;
                }
                if(arr[i][j] == 2){
                    bx = i;
                    by = j;
                }
            }
            // 두 색의 시작점만 좌표 저장해서 시작
            // r은 3, b는 4나오면 끝
        }
        
        
        
        return answer;
    }
    static void solve(int rx,int ry, int bx,int by, int cnt, boolean[][][] flag){
        
        // 두개모두 true면 끝
        if(rflag && bflag){
            answer = Math.min(answer, cnt);
            return;
        }
        //빨강 움직이고 파랑움직이자 
        // + 백트래킹
        
        // 만약 현재 cir이 false 이면
        // red 차례이고 
        // red가 수행후 blue로 전환(이때는 cnt그대로)
        // cir이 true면  ----> 이러면 둘이 스위칭 되는거 판단 힘든데.. -> 미구현?
        for(int i = 0; i < 4; i++){
            	// 도착지점이면 그대로
            int nrx = rx;
            int nry = ry;
            if(!rflag){
                nrx += dx[i];
                nry += dy[i];
            }
            int nbx = bx;
            int nby = by;
            if(!bflag){
                nbx += dx[i];
                nby += dy[i];
            }
            // 일단 움직이고 범위 확인하고 정답인지 확인
            if (!isValid(nrx, nry) || !isValid(nbx, nby)){
                continue;
            }
            // 도착지점 확인
            if (arr[nrx][nry] == 3) rflag = true;
            if (arr[nbx][nby] == 4) bflag = true;
            // 수레의 움직임이 가능한지 판단
            if (possible(rx, ry, nrx, nry, bx, by, nbx, nby) &&
                !flag[0][nrx][nry] && !flag[1][nbx][nby]) {
                // 방문 처리
                flag[0][nrx][nry] = true;
                flag[1][nbx][nby] = true;
                solve(nrx, nry, nbx, nby, cnt + 1, flag);
                // 다시 원위치
                flag[0][nrx][nry] = false;
                flag[1][nbx][nby] = false;
            }
            // 도착지점 초기화
            if (arr[nrx][nry] == 3) rflag = false;
            if (arr[nbx][nby] == 4) bflag = false;
        }
    }
    static boolean possible(int rx,int ry, int nrx, int nry, int bx, int by, int nbx, int nby){
        // 1. 범위 확인
        // 2. 둘이 같은 위치인지
        // 3. 둘이 스위칭 했는지 확인
        if (!isValid(nrx, nry) || !isValid(nbx, nby)){
            return false;       
        } 
        
        if(nrx == nby && nry == nby){
            return false;
        }
        
        if(rx == nbx && ry == nby && nrx == bx && nry == by){
            return false;
        }
        return true;
        
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
}
