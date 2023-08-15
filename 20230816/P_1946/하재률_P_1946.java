package Algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하재률_P_1946 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken()); // 서류 등수를 인덱스로하는
				arr[doc] = Integer.parseInt(st.nextToken()); // 인터뷰 등수 배열 만들깅 
			}
			// 위의 방식으로 입력 받는다면, 서류 등수가 자동으로 정렬 + 2차원 배열 만들 필요 X
			
			int cnt = 1; // 1등은 뽑아놓고 시작
			int tmp = arr[1]; // 1등의 인터뷰 등수를 기준으로
			// 서류 1등은 뽑아놓고 시작하니까 서류 2등부터 for문돌기 
			for(int i = 2; i <= N; i++) {
				if(arr[i] < tmp) { // 기준 인터뷰 등수보다 작다면
					cnt++; // 선발!
					tmp = arr[i]; // 뽑힌 녀석의 인터뷰 등수가 기준이되서 다시 돈다
				}
			}
			
			System.out.println(cnt);
		}
		
	}
}
