import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,V;
	static boolean[] check; // 방문했는지 체크하는 flag
	static int[][] arr;	 // 입력받을 배열
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer> ans1 = new ArrayList<>(); // dfs 결과를 저장할 배열
	static ArrayList<Integer> ans2 = new ArrayList<>(); // bfs 결과를 저장할 배열
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);		
		 N = sc.nextInt();
		 M = sc.nextInt();
		 V = sc.nextInt();		
		arr = new int[N+1][N+1]; // 배열은 N+1까지 2차원 배열로
		check = new boolean[N+1]; // N+1까지 방문했는지 확인
		for(int i = 0 ; i < M ; i ++) {			
			int a = sc.nextInt();
			int b = sc.nextInt();			
			arr[a][b] = arr[b][a] =  1;	
			// a - b 양방향이므로 둘다 서로 1로 값을 바꿔주고
			// 만약 값이 true면 패스
		}
	
		dfs(V);
		check = new boolean[N+1]; // 다시초기화		
		bfs(V);		
		for(int i =0;i<ans1.size();i++) {
			System.out.print(ans1.get(i)+" ");
		}
		System.out.println();
		for(int i =0;i<ans2.size();i++) {
			System.out.print(ans2.get(i)+" ");
		}
	}
	public static void dfs(int v) {		
		check[v] = true; // 먼저 v인 숫자를 true로 바꿔주고 배열에 추가
		ans1.add(v);
		for(int i = 0 ; i <= N ; i++) {
			// 낮은수부터 체크하기 때문에 괜찮
			// 확인해서 1이며 방문하지 않았다면
			// dfs를 돈다.
			if(arr[v][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		q.add(v); // v인 숫자를 큐에 넣어주고 true로 바꿔줌
		check[v] = true; // 바꾼후에 배열에 추가
		ans2.add(v);
		while(!q.isEmpty()) { // 큐에 저장한 숫자가 없을 때까지
			v = q.poll();			
			for(int i = 1 ; i <= N ; i++) {
				if(arr[v][i] == 1 && !check[i]) {
					q.add(i);
					ans2.add(i);
					check[i] = true;
				}
			}
		}


	}

}
