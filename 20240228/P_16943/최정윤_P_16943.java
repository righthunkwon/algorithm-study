import java.io.*;
import java.util.*;
public class Pro_16943_숫자재배치2 {
	static int[] select, A_arr;
	static String A;
	static int B;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		A = sc.next();
		B = sc.nextInt();

		A_arr = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {
			A_arr[i] = A.charAt(i) - '0';
		}
		Arrays.sort(A_arr);
		if (A.length() > String.valueOf(B).length())
			System.out.println(-1);
		else {
		select = new int[A.length()];
		visited = new boolean[A.length()];
		dfs(0);
		System.out.println(-1);}

	}

	private static void dfs(int sidx) {
		if (sidx == A.length()) {
			int A2 = 0;
			for (int i = 0; i < A.length(); i++) {
				A2 += (select[i] * Math.pow(10, A.length() - i - 1));
			}
			if (B > A2) {
				System.out.println(A2);
				System.exit(0);
			}
			return;
		}
		for (int i = A.length() - 1; i >= 0; i--) {
			if (visited[i]||(sidx==0&&A_arr[i]==0)) continue;
			visited[i]=true;
			select[sidx]=A_arr[i];
			dfs(sidx+1);
			visited[i]=false;
		}

	}

}
