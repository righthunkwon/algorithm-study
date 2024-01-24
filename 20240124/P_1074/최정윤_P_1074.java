
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
	//1. 구간 찾기
	//2. 그 앞까지의 갯수 더하기
	//3. 기준 r,c 세팅
	//4. 블록 크기 줄여서 다시!
	private static void find(int r, int c, int N) {
		int size = (int) Math.pow(2, N - 1);
		if (r < size && c < size) { // 왼위
			if (N == 1)
				return;
			find(r, c, N - 1);
		} else if (r < size && c >= size) { // 오른위
			result += Math.pow(size, 2);
			if (N == 1)
				return;
			find(r, c - size, N - 1);
		} else if (r >= size && c < size) { // 왼아래
			result += Math.pow(size, 2) * 2;
			if (N == 1)
				return;
			find(r - size, c, N - 1);
		} else { // 오른아래
			result += Math.pow(size, 2) * 3;
			if (N == 1)
				return;
			find(r - size, c - size, N - 1);

		}
	}
}
