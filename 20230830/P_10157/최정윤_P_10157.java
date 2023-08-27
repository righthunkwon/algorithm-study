
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[R][C];
		if (K > C * R) {
			System.out.println(0);
		} else {
			// 상우하좌
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int nr = R - 1, nc = 0;
			int dir = 0;
			while (K > 1) {
				arr[nr][nc]=1;
				int imsiNr = nr + dr[dir];
				int imsiNc = nc + dc[dir];
				if (imsiNc < 0 || imsiNc >= C || imsiNr < 0 || imsiNr >= R || arr[imsiNr][imsiNc] != 0) {
					dir = (dir + 1) % 4;
				}
				nr += dr[dir];
				nc += dc[dir];
				K--;
			}
			System.out.println((nc+1) + " " + (R-nr));
		}

	}
}
