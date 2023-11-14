package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) list.add(new int[] {i, j});
			}
		}// 입력 완료
		
//		System.out.println(list.get(0)[0]);
//		System.out.println(list.get(0)[1]);
		
		int res = 0;
		int tmp = 987654321;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					tmp = 987654312;
					for(int k = 0; k < list.size(); k++) {
						int dis = Math.max(Math.abs(i - list.get(k)[0]), Math.abs(j - list.get(k)[1]));
						tmp = tmp > dis ? dis : tmp;
					}
					res = res < tmp ? tmp : res;
				}
			}
		}
		
		System.out.println(res);
	}
}
