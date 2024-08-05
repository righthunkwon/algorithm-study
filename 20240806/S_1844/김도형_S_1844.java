import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 세로 길이
        int m = maps[0].length; // 가로 길이
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        boolean [][]visit = new boolean[n][m];
        int answer = Integer.MAX_VALUE; // 초기값을 큰 값으로 설정
        
        //bfs
        Queue<Integer>qx = new LinkedList<>();
		Queue<Integer>qy = new LinkedList<>();
		Queue<Integer>qd = new LinkedList<>();	
            qx.add(0);
			qy.add(0);
            qd.add(1);
			visit[0][0]=true;
		
		while(!qx.isEmpty()||!qy.isEmpty()) {
			int nx = qx.poll();
			int ny = qy.poll();
            int nd = qd.poll();
			for(int i=0;i<4;i++) {
				int newx = nx+dx[i];
				int newy = ny+dy[i];
                int newd = nd+1;
				if(newx<0||newy<0||newx>=n||newy>=m)continue;
				if(visit[newx][newy])continue;
                if(newx==n-1&&newy==m-1){ //도착 했으면
                    return newd; //거리 반환하고 끝내기
                }
				if(maps[newx][newy]==1) {
				visit[newx][newy]=true;
				qx.add(newx);
				qy.add(newy);
                qd.add(newd);
				}
			}
		}
        
        if (answer == Integer.MAX_VALUE) {
            return -1; // 도착 못하면 -1
        }
        return answer;
    }

}
