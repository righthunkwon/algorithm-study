package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2666_벽장문의이동 {
	
	static int N, open1, open2, M, res;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		open1 = Integer.parseInt(st.nextToken());
		open2 = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		for(int i = 0; i < M; i++) arr[i] = Integer.parseInt(br.readLine());
		res = Integer.MAX_VALUE;
		dfs(open1, open2, 0, 0);
		System.out.println(res);
		
	}
	
	static void dfs(int tmp1, int tmp2, int depth, int cnt) {
		if(depth == M) {
			res = Math.min(res, cnt);
			return;
		}
		
		int tmp_A = Math.abs(tmp1 - arr[depth]);
		int tmp_B = Math.abs(tmp2 - arr[depth]);
		
		dfs(arr[depth], tmp2, depth+1, cnt + tmp_A);
		dfs(tmp1, arr[depth], depth+1, cnt + tmp_B);
	}
}
