package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	static int N, M, H;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로선 개수
		M = Integer.parseInt(st.nextToken()); // 가로선 개수
		H = Integer.parseInt(st.nextToken()); // 가로선 놓을 수 있는 위치 개수
		
		arr = new int[H][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a][b] = 1;
		}
		// 가로선을 3개까지 놓을 수 있으니까... 가로선 추가 안하고 되는지 확인 0개..1, 2, 3개 놓을 수 있는 모든 경우의 수 ?
		// 도착 지점을 어케 확인하지 몰?루
				
		
	}
}
