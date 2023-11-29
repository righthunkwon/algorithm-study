package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Pro_1756_피자굽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] size = new int[D + 1];
		for (int i = 1; i < D + 1; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		int last_lo = 0;
		a: for (int i = 0; i < N; i++) {
			int pizza = Integer.parseInt(st.nextToken());
			if (pizza > size[1]) {
				System.out.println(0);
				System.exit(0);
			}
			for (int j = 2; j < D + 1; j++) {
				if (pizza > size[j]) {
					size[j - 1] = -1;// 여기에 들어갔다고 하기
					last_lo = j - 1;
					continue a; // 다음 피자 넣기
				}
				if (j == D && pizza <= size[D]) {
					size[D] = -1;
					last_lo = D;
				}
			}
		}
		System.out.println(last_lo);
	}
}
