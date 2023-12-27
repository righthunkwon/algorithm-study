package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube_Silver {
	static int N, Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		ArrayList<int[]> [] list = new ArrayList[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken())-1;
			int q = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken());
			list[p].add(new int[] {q, r});
			list[q].add(new int[] {p, r});
		}// 인접리스트 입력완
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken())-1;
			
			int res = 0;
			Queue<Integer> que = new LinkedList<>();
			boolean[] chk = new boolean[N];
			que.add(v);
			chk[v] = true;
			
			while(!que.isEmpty()) {
				int poll = que.poll();
				for(int[] arr : list[poll]) {
					int link = arr[0];
					int usado = arr[1];
					// k이상인것들만 추천동영상이 될거야
					if(chk[link] || usado < k) continue;
					res++;
					chk[link] = true;
					que.add(link);
				}
			}
			System.out.println(res);
			
		}
	}
}
