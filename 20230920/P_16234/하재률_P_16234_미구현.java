package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N, L, R, sum, cnt;
	static int[][] map;
	static boolean[][] chk;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완료
		
		
		chk = new boolean[N][N];
		sum = 0;
		cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				q = new LinkedList<int[]>();
				if(!chk[i][j]) {
					q.add(new int[] {i, j, map[i][j], cnt});
					
					while(!q.isEmpty()) {
						System.out.println("asdfadfs"+Arrays.toString(q.peek()));
						bfs(q.poll());
					}
					
				}
			}
		}
		System.out.println(sum);
		System.out.println(cnt);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(chk[i][j])
					map[i][j] = sum/cnt;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	static void bfs(int[] arr) {
		chk[arr[0]][arr[1]] = true;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int d = 0; d < 4; d++) {
			int a = arr[0] + dx[d];
			int b = arr[1] + dy[d];
			if(a >= 0 && a < N && b >= 0 && b < N) {
				int c = Math.abs(map[arr[0]][arr[1]] - map[a][b]);
				System.out.println(c);
				if(c <= R && c >= L  && !chk[a][b]) {
					q.add(new int[] {a, b, arr[2]+map[a][b], cnt++});
					System.out.println("여기"+Arrays.toString(q.peek()));
				}
			}
		}
		sum = sum < arr[2] ? arr[2] : sum;
	}
}
