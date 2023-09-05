package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_16974_레벨햄버거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P_su = new long[N + 1];
		all = new long[N + 1];
		X = Long.parseLong(st.nextToken());
		memoP(N);
		//System.out.println(Arrays.toString(memoP));
		//
		memoX(N);
		System.out.println(P_su(X, N));
	}

	public static long cnt = 0;
	public static long P = 0;
	public static long X;
	public static int N;
	public static long[] P_su;// P수 넣는 배열
	public static long[] all;// 몇개 있는 지 총

	public static long memoP(int N) {
		P_su[0] = 1;
		if (N > 0 && P_su[N] == 0) {
			P_su[N] = 2 * memoP(N - 1) + 1;
		}
		return P_su[N];
	}

	public static long memoX(int N) {
		all[0] = 1;
		if (N > 0 && all[N] == 0) {
			all[N] = 2 * memoX(N - 1) + 3;
		}
		return all[N];
	}

	public static long P_su(long X, int N) {
		if (X == 0) {
			return 0;
		} else if (X == all[N]) {
			return P_su[N];
		} else if (all[N] / 2 + 1 < X) {// 햄버거 반보다 크면
			//System.out.println("3번");
			return P_su[N] / 2 + 1 + P_su(X - (all[N] / 2 + 1), N - 1);
		} else if (all[N] / 2 + 1 > X) {
			//System.out.println("4번");
			return P_su(X - 1, N - 1);
		} // 햄버거 반보다 작으면
		else {// 햄버거 반이랑 같으면
			//System.out.println("5번");
			return P_su[N] / 2 + 1;
		}
	}

}
