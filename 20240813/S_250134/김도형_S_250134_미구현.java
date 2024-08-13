import java.io.*;
import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0}; 
    int[] dc = {0, 1, 0, -1}; 
    int n, m;
    int[] stR, edR, stB, edB;
    int answer;
    boolean[][] visitR, visitB;  // 빨강 방문 배열, 파랑 방문 배열
    
    public int solution(int[][] maze) {
        n = maze.length;  // 세로 길이
        m = maze[0].length;  // 가로 길이
        stR = new int[2];
        edR = new int[2];
        stB = new int[2];
        edB = new int[2];
        
        // 출발지와 도착지 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    stR[0] = i;
                    stR[1] = j;
                } else if (maze[i][j] == 2) {
                    stB[0] = i;
                    stB[1] = j;
                } else if (maze[i][j] == 3) {
                    edR[0] = i;
                    edR[1] = j;
                } else if (maze[i][j] == 4) {
                    edB[0] = i;
                    edB[1] = j;
                }
            }
        }

        answer = Integer.MAX_VALUE;  // 정답을 큰 값으로 초기화
        
        visitR = new boolean[n][m];
        visitB = new boolean[n][m];
        visitR[stR[0]][stR[1]]=true;
        visitB[stB[0]][stB[1]]=true;
        
        dfs(0, stR, stB, maze);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    // depth: 움직인 횟수, nowR: 현재 빨강 위치, nowB: 현재 파랑 위치
    public void dfs(int depth, int[] nowR, int[] nowB, int[][] maze) {
        
        // 백트래킹(현재 답보다 더 많이 움직여야 하면)
        if (depth >= answer) return;
        
        // 둘다 도착한 경우
        if (nowR[0] == edR[0] && nowR[1] == edR[1] && nowB[0] == edB[0] && nowB[1] == edB[1]) {
            answer = Math.min(answer, depth);
            return;
        }
        
        // 빨강만 도착한 경우
        if (nowR[0] == edR[0] && nowR[1] == edR[1]) {
            for (int i = 0; i < 4; i++) {
            int newBr = nowB[0] + dr[i];
            int newBc = nowB[1] + dc[i];
            
            if (newBr < 0 || newBr >= n || newBc < 0 || newBc >= m) continue;  // 경계 체크
            if (maze[newBr][newBc] == 5) continue;  // 벽 체크
            if (visitB[newBr][newBc]) continue;  // 방문 체크
            
            if (newBr == nowR[0] && newBc == nowR[1]) continue;  // 파랑이 빨강과 같은 위치로 이동 방지
            
            visitB[newBr][newBc] = true;
            dfs(depth + 1, nowR, new int[]{newBr, newBc}, maze);  // 파랑 이동 후 DFS 진행
            visitB[newBr][newBc] = false;
            }
            
        }
        
        // 파랑만 도착한 경우
        if (nowB[0] == edB[0] && nowB[1] == edB[1]) {
            for (int i = 0; i < 4; i++) {
            int newRr = nowR[0] + dr[i];
            int newRc = nowR[1] + dc[i];
            
            if (newRr < 0 || newRr >= n || newRc < 0 || newRc >= m) continue;  // 경계 체크
            if (maze[newRr][newRc] == 5) continue;  // 벽 체크
            if (visitR[newRr][newRc]) continue;  // 방문 체크
            
            visitR[newRr][newRc] = true;
            dfs(depth + 1, new int[]{newRr, newRc}, nowB, maze);  // 빨강 이동 후 파랑을 움직임
            visitR[newRr][newRc] = false;
            }
        }
        
        // 둘 다 도착 못한 경우

        //ㅈㅈ ...
        
    }
    
}
