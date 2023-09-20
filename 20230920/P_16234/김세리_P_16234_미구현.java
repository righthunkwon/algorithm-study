package _20230920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16234_인구이동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int L = Integer.parseInt(str.nextToken());
		int R = Integer.parseInt(str.nextToken());
		int A[][] = new int [N][N];
		// 나올 수 있는 관계의 최대 개수=(N-1)*2*N
		// 인구 차이가 범위 만족하는지 확인하고 만족하는 관계라면
		// 도시1, 도시2, 도시1인구, 도시2인구 입력
		// 그래서 배열 안에 1,2열에 연결되는 도시 있으면 인구도 다 합해서 그 해당 도시 수로 나눠버림
		// 남은 도시 있으면 또 연결되는지 본다
		// 연결되면 연결하기
		// 그래서 원래 배열에 바뀐 인구로 집어넣고
		// 다시 반복-> rel 배열이 전부 0이면 더이상 인구이동 필요없단 소리-> cnt 출력
		// 구현은 아직 못함....
		int rel[][] = new int [(N-1)*2*N][4];
		
		// 도시별 인구 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
	}//main

}

