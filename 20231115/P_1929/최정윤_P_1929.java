
import java.util.Scanner;

public class Pro_1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] notPrime = new boolean[N + 1];
		notPrime[1]=true;
		for (int i = 2; i <= N; i++) {
			if (notPrime[i])
				continue;
			else {
				for (int j = i * 2; j <= N; j += i) {
					notPrime[j] = true;
				}
			}
		}
		for (int i = M; i <= N; i++) {
			if (!notPrime[i])
				System.out.println(i);
		}
	}

}
