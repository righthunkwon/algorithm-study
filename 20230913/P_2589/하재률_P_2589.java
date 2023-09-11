package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	public static boolean[][] chk; // 방문 했는지? 쳌
	public static int N; // 세로크기
	public static int M; // 가로크기
	public static Queue<int[]> q; // bfs를 위한 queue
	public static int max; // 가장 멀리 떨어진 육지의 최단거리를 구하기 위한 max
	public static char[][] map; // 보물섬 지도 입력받기위한 map
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i] = input.toCharArray();
			}
		}// 입력 완료
		// 전체를 돌면서 최단 거리로 이동하는 데 있어 가장 멀리 떨어진 육지를 찾을거야
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L') { // 육지이면 
					q = new LinkedList<int[]>(); // 큐 초기화
					chk = new boolean[N][M]; // 쳌 배열 초기화
					int depth = 0; // 깊이 초기화
					q.add(new int[] {i,j,depth}); // bfs를 돌릴 좌표와 초기화한 깊이를 큐에 넣고
					chk[i][j] = true; // 이 좌표 방문체크 하고 난 뒤에
					
					while(!q.isEmpty()) { // bfs함수에서 더이상 탐색할게 없으면 size가 0이되며 while탈출
						bfs(q.poll()); // bfs돌리자 (int[] {x좌표, y좌표 ,depth})
					}
				}
			}
		}
		System.out.println(max);
	}

	// bfs 돌릴거에요
	private static void bfs(int[] arr) {
//		System.out.println(Arrays.toString(arr));
		int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 순서
		int[] dy = {0, 0, -1, 1};
		
		for(int d = 0; d < 4; d ++) { // 사방 탐색
			int a = arr[0] + dx[d];
			int b = arr[1] + dy[d];
			
			// 좌표 벗어나지 않고, 방문하지 않았고, 육지('L')를 찾으면 그 좌표로부터 사방향 탐색하며 depth+1 해준다
			if(a >= 0 && a < N && b >= 0 && b < M && !chk[a][b] && map[a][b] == 'L') {
				q.add(new int[] {a, b, arr[2]+1}); // 위 조건 만족하면 q에 삽입하여 bfs를 돌린다
				chk[a][b] = true; // 방문쳌
			}
		}
//		System.out.println("쳌 "+arr[2]);
		max = Math.max(max, arr[2]); // 너비 우선 탐색을 하며 가장 깊이 도달한 depth를 max에 저장한다
	}
}
