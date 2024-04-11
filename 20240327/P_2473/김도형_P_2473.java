import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		long tmp = Long.MAX_VALUE; // 세 용액으로 만들 수 있는 0에 가장 가까운 특성값
		int a = 0;
		int b = 0;
		int c = 0;

		l:for (int i = 0; i < N - 2; i++) {

			// 이분탐색
			int left = i + 1;
			int right = N - 1;

			while (left < right) {

				long sum = (long) arr[i] + arr[left] + arr[right];
				if (tmp > Math.abs(sum)) {
					tmp = Math.abs(sum); //sum이 0에 더 가까우면 갱신
					a = arr[i];
					b = arr[left];
					c = arr[right];
				}

				if (sum == 0) {
					a = arr[i];
					b = arr[left];
					c = arr[right];
					break l; //0만들 수 있으면 더 볼 필요 x
				} else if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				}
			}

		}
		
		System.out.println(a+" "+b+" "+c);

	}// main
}// class
