import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] r1 = new int[4];
			int[] r2 = new int[4];
			for (int i = 0; i < 4; i++) {
				r1[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				r2[i] = Integer.parseInt(st.nextToken());
			} // 입력끝

			if (r1[2] < r2[0] || r2[2] < r1[0] || r1[3] < r2[1] || r2[3] < r1[1]) {
				System.out.println("d");// 아무것도 안만남
			} else if ((r1[0] == rect2[2] && r1[1] == rect2[3]) || (r1[0] == r2[2] && r1[3] == r2[1])
					|| (r1[2] == r2[0] && r1[3] == r2[1])
					|| (r1[2] == r2[0] && r1[1] == r2[3])) {
				System.out.println("c");
			} else if (r1[0] == r2[2] || r2[0] == r1[2] || r1[1] == r2[3] || r2[1] == r1[3]) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}

		}

	}
}
