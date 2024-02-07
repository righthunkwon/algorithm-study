package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_동물원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][3]; // 0: 빔, 1: 왼, 2: 오
		
		arr[0][0] = arr[0][1] = arr[0][2] = 1;
		
		for(int i = 1; i < N; i++) {
			arr[i][0] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2])%9901;
			arr[i][1] = (arr[i-1][0] + arr[i-1][2])%9901;
			arr[i][2] = (arr[i-1][0] + arr[i-1][1])%9901;
		}
		long res = 0;
		for(int i = 0; i < 3; i++) res += arr[N-1][i];
		
		System.out.println(res%9901);
		
	}
}
