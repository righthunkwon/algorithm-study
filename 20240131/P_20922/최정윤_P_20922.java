
import java.io.*;
import java.util.*;

public class Pro_20922_겹치는건싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//그 수의 cnt를 저장해놓는 배열
		int[] cnt = new int[100001];
		int s = 0;
		int e = 1;
		cnt[arr[s]]++;
		cnt[arr[e]]++;
		int max = 0 ;
		int result = 1;
		//어떠한 수가 K개 이상이라면 s를 뒤로 밀면서 K개 이하가 될 때까지 변경
		//K개 이상 아니라면 e를 뒤로 밀면서 최댓값 갱신
		while (s <= e && e < N) {
			if (cnt[arr[e]] > K) {
				while (s <= e && e < N&&cnt[arr[e]] > K) {
					cnt[arr[s]]--;
					result--;//s를 뒤로 밀기 때문에 길이 --
					s++;
				}
			} else {
				result++;
				e++;
				if(e!=N)cnt[arr[e]]++;
			}
			max = Math.max(max, result);
		}
		System.out.println(max);
	}
}
