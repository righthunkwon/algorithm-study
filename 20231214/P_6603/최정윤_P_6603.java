import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			lotto = new int[k];
			select = new int[6];
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			select(0, 0);
			sb.append("\n");
		}
		// 입력 끝
		System.out.println(sb.toString());

	}

	static int[] lotto;
	static int[] select;
	static StringBuilder sb;
	static int k;

	public static void select(int idx, int sidx) {
		if (sidx == 6) {
			print();
			return;
		}
		if (idx == k)
			return;
		select[sidx] = lotto[idx];
		select(idx + 1, sidx + 1);
		select(idx + 1, sidx);
	}

	public static void print() {
		for (Integer su : select) {
			sb.append(su + " ");
		}
		sb.append("\n");
	}
}
