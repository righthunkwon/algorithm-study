// ㅠ-ㅠ
package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2638_치즈 {
	static int N, M;
	static int[][] cheese;
	static int time = 0;
	static int[] dr = {-1,1,0,0,};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 모눈종이 세로
		M = Integer.parseInt(st.nextToken()); // 모눈종이 가로

		//치즈 배열 입력
		cheese = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (!isMelted()) { // false일 경우 치즈가 다 녹았단 의미, 루프 종료
				break;
			}
			time++; // true일 때 치즈가 다 녹지 않았으므로 시간 증가
		}
		System.out.println(time);
	}
	
	
	 // 치즈를 녹이는 함수
	static boolean isMelted() {
		boolean[][] visited = new boolean[N][M]; // 위치 방문 체크
		boolean[][] toMelt = new boolean[N][M]; // 녹을 치즈를 표시
		boolean isCheese = false; // 현재 치즈가 남았는지 여부

		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (cheese[i][j] == 1) {
					isCheese = true; // 치즈가 남아있다

					int airCount = 0; // 공기 카운트
					
					for (int k=0;k<4;k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						// 배열 범위 내에 있는 주변 공기를 카운트한다
						if (nr>=0 && nr<N && nc>=0 && nc<M && cheese[nr][nc]==0 && !visited[nr][nc]) {
							airCount++;
						}
					}
					// 공기를 카운트 해서 2 이상이면 녹을 치즈이므로 toMelt 값을 true로 바꿔준다
					if (airCount >= 2) {
						toMelt[i][j] = true;
					}
				}
			}
		}
		
		// 치즈가 남아있지 않으면, 다 녹았단 의미이므로 false값을 내보낸다
		if (!isCheese) return false;
		
		// 녹을 치즈 표시된걸 치즈 배열에서 0으로 바꿔준다(녹아서 없어짐)
		// 지금 바꿔줘도 어차피 isCheese가 true여서 전체 함수는 true값 내보내짐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (toMelt[i][j]) cheese[i][j] = 0;
			}
		}

		return true;
	}
}
