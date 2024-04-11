
import java.io.*;
import java.util.*;

public class Pro_2473_세용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long[] three = new long[3];

		long min =Long.MAX_VALUE;
		// 일단 한개 고정
		for (int i = 0; i < N; i++) {
			int s = i + 1;
			int e = N - 1;
			while (s < e) {
				if (arr[s] + arr[e] + arr[i] > 0) {
					if (min > arr[s] + arr[e] + arr[i]) { //최솟값이라면 저장해놓기
						three[0] = arr[i];
						three[1] = arr[s];
						three[2] = arr[e];
						min = arr[s] + arr[e] + arr[i];
					}
					e--;
				} else if (arr[s] + arr[e] + arr[i] < 0) {
					if (min > -(arr[s] + arr[e] + arr[i])) {
						three[0] = arr[i];
						three[1] = arr[s];
						three[2] = arr[e];
						min = -(arr[s] + arr[e] + arr[i]);

					}
					s++;
				} else {
					System.out.println(arr[i] + " " + arr[s] + " " + arr[e]);
					System.exit(0);
				}
			}

		}
		System.out.println(three[0] + " " + three[1] + " " + three[2]);
	}
}
