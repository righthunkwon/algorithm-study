
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
// 외부 공기와 내부 공기를 구별
public class P_2638 {

	private static int n, m, ans, cnt;
	private static int[][] map;
	
	// 상하좌우
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		ans = 0; // 걸린 시간
		map = new int[n][m]; // 치즈 배열
		
		// 배열 요소 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이 로직 시작
		while (true) {
			
			// 외부 공기 판단
			Queue<Integer[]> q1 = new LinkedList<>(); // 좌표를 넣을 큐 생성
			q1.add(new Integer[] { 0, 0 }); // 시작값 추가
			map[0][0] = -1; // 외부 공기를 내부 공기와 구별하기 위해 시작값 외부 공기를 0에서 -1로 변경
			
			// 외부 공기 세팅
			while (!q1.isEmpty()) {
				Integer[] tmp = q1.poll();
				int x = tmp[0];
				int y = tmp[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
						map[nx][ny] = -1;
						q1.add(new Integer[] { nx, ny });
					}
				}
			}
			
			// 녹을 치즈 판단
			Queue<Integer[]> q2 = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					cnt = 0; // 외부 공기의 수
					if (map[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							
							// 범위 내에 들어와있고, 외부 공기일 경우
							if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == -1) {
								cnt++; // 외부 공기 수 증가
							}
						}
						
						// 외부 공기의 수가 2개 이상이면 치즈는 녹으므로 녹을 치즈를 큐에 담음
						if (cnt >= 2) {
							q2.add(new Integer[] { i, j });
						}
					}
				}
			}
			
			// 치즈가 전부 녹아 녹을 치즈를 담는 큐가 비었을 경우 정답 출력 후 종료
			if (q2.isEmpty()) {
				System.out.println(ans);
				System.exit(0);
			}

			// 치즈가 아직 남아있을 경우(종료되지 않았으니) 걸린 시간을 증가
			ans++;
			
			// 녹을 치즈를 녹이고(0으로 만듦)
			// 외부 공기를 다시 새로 판단해주기 위해 외부 공기였던 걸 다시 초기화(0으로 만듦) 
			while (!q2.isEmpty()) {
				Integer[] tmp = q2.poll();
				map[tmp[0]][tmp[1]] = 0;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
					}
				}
			}
		}
	}
}
