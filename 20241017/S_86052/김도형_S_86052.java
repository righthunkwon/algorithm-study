import java.io.*;
import java.util.*;

class Solution {
    static int R,C;
    static boolean visit[][][];
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 }; // 아래, 왼쪽, 위, 오른쪽
    public int[] solution(String[] grid) {
        List<Integer> ans = new ArrayList<>();
        
        R = grid.length;
        C = grid[0].length();

        visit = new boolean[R][C][4];
        
        //모든 칸에서 4방향으로 빛 쏴보고 새로운 사이클이면 길이 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visit[i][j][d])
                        ans.add(path(grid, i, j, d ));
                }
            }
        }
        
        Collections.sort(ans);//오름차순 정렬
        
        int[]answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)answer[i]=ans.get(i);
        
        return answer;
    }
    
    private static int path(String[] grid, int r, int c, int d) {
        int cnt = 0; // 이동거리

        while (true) {
            if(visit[r][c][d])break;
            visit[r][c][d] = true; // 방문처리
            cnt++;	// 거리증가

            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1; // 좌회전
            else if (grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d + 1; // 우회전
            
            //격자 넘어가는 부분 처리
            r = (r + dr[d] + R) % R; 
            c = (c + dc[d] + C) % C;
        }

        return cnt;
    }

    
}
