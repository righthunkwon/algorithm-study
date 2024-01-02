package level_25_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행복 유치원
// n개의 그룹은 n-1개의 구분선으로 만들 수 있다
// 차이의 배열을 만들고 해당 배열을 오름차순 정렬하여 낮은 요소부터 더한다 
public class P_13164 {
	private static int n, k, ans;
	private static int[] arr, diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 원생 수
		k = Integer.parseInt(st.nextToken()); // 조의 수
		arr = new int[n]; // 원생 수
		diff = new int[n-1]; // 차이 배열
		ans = 0; // 티셔츠 만드는 최소 비용합

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n - 1; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(diff); // 최소차이 순으로 정렬 

		// 가장 큰 키차이인 k-1개를 제외하고 나머지를 더한다.
		for (int i = 0; i < (n-1) - (k-1); i++) {
			ans += diff[i];
		}
		System.out.println(ans);
		br.close();
	}
}
