package _20240228;

import java.util.*;
import java.io.*;

public class _12763_지각하면안돼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		int[] arr = new int[N+1];
		int L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		}
	}//main

}
