package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	static int[] arr;
	static boolean[] chk;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 0) break;
			else k = tmp;
			arr = new int[k];
			chk = new boolean[k];
			for(int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			System.out.println();
		}
	}
	
	static void dfs(int depth, int st) {
		if(depth == 6) {
			for(int i = 0; i < k; i++) {
				if(chk[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		for(int i = st; i < k; i++) {
			chk[i] = true;
			dfs(depth + 1, i + 1);
			chk[i] = false;
		}
	}
}
