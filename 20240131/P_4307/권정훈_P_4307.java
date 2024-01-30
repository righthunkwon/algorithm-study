package level_00_basic;

import java.io.*;
import java.util.*;

// 개미
public class P_4307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken()); // 막대 길이
			int n = Integer.parseInt(st.nextToken()); // 개미 수
			int[] arr = new int[n]; // 개미 배열

			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int ant = Integer.parseInt(st.nextToken());

				int mintmp = Math.min(ant, len - ant);
				int maxtmp = Math.max(ant, len - ant);

				min = Math.max(min, mintmp);
				max = Math.max(max, maxtmp);
			}
			System.out.println(min + " " + max);
		}
	}
}
