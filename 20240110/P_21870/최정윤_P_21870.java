import java.io.*;
import java.util.StringTokenizer;
public class Pro_21870_시철이가사랑한GCD유클리드호제법 {
  static int[] s;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = new int[N];
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		// 나머지가 1일 경우 왼쪽은 그대로 오른쪽은 +1개
		max = 0;
		dfs(0, N, 0);
		System.out.println(max);
	}

	private static void dfs(int start, int cnt, int sum) {
		if (cnt == 1) {// 원소의 개수가 1개
			sum += s[start];
			max = Math.max(sum, max);
			return;
		} else if (cnt % 2 == 0) {
			// 왼쪽
			dfs(start + cnt / 2, cnt / 2, sum + gcd(start, cnt / 2));
			// 오른쪽
			dfs(start, cnt / 2, sum + gcd(start + cnt / 2, cnt / 2));
		} else {
			// 왼쪽
			dfs(start + cnt / 2, cnt / 2 + 1, sum + gcd(start, cnt / 2));
			// 오른쪽
			dfs(start, cnt / 2, sum + gcd(start + cnt / 2, cnt / 2 + 1));
		}
	}

	private static int gcd(int start, int cnt) { //start 인덱스 부터 cnt개의 최대공약수 구하기
		if (cnt == 1)
			return s[start];
		int gcd = 1;
		int[] gcd_arr = new int[cnt]; //그 배열 값을 바꾸면 dfs에서 혼동오니까 새로 저장해서 바꿈
		for (int i = start; i < start + cnt; i++) {
			gcd_arr[i - start] = s[i];
		}
		// 유클리드호제법
		for (int i = 0; i < cnt - 1; i++) { //앞 두 수부터 최대공약수 구한다. 
			int two_gcd = euclidean(gcd_arr[i], gcd_arr[i + 1]);
			gcd_arr[i] = two_gcd;
			gcd_arr[i + 1] = two_gcd;
		}
		return gcd_arr[cnt - 1];
	}
	//유클리드 호제법 : (A,B)의 약수는 (B,A%B)와 같다 ....
	private static int euclidean(int a, int b) {
		if (a == b || b == 0)	return a; //같다면 최대공약수는 그 수, 0이라면 B로 나눠떨어진것이기 때문에 최대공약수는 B
		if (a == 0) return b;
		else if (a < b) { //큰수를 a로 세팅
			int imsi = a;
			a = b;
			b = imsi;
		} // 무조건 b가 더크게 만들기
		return euclidean(b, a % b);
	}
}
