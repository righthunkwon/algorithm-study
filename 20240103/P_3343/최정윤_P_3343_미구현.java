package baek;

import java.io.*;
import java.util.*;

public class Pro_3343_장미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();

		System.out.println(dfs(N));

	}

	static int A, B, C, D;

	private static long dfs(long now) {
		if (now <= 0)
			return 0;
		if (now <= A && now <= C) {
			return Math.min(B, D);
		} else if (now <= A) {
			return Math.min(B, (now / C) * D + dfs(now % C));
		} else if (now <= C) {
			return Math.min(D, (now / A) * B + dfs(now % A));
		} else {// N이 A,C보다 클 경우
			if ((double) B / A > (double) D / C) {
				return (now / C) * D + dfs(now % C);
			} else if ((double) B / A < (double) D / C) {
				return (now / A) * B + dfs(now % A);
			} else {
				return Math.min((now / C) * D + dfs(now % C), (now / A) * B + dfs(now % A));
			}
		}
	}
}
