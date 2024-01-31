
import java.io.*;
import java.util.*;
//M으로 나눠지는 수 =(M으로 나눠지는 수)+(M으로 나눠지는 수)
//M으로 나눴을 때 나머지가 1인 수 = M으로 나눠지는 수 +M으로 나눴을 때 나머지가 1인 수
//M으로 나눴을 때 나머지가 N인 수 = M으로 나눠지는 수 +M으로 나눴을 때 나머지가 N인 수

//누적합을 통해 저장해놓고 M으로 나눈 나머지를 저장해놓은 후
//나머지가 같은 것들의 개수를 세고(cnt) , cnt C 2를 하는 로직
public class Pro_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] sum = new long[N];
		long[] div = new long[M];

		long cnt = 0;
		sum[0] = Long.parseLong(st.nextToken());
		for (int i = 0; i < N; i++) {
			if (i != 0) {
				sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
			}

			div[(int) (sum[i] % M)]++;
		}
		for (int i = 0; i < M; i++) {
			if (div[i] != 0) {
				cnt += div[i] * (div[i] - 1) / 2;
			}
		}
		cnt += div[0];
		System.out.println(cnt);
	}
}
