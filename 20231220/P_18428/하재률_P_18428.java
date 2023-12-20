package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
	
	static int N;
	static char[][] map;
	static ArrayList<int[]> ssam;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		ssam = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') ssam.add(new int[] {i, j});
			}
		}// 입력 완
		
		// 3개 선택
		dfs(0);
		System.out.println(flag ? "YES" : "NO");
		
	}
	
	static void dfs(int pick) {
		if(pick == 3) {
			sol(); // 3개 선택되면 학생찾기
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O'; // 벽 세우고
					dfs(pick + 1);
					map[i][j] = 'X'; // 원상복구
				}
			}
		}
	}
	
	static void sol() {
		// 쌤들의 좌표를 하나씩 돌려볼거야
		for(int[] a : ssam) {
			for(int d = 0; d < 4; d++) {
				int nx = a[0] + dx[d];
				int ny = a[1] + dy[d];
				
				while(true) {
					// 범위 벗어나거나 벽 만나면 while문 break하고 다음 델타로
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 'O') break;
					// 학생 만나면 return
					if(map[nx][ny] == 'S') return;
					// 다음칸!
					nx += dx[d];
					ny += dy[d];
				}
			}
		}
		// 이까지 오면 학생 못찾은거야
		flag = true;
		return;
	}
}
