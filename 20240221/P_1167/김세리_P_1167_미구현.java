package _20240221;

import java.util.*;
import java.io.*;

public class _1167_트리의지름 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		
		List<int[]>[] graph = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int j=0;j<st.countTokens()-2;j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[i]=new ArrayList<>();
				graph[i].add(new int[] {a,b});
			}
			
		}//입력끝


	}//main

}
