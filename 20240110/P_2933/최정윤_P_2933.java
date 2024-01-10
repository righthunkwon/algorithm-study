import java.io.*;
import java.util.*;

//왼 오 왼 오 순으로 x를 .으로 바꿈
//맨 밑 층에 x 모두큐에 담고 bfs로 연결된 x 다 visited처리
//이제 밑으로 내리려고 visited안된거 찾아서 그걸 중심으로 다시 연결된거 큐에 담고 visited2에 체크
//vistied2체크된거 내리는거 제일 min값 찾고 그 묶음 다 내리기
public class Pro_2933_미네랄 {
	static int R, C;
	static char[][] cave;
	static int[] dr, dc;
	static boolean[][] visited, visited2;
	static Queue<int[]> q;
	static List<int[]> changeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		cave = new char[R][C];

		for (int i = 0; i < R; i++) {
			cave[i] = br.readLine().toCharArray();
		}
		q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			// i가짝수면 왼->오 아니면 오->왼
			if (i % 2 == 0) {
				for (int j = 0; j < C; j++) { //왼쪽부터
					if (cave[R - h][j] == 'x') {
						cave[R - h][j] = '.';
						break;
					}
				}
			} else {
				for (int j = C - 1; j >= 0; j--) { //오른쪽부터
					if (cave[R - h][j] == 'x') {
						cave[R - h][j] = '.';
						break;
					}
				}
			}
			bfs(); //x와 연결된 것 찾아보고 
			goDown(); //연결안된 것 내리자 
		}
		for (int l = 0; l < R; l++) {
			for (int j = 0; j < C; j++) {
				System.out.print(cave[l][j]);
			}
			System.out.println();
		}
	}

	private static void goDown() {
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && cave[i][j] == 'x') { //연결되지 않았고, 공중에 떠있는 x 다 하면!!!!  
					q.add(new int[] { i, j });
					changeList = new ArrayList<int[]>(); //내릴 x들 담는 배열 (매번 visited2를 다 돌 수 없으니까)
					changeList.add(new int[] { i, j });
					visited2 = new boolean[R][C];
					visited2[i][j] = true;
					bfsDown(); //그거랑 연결된 내릴 x들 담는 메소드
					
					int change = 123456789;//몇 칸 내릴건지
					for (int[] arr : changeList) { //통째로 떨어지기 때문에 내려가는 최소값 구해서 떨어져야한다 중간에 걸릴 수도 있으므로
						boolean tf = false;
						for (int k = arr[0] + 2; k < R; k++) {
							if (cave[k][arr[1]] == 'x' && visited[k][arr[1]]) { //땅과 연결된 x가 있다면 !! 최솟값 갱신
								change = Math.min(change, k - 1 - arr[0]);
								tf = true;
							}
						}
						if (!tf)//없다면 아예 바닥까지 내려가야하니까 몇칸인지 
							change = Math.min(change, R - 1 - arr[0]);
					}
					for (int[] arr : changeList) { //change 칸만큼 내리는 작업
						if (!visited[arr[0]][arr[1]])
							cave[arr[0]][arr[1]] = '.'; 
						cave[arr[0] + change][arr[1]] = 'x';
						visited[arr[0] + change][arr[1]] = true;
					}
				}
			}
		}

	}

	private static void bfsDown() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited2[nr][nc] || cave[nr][nc] == '.')
					continue;
				visited2[nr][nc] = true;
				changeList.add(new int[] { nr, nc });
				q.add(new int[] { nr, nc });
			}
		}
	}

	private static void bfs() {
		visited = new boolean[R][C];
		for (int i = 0; i < C; i++) {
			if (cave[R - 1][i] == 'x') { //바닥에 붙어있는 x 다 담아 
				visited[R - 1][i] = true;
				q.add(new int[] { R - 1, i });
			}
		}
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || cave[nr][nc] == '.')
					continue; 
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}

	}
}
