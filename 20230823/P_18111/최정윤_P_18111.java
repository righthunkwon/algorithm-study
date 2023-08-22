
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());// 가로
		int M = Integer.parseInt(st.nextToken());// 세로
		int B = Integer.parseInt(st.nextToken());// 인벤토리 저장 블록수
		int[][] high = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				high[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		int min_t = 128000000;
		int result = -1;
		// 500*500*2*256 하여 가능한 범위 내의 최댓값으로 설정했습니다.
		for (int mid = 256; mid >= 0; mid--) {
			int t = 0;// 시간 계산을 위한 변수
			int B_imsi = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int h = high[i][j];// 값 바뀌면 X저장해놓고 쓰기
					while (h > mid) {
						t += 2;// 2초
						B_imsi += 1;
						h -= 1;
					}
					while (h < mid) {
						t += 1;// 1초
						B_imsi -= 1;
						h += 1;
					}
				}
			}
			if (B_imsi < 0) {
				t = 128000000;
			}

			if (t < min_t) {
				min_t = t;
				result = mid;
			}
		}
		System.out.println(min_t + " " + result);
	}
}
