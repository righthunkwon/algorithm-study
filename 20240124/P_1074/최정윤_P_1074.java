
import java.io.*;
import java.util.StringTokenizer;

public class Pro_1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		result = 0;
		find(r, c, N);
		System.out.println(result);
	}

	static int result;

	private static void find(int r, int c, int N) {
		if (r < Math.pow(2, N - 1) && c < Math.pow(2, N - 1)) { //왼위
			if (N == 1) return;
			find(r, c, N -1);
		} else if (r < Math.pow(2, N - 1) && c >= Math.pow(2, N - 1)) { //오른위
			result += Math.pow(Math.pow(2, N - 1), 2);
			if (N == 1) return;
			find(r, c - (int) Math.pow(2, N - 1), N -1);
		} else if (r >= Math.pow(2, N - 1) && c < Math.pow(2, N - 1)) { //왼아래
			result += Math.pow(Math.pow(2, N - 1), 2) * 2;
			if (N == 1) return;
			find(r - (int) Math.pow(2, N - 1), c, N -1);
		} else { //오른아래
			result += Math.pow(Math.pow(2, N - 1), 2) * 3;
			if (N == 1) return;
			find(r - (int) Math.pow(2, N - 1), c - (int) Math.pow(2, N - 1), N -1);

		}
	}
}
