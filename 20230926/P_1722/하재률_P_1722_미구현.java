package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1722_순열의순서 {
	static int N, K;
	static long[] cell;
	static boolean[] chk;
	static long[] fac;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		f(); // 팩토리얼 값 미리 계산
		
		// 1일때
		if(Integer.parseInt(st.nextToken()) == 1) {
			K = Integer.parseInt(st.nextToken());
			cell = new long[N]; // K번째 순열 저장용
			chk = new boolean[N]; // 사용된 숫자 쳌
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!chk[j]) {
						// 사용되지 않은 숫자 찾기
						if(fac[N-1-i] < K) {
							K -= fac[N-1-i];
						} else {
							cell[i] = j + 1; // 숫자 cell배열에 저장
							chk[j] = true; // 사용 쳌
							break;
						}
					}
				}
			}
			
			for(int i = 0 ; i < N; i++) {
				System.out.print(cell[i] + " "); // K번째 순열 출력
			}
			
		// 2일때
		} else {
			cell = new long[N]; // 순열 저장용
			chk = new boolean[N]; // 사용된 숫자 쳌
			long res = 0;
			
			for(int i = 0; i < N; i++) {
				cell[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!chk[j] && cell[i] == j + 1) {
						// 해당 숫자 위치 찾기
						chk[j] = true; // 사용 쳌
						break;
					}
					if(!chk[j]) {
						// 사용되지 않았으면, 결과에 팩토리얼값 더하기
						res += fac[N - 1 - i];
					}
				}
			}
			System.out.println(res + 1);
			
		}
		
	}
	
	static void f() {
		fac = new long[N+1];
		fac[0] = 1;
		for(int i = 1; i <= N; i++) {
			fac[i] = fac[i-1] * i;
		}
	}
	
//	static void solve1(int idx) {
//		if(idx == N) {
//			cnt++;
//			if(cnt == K) {
//				for(int i = 0; i < N; i++) {
//					System.out.print(cell[i] + " ");
//				}
//				System.out.println();
//			}
//			return;
//		}
//		for(int i = 1; i < N + 1; i++) {
//			if(!chk[i]) {
//				cell[idx] = i;
//				chk[i] = true;
//				solve1(idx + 1);
//				chk[i] = false;
//			}
//		}
//	}
//	
//	static void solve2(int idx) {
//		if(idx == N) {
//			cnt++;
//			boolean flag = true;
//			for(int i = 0; i < N; i++) {
//				if(cell[i] != arr[i]) {
//					flag = false;
//					break;
//				}
//			}
//			if(flag) System.out.println(cnt);
//			return;
//		}
//		for(int i = 1; i < N + 1; i++) {
//			if(!chk[i]) {
//				cell[idx] = i;
//				chk[i] = true;
//				solve2(idx + 1);
//				chk[i] = false;
//			}
//		}
//	}
}
