import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 10000;
        
        int[][] map = new int[101][101];
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dy = {0, 1, 0, -1};
        
        for (int[] rect : rectangle) {
            //거리가 1인 떨어져있는 변으로 이동하지 않게 하기위해
            //2를 곱해서 거리 벌어지도록함
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            // 테두리 설정
            for (int i = x1; i <= x2; i++) {
                map[y1][i]++; 
                map[y2][i]++; 
            }
            for (int i = y1; i <= y2; i++) {
                map[i][x1]++; 
                map[i][x2]++; 
            }
            
            // 직사각형 내부는 큰 수 빼서 구분
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[j][i] -= 1000; 
                }
            }
        }

        // //맵 출력 test
        // for (int i = 0; i < 101; i++) {
        //     for (int j = 0; j < 101; j++) {
        //         if (map[i][j] >= 0) {
        //             System.out.print(map[i][j] + " ");
        //         } else {
        //             System.out.print("X ");
        //         }
        //     }
        //     System.out.println();
        // }

        //BFS로 최단거리 구하기
        boolean[][] visit = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{characterY*2, characterX*2, 0});
        visit[characterY*2][characterX*2] = true;
         
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            int depth = now[2];
            
            // 아이템 주웠으면 끝
            if (nowX == itemX*2 && nowY == itemY*2) {
                answer = Math.min(depth/2,answer);
                break;
            }
            
            for(int d=0;d<4;d++){
                int newY = nowY+dy[d];
                int newX = nowX+dx[d];
                
                if(newY<0 || newY>100 ||newX<0 ||newX>100||visit[newY][newX])continue;
                if(map[newY][newX]<=0)continue;
                q.add(new int[]{newY,newX,depth+1});
                visit[newY][newX]=true;
            }
            

        }//while
        
        return answer;
    }
}
