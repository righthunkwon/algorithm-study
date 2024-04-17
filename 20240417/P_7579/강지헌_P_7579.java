import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] m = new int[N], c = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) m[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) c[i] = Integer.parseInt(st.nextToken());
		int[][] dy = new int[N][10001];
		int ans = Integer.MAX_VALUE;
		for (int j = c[0]; j <= 10000; j++) dy[0][j] = m[0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 10000; j++) {
				if (j >= c[i]) dy[i][j] = Math.max(dy[i - 1][j], dy[i - 1][j - c[i]] + m[i]);
				else dy[i][j] = dy[i - 1][j];
				if (dy[i][j] >= M) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
	}
}
