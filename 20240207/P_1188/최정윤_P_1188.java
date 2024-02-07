import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// N과 M의 최대공약수-1
		int b=Math.max(N, M);
		int s=Math.min(N, M);
		System.out.println(M-gcd(b, s));
	}

	private static int gcd(int N, int M) {
		if(M==1)return 1;
		if (N % M == 0)
			return M;
		return gcd(N, N % M);
	}
}
