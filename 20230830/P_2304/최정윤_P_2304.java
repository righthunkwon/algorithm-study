import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N];
		int[] H = new int[N];// 일단 값저장
		int maxL = 0, minL = 1000;
		int maxH = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
			maxL = Math.max(maxL, L[i]);
			maxH = Math.max(maxH, H[i]);
			minL = Math.min(minL, L[i]);
		} // 입력끝

		int[] arr = new int[maxL + 1];// 1부터
		for (int i = 0; i < N; i++) {
			arr[L[i]] = H[i];
		} // arr인덱스가 기둥자리 값이 높이
		int i;
		int high = 0;
		int result = 0;
		for (i = minL; i <= maxL && arr[i] != maxH; i++) {
			if (arr[i] > high) {
				high = arr[i];
			}
			result += high;
		}
		result += maxH;
		high = 0;
		for (int j = maxL; j > i; j--) {
			if (arr[j] > high) {
				high = arr[j];
			}
			result += high;
		}
		System.out.println(result);
	}
}
