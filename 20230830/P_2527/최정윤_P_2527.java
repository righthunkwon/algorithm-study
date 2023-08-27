import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] rect1 = new int[4];
			int[] rect2 = new int[4];
			for (int i = 0; i < 4; i++) {
				rect1[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				rect2[i] = Integer.parseInt(st.nextToken());
			} // 입력끝

			if (rect1[2] < rect2[0] || rect2[2] < rect1[0] || rect1[3] < rect2[1] || rect2[3] < rect1[1]) {
				System.out.println("d");// 아무것도 안만남
			} else if ((rect1[0] == rect2[2] && rect1[1] == rect2[3]) || (rect1[0] == rect2[2] && rect1[3] == rect2[1])
					|| (rect1[2] == rect2[0] && rect1[3] == rect2[1])
					|| (rect1[2] == rect2[0] && rect1[1] == rect2[3])) {
				System.out.println("c");
			} else if (rect1[0] == rect2[2] || rect2[0] == rect1[2] || rect1[1] == rect2[3] || rect2[1] == rect1[3]) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}

		}

	}
}
