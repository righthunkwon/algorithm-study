package baek;

import java.io.*;
import java.util.*;

public class Pro_17070_파이프옮기기1 {
	static int[][] dr, dc, map;
	static int cnt, N;
	static Queue<Pipe> q;

	static class Pipe {
		int r, c, dir;
		public Pipe(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;// 가로=0,대각선=1,세로=2
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new LinkedList<Pipe>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		if (map[N - 1][N - 1] == 1)//마지막칸이 1이면 그냥 0리턴
			System.out.println(0);
		else {
			dr = new int[][] { { 0 }, { 0, 1, 1 }, { 1 } };//가로 대각선 세로 순서
			dc = new int[][] { { 1 }, { 1, 0, 1 }, { 0 } };
			q.add(new Pipe(0, 1, 0));//시작점은 두번째 칸이므로
			bfs();
			System.out.println(cnt);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Pipe curr = q.poll();
			if (curr.r == N - 1 && curr.c == N - 1) {cnt++;continue;}//마지막칸에 왔다면 cnt++
			int dir = curr.dir;
			// 가로면 가로,대각선
			// 세로면 세로,대각선
			// 대각선이면 가로,세로,대각선
			int st, ed;
			if (dir == 0) {	st = 0;ed = 1;} 
			else if (dir == 1) {st = 0;ed = 2;} 
			else {st = 1;	ed = 2;}
			for (int i = st; i <= ed; i++) {//ex 대각선이면  가로 세로 대각선 다 확인
				boolean go = true;
				int nr = 0, nc = 0;
				for (int j = 0; j < dr[i].length; j++) {  //ex 대각선이면 3칸다 비었는지 확인해야한다 
					nr = curr.r + dr[i][j];
					nc = curr.c + dc[i][j];
					if (nr >= N || nc >= N || map[nr][nc] == 1) {
						go = false;//이 방향은 X 아예 break 하고 다른 방향 탐색
						break;
					}
				}
				if (go)
					q.add(new Pipe(nr, nc, i));//마지막 좌표를 넣는다 그곳에서 시작해야하므로
			}
		}
	}
}
