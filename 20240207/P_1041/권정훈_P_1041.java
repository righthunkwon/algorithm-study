
import java.io.*;
import java.util.*;

// 주사위
// 직접 그림 그려보고 규칙 찾기
public class P_1041 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		long[] arr = new long[6];
		long[] num = new long[4];
		long ans = 0;

		num[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2); // 1면
		num[2] = 8 * (N - 2) + 4; // 2면
		num[3] = 4; // 3면

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < 6; i++) {
			arr[i] = Long.parseLong(sarr[i]);
		}

		if (N == 1) {
			Arrays.sort(arr);
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
		} else {
			long min = arr[0];
			for (int i = 1; i < 6; i++) {
				min = Math.min(min, arr[i]);
			}
			ans += num[1] * min;

			min = Long.MAX_VALUE;
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					if (j + i != 5) {
						min = Math.min(min, arr[i] + arr[j]);
					}
				}
			}
			ans += num[2] * min;

			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += Math.min(arr[i], arr[5 - i]);
			}
			ans += num[3] * sum;
			System.out.println(ans);

		}

	}

}
