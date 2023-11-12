package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내가 응애일 수 있을 때 : -1, +1 인덱스 중 하나만 응애일 때
// 0번 인덱스를 판단하려면 N-1, 1번 인덱스를 판단해야함
// 마지막 인덱스 (N-1) 를 판단하려면 N-2, 0 인덱스를 판단해야함
public class BOJ_28088_응애 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 몇 명이서 둥글게 서있냐
		int M = Integer.parseInt(st.nextToken()); // 처음 응애하는 사람 수
		int K = Integer.parseInt(st.nextToken()); // 몇 턴인지
		
		boolean[][] eungae = new boolean[N][K+1]; // true : 응애, false : 노응애 
		for(int i = 0; i < M; i++) eungae[Integer.parseInt(br.readLine())][0] = true;
		
		int turn = 0;
		int k = 0;
		while(turn < K) {
			// 0번 인덱스와 마지막 인덱스(N-1)는 따로 판단해주자
			for(int i = 1; i < N-1; i++) {
				if(eungae[i-1][k] && !eungae[i+1][k] || !eungae[i-1][k] && eungae[i+1][k]) eungae[i][k+1] = true;
				else eungae[i][k+1] = false;
			}
			// 0번 인덱스 판단
			if(eungae[N-1][k] && !eungae[1][k] || !eungae[N-1][k] && eungae[1][k]) eungae[0][k+1] = true;
			else eungae[0][k+1] = false;
			// 마지막(N-1)인덱스 판단
			if(eungae[N-2][k] && !eungae[0][k] || !eungae[N-2][k] && eungae[0][k]) eungae[N-1][k+1] = true;
			else eungae[N-1][k+1] = false;
			
			k++;
			turn++;
		}
		
		int res = 0;
		for(int i = 0; i < N; i++) if(eungae[i][k]) res++;
		
		System.out.println(res);
		
	}
}
