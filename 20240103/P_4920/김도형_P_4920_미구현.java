package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q4920_테트리스_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1; //테스트케이스 번호
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 세로
			int ans =0;
			if(N==0)return; //입력 마지막 줄엔 0
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans=Integer.MIN_VALUE; //정답 초기화

			// 출력확인
			for (int a = 0; a < N; a++) {
				System.out.println();
				for (int b = 0; b < N; b++) {
					System.out.print(map[a][b] + " ");
				}
			}
			System.out.println();
			
			for(int i=0;i<N;i++) {
				
			}
			
			
			
			System.out.println(T+". "+ans);
			T++; //테스트 케이스 번호 +1
		}
	}// main
}// class
