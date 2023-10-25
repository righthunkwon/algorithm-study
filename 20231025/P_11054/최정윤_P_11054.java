package baek;

import java.io.*;
import java.util.*;

public class Pro_11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 각 인덱스를 peak라고 생각하기 
		// 각 i방을 기준으로 나눠서 앞 ,뒤에 있는 작은 것의 개수 세고 더하기(순차적으로 작아야함)
		//dp를 이용하면 앞부터 돌기때문에 순차적으로 작은 값만 들어오게 되어있다. 항상 나보다 작은 값만 선택하기 때문에

		int[] dp_f = new int[N];
		// 1.앞에 작은 것이 몇 개 있는지
		  
		dp_f[0] = 0;//처음 값보다 작은 수는 없을 테니 0으로 초기값 세팅
		for (int i = 1; i < N; i++) {//peak의 기준
			for (int j = 0; j < i; j++) {//본인 전까지
				if (arr[i] > arr[j])//나보다 작은 수면 (그 수 보다 작은 수+1)과 나 자신 중 큰 값으로 갱신
					dp_f[i] = Math.max(dp_f[j] + 1, dp_f[i]);
			}
		}
//		System.out.println(Arrays.toString(dp_min));
		//2.뒤에 작은 것이 몇 개 있는지
		int[] dp_b = new int[N];
		dp_b[N - 1] = 0;
		for (int i = N - 1; i >= 0; i--) {//뒤부터 본다. peak의 기준
			for (int j = N - 1; j > i; j--) {//맨 뒤부터 본인 뒤까지 
				if (arr[i] > arr[j])
					dp_b[i] = Math.max(dp_b[j] + 1, dp_b[i]);
			}
		}
//		System.out.println(Arrays.toString(dp_max));
		int[] dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = dp_f[i] + dp_b[i] + 1;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
