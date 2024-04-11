import java.io.*;

public class Main {
	static char[][] print;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		print = new char[N][N];
		for (int i = 0; i < N; i++) {
			print[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, N);
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int N) {
		char check = check(r, c, N);
		if (check != 'X') {
			sb.append(check);
			return;
		}
		sb.append("(");
		dfs(r, c, N / 2);
		dfs(r, c + N / 2, N / 2);
		dfs(r + N / 2, c, N / 2);
		dfs(r + N / 2, c + N / 2, N / 2);
		sb.append(")");

	}

	private static char check(int r, int c, int N) {
		char a = print[r][c];
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (print[i][j] != a)
					return 'X';
			}
		}
		return a;
	}
}
