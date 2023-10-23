import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054_가장긴바토닉부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int A = Integer.parseInt(br.readLine());
		int[] arr = new int[A+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dpAsc = new int[A+1];
		int[] dpDesc = new int[A+1];
		
		// 순방향으로 구한 dp테이블
		for(int i = 1; i <= A; i++) {
			dpAsc[i] = 1;
			// 1부터 i번째 까지 탐색
			for(int j = 1; j <= i; j++) {
				// i번째 원소가 j번째보다 작으면 dp[i]는 dp[j] 값 + 1로 갱신
				if(arr[j] < arr[i]) {
					dpAsc[i] = Math.max(dpAsc[i], dpAsc[j] + 1);
				}
			}
		}
		// 역방향으로 구한 dp테이블
		for(int i = A; i >= 1; i--) {
			dpDesc[i] = 1;
			// 맨 뒤부터 i번째 까지 탐색
			for(int j = A; j >= i; j--) {
				// i번째 원소가 j번째보다 작으면 dp[i]는 dp[j] 값 + 1로 갱신
				if(arr[j] < arr[i]) {
					dpDesc[i] = Math.max(dpDesc[i], dpDesc[j] + 1);
				}
			}
		}
		// 두 개의 dp테이블(순방향, 역방향)을 합치면
		// 각 부분집합의 가장 큰 숫자가 중복이 된다! 
		System.out.println(Arrays.toString(dpAsc));
		System.out.println(Arrays.toString(dpDesc));
		
		int res = 0;
		for(int i = 1; i <= A; i++) {
			res = res > dpAsc[i] + dpDesc[i] ? res : dpAsc[i] + dpDesc[i];
		}
		// 각 부분집합의 가장 큰 숫자가 중복이 되었으니 -1 을해서 출력
		System.out.println(res-1);
	}
}
