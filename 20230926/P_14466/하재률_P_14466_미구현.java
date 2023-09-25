package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을건너간이유6_미구현 {
	static int N, K, R, num;
	static int[][] map;
	static boolean[][] chk;
	static List<int[]> bridge1, bridge2;
	static int[] cx, cy, cnt;
	static int[] dx = {-1, 1, 0 , 0};
	static int[] dy = {0, 0 , -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 목초지 크기 2 ~ 100
		K = Integer.parseInt(st.nextToken()); // K마리의 소 1 ~ 100 ( < N^2 )
		R = Integer.parseInt(st.nextToken()); // 길의 수
		
		map = new int[N][N];
		chk = new boolean[N][N];
		
		bridge1 = new ArrayList<>();
		bridge2 = new ArrayList<>();
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			bridge1.add(new int[]{x1, y1});
			bridge2.add(new int[]{x2, y2});
		}// 길 입력 완
		
		cx = new int[K];
		cy = new int[K];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cx[i] = Integer.parseInt(st.nextToken());
			cy[i] = Integer.parseInt(st.nextToken());
		}// 소의 위치 입력 완
		
		cnt = new int[100];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!chk[i][j]) {
					bfs(i, j);
					num++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int x ,int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		chk[x][y] = true;
		map[x][y] = num;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			x = tmp[0];
			y = tmp[1];
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !chk[nx][ny]) {
					for(int i = 0; i < R; i++) {
						if(bridge1.get(i)[0] == x && bridge1.get(i)[1] == y && bridge2.get(i)[0] == nx && bridge2.get(i)[1] == ny) {
							break;
						}
					}
					chk[nx][ny] = true;
					map[nx][ny] = num;
					q.add(new int[] {nx, ny});
					
				}
			}
		}
		
	}
}
