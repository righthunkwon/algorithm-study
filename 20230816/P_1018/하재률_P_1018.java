package Algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하재률_P_1018 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}// 입력 완료
		
		String[] chess = {"WBWBWBWB", "BWBWBWBW"};
		int cntW, cntB;
		int min = 64;
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
				cntW = 0; // 시작이 W일때
				cntB = 0; // 시작이 B일때
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(arr[i+k].charAt(j+l) != chess[k % 2].charAt(l)) {
							cntW++;
						}
						if(arr[i+k].charAt(j+l) != chess[(k +1) % 2].charAt(l)) {
							cntB++;
						}
					}
				}
				min = (cntW < cntB) ? ((cntW < min) ? cntW : min) : ((cntB < min) ? cntB : min); 
			}
		}
		System.out.println(min);
		
	}
}
