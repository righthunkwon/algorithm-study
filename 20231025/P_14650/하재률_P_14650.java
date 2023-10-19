package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14650_걷다보니신천역삼small {
	static int[] tmp;
	static int[] sam = {0, 1, 2};
	static int N, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tmp = new int[N];
		sol(0);
		System.out.println(res);

	}

	static void sol(int idx) {
		if(idx == N) {
			int sum = 0;
			if(tmp[0] != 0) { // 맨 앞에 0이 아니면
				for(int i = 0; i < N; i++) { // 각 자리 숫자 더해서
					sum += tmp[i];
				}
				if(sum % 3 == 0) res++; // 3으로 나누어 떨어지면 3의 배수이다
			}
			return;
		}
		// 모든 중복 순열을 구하자
		for(int i = 0; i < 3; i++) {
			tmp[idx] = sam[i];
			sol(idx+1);
		}
	}
}
