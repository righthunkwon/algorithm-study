import java.io.*;
import java.util.StringTokenizer;

public class Pro_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] sum = new int[N];// 누적합
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		int max = 0;
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
			if (sum[i] >= S)
				max = i;
		}
		if (max == 0)
			System.out.println(0);
		int min = 1;
		while (true) {
			for (int i = N - 1; i >= min; i--) {
				if (sum[i] - sum[i - min] >= S) {
					System.out.println(min);
					System.exit(0);
				}
			}
			min++;
		}
	}
}
