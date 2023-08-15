package Algo_Study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하재률_P_2839 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		/* 
		 * 4, 7 제외하고는 무조건 3과 5의 합 >> -1
		 * 5의 배수이면 /5 개
		 * 5로 나눈 나머지 1이면 /5 + 1개
		 * 5로 나눈 나머지 2이면 /5 + 2개
		 * 5로 나눈 나머지 3이면 /5 + 1개
		 * 5로 나눈 나머지 4이면 /5 + 2개
		 * 
		 * ex) 어떠한 숫자라도 5로 나눈 나머지가 1이라면 
		 * 6을 빼면 5로 나누어 떨어지겠죠?
		 * 6은 3kg 봉지 2개로 구성된다.
		 * 고로 5로 나눈 값 + 1이 최소 봉지의 개수이다.
		 * 
		 *  나머지가 2인 경우에는 마지막 12의 구성을 3kg봉지 4개로
		 *  -> 5로 나눈 값 + 2
		 *  
		 *  나머지가 3인 경우는 나머지 3을 3kg 봉지 하나
		 *  -> 5로 나눈 값 + 1
		 *  
		 *  나머지가 4인 경우는 마지막 9의 구성을 3kg봉지 3개로
		 *  -> 5로 나눈 값 + 2
		*/ 
		
		if(N == 4 || N == 7) {
			System.out.println(-1);
		}else if(N % 5 == 0){
			System.out.println(N / 5);
		}else if(N % 5 == 1 || N % 5 == 3) {
			System.out.println((N / 5) + 1);
		}else if(N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}

	}

}
