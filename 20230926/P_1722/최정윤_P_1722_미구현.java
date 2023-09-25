import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		select = new int[N];
		visited = new boolean[N + 1];
		count = 0;
		if (Integer.parseInt(st.nextToken()) == 1) {
			k = Integer.parseInt(st.nextToken());
			first(0);
		} else {
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			two(0);
		}
	}

	static int k;
	static int N;
	static int[] select;
	static int[] arr;
	static int count;
	static boolean[] visited;

	public static void first(int sidx) {
		if (sidx == N) {
			count++;
			if (count == k) {
				for (int i = 0; i < N; i++) {
					System.out.print(select[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				select[sidx] = i;
				visited[i] = true;
				first(sidx + 1);
				visited[i] = false;
			}
		}
	}

	public static void two(int sidx) {

		if (sidx == N) {
			count++;
			boolean check = true;
			for (int i = 0; i < N; i++) {
				if (select[i] != arr[i]) {
					check = false;
					break;
				}
			}
			if (check)
				System.out.println(count);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				select[sidx] = i;
				visited[i] = true;
				two(sidx + 1);
				visited[i] = false;
			}
		}
	}
}
