package _20240117;

import java.util.*;
import java.io.*;

class Pos {
	int r, c, type;
	public Pos(int r, int c, int type) {
		this.r = r;
		this.c = c;
		this.type = type;
	}
}

public class _24513_좀비바이러스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] answer = new int[N][M];
		int[][][] map = new int[2][N][M];
		// map을 일단 최대수로 다 채운다
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(map[i][j], Integer.MAX_VALUE);
			}
		}
		Queue<Pos> q = new ArrayDeque<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				switch (Integer.parseInt(st.nextToken())) {
				case -1 :
					answer[i][j] = -1;
					break;
				case 1 : //1일 때 바이러스는 0으로 저장
				q.add(new Pos(i, j, 0));
				answer[i][j] = 1;
				map[0][i][j] = 1; // 시간 1로 설정
				break;
				case 2 : //2일 때 바이러스는 1로 저장
					q.add(new Pos(i, j, 1));
					answer[i][j] = 2;
					map[1][i][j] = 1; // 시간 1로 설정
					break;
				}
			}
		}
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			if (answer[cur.r][cur.c] == 3) continue;
			for(int i=0;i<4;i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;

				int type = cur.type; // 현재 위치 바이러스 타입 저장
				if (nr<0||nr>=N||nc<0||nc>=M||answer[nr][nc]==-1||map[type][nr][nc]!=Integer.MAX_VALUE) continue;
				int nd = map[type][cur.r][cur.c]+1;
				// 1- 현재 바이러스 타입 = 다른 바이러스 타입 을 의미함
				// 그래서 두 타입의 거리가 같다면 3번 바이러스가 된다
				if (map[1-type][nr][nc]==nd) {
					answer[nr][nc] = 3;
					continue;
				}
				// 아닌 경우엔 continue;
				if (map[1-type][nr][nc]<nd) continue;
				
				// 답을 저장하는 데에는 type+1을 해서 원래 바이러스 타입으로 저장한다
				answer[nr][nc] = type+1;
				// 그리고 현재 바이러스와 시점의 거리(걸린시간)를 map에 저장한다
				map[type][nr][nc] = nd;
				q.add(new Pos(nr, nc, type));
			}

		}
		// 답을 카운트할 cnt배열을 만든다
		int[] cnt = new int[4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// answer[i][j]가 1 이상이라면(바이러스1,2,3 해당)
				// cnt[각 바이러스 타입]++ 를 해준다
				if (answer[i][j] >= 1)
					cnt[answer[i][j]]++;
			}
		}
		System.out.println(String.format("%d %d %d", cnt[1], cnt[2], cnt[3]));
	}//main

}
