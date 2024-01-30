
import java.io.*;
import java.util.*;

// 나머지합
// 시간초과
public class P_10986 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 나눌 수

		st = new StringTokenizer(br.readLine(), " ");
		int[] sarr = new int[N + 1]; // 누적합
		for (int i = 1; i < N + 1; i++) {
			sarr[i] = sarr[i - 1] + Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = i; j < N + 1; j++) {
				if ((sarr[j] - sarr[i - 1]) % M == 0) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
