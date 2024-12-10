import java.io.*;
public class Main {
	static boolean prime[] = new boolean[1004002];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		prime();
		for (int i = n; i < 1004000; i++) {
			if (!prime[i]) {
				String str = String.valueOf(i);
				StringBuffer sb = new StringBuffer(str);
				String reverseStr = sb.reverse().toString();
				if (str.equals(reverseStr)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	static void prime() {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			}
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
