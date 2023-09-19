import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] cm = new int[M][3];
		char[][] train = new char[N + 1][21];// char의 초기값 0=>아스키코드로 0
//		Arrays.fill(train, '0');
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cm[i][0] = Integer.parseInt(st.nextToken());
			cm[i][1] = Integer.parseInt(st.nextToken());
			if (cm[i][0] == 1 || cm[i][0] == 2) {
				cm[i][2] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		for (int i = 0; i < M; i++) {
			switch (cm[i][0]) {
			case 1:
				train[cm[i][1]][cm[i][2]] = '1';
				break;
			case 2:
				train[cm[i][1]][cm[i][2]] = '0';
				break;
			case 3:
				String a = "0";
				for (int j = 1; j < 21; j++) {
					if (train[cm[i][1]][j] == 0 || train[cm[i][1]][j] == '0') {
						a += "0";
					} else {
						a += train[cm[i][1]][j];
					}
				}
				int b = Integer.parseInt(a, 2);
				int c = (b >> 1);
				String su = Integer.toBinaryString(c);
				if (su.length() < 21) {
					int count = 21 - su.length();
					while (count > 0) {
						su = "0" + su;
						count--;
					}
				}
				train[cm[i][1]] = su.toCharArray();
				break;
			case 4:
				String d = "0";
				for (int j = 1; j < 21; j++) {
					if (train[cm[i][1]][j] == 0 || train[cm[i][1]][j] == '0') {
						d += "0";
					} else {
						d += train[cm[i][1]][j];
					}
				}
				int e = Integer.parseInt(d, 2);
				int f = (e << 1);
				String su2 = Integer.toBinaryString(f);
				if (su2.length() < 21) {
					int count = 21 - su2.length();
					while (count > 0) {
						su2 = "0" + su2;
						count--;
					}
				}
				train[cm[i][1]] = su2.toCharArray();
				break;

			default:
				break;
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < N + 1; i++) {
			String a = "0";
			for (int j = 1; j < 21; j++) {
				if (train[i][j] == 0 || train[i][j] == '0') {
					a += "0";
				} else {
					a += train[i][j];
				}
			}
			int b = Integer.parseInt(a, 2);
			set.add(b);
		}
		System.out.println(set.size());
	}
}
