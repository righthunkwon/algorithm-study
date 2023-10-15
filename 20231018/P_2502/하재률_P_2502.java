package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2502_떡먹는호랑이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()); // 넘어온 날 3 ~ 30
		int K = Integer.parseInt(st.nextToken()); // 호랑이에게 준 떡 개수 10 ~ 100,000
		/*
		 	첫째날 x개, 둘째날 y개
		 	3 : x + y 개
		 	4 : x + 2y 개
		 	5 : 2x + 3y 개
		 	6 : 3x + 5y 개
		 	7 : 5x + 8y 개
		 	--> x와 y의 계수가 피보나치를 따른다
		 	여섯번째 날 41개를 줬다면
		 	3x + 5y = 41 의 해를 찾으면 답인듯하다!
		 	D는 3 ~ 30 이니까 30까지의 피보나치 수열을 배열에 담고
		 	계수에 피보나치 배열의 값을 설정해주자
		 	1 1 2 3 5 8
		*/
		// 피보나치 수열 만들기
		int[] f = new int[31];
		f[0] = 1; f[1] = 1;
		for(int i = 2; i <= 30; i++) {
			f[i] = f[i-2] + f[i-1];
		}
		
		// f[D-3] * x + f[d-2] * y = K
		// y로 정리하면 y = (K - f[D-3] * x) / f[D-2]
		// x, y 는 정수이기 때문에 (K - f[D-3] * x) % f[D-2] == 0 을 만족하는 x, y값 구하기
		int x = 1; int y;
		while(true) {
			if((K - f[D-3] * x) % f[D-2] == 0) {
				y = (K - f[D-3] * x) / f[D-2];
				break;
			}
			x++;
		}
		System.out.println(x+"\n"+y);
	}
}
