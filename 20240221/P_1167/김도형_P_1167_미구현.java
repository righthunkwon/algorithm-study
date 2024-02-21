package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Q1167_트리의_지름 {
	
	static int V;
	static List<List<Node>>tree;
	
	static class Node{
		int num;
		int distance;
		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		for(int i=0;i<V+1;i++) {
			tree.add(new ArrayList<Node>());
		}
		
		while(V-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nodeNum = Integer.parseInt(st.nextToken());
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if(x==-1)break;
				int y = Integer.parseInt(st.nextToken());
				tree.get(nodeNum).add(new Node(x,y));
			}
		}
		//입력 완
		
		
	}//class
}//main
