import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static boolean[] check; // 방문했는지 체크하는 flag
	static int[][] arr;	 // 입력받을 배열
	static Queue<Integer> q = new LinkedList<>();
	static int cnt;
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);		
		 N = sc.nextInt();
		 M = sc.nextInt();
		arr = new int[N+1][N+1]; // 배열은 N+1까지 2차원 배열로
		check = new boolean[N+1]; // N+1까지 방문했는지 확인
		for(int i = 0 ; i < M ; i ++) {			
			int a = sc.nextInt();
			int b = sc.nextInt();			
			arr[a][b] = arr[b][a] =  1;	
			// a - b 양방향이므로 둘다 서로 1로 값을 바꿔주고
			// 만약 값이 true면 패스
		}
		cnt = 0;
		dfs(1);
		// 시작은 1번부터 시작
		System.out.println(cnt);
		
		
	}
	public static void dfs(int v) {		
		check[v] = true; // 먼저 v인 숫자를 true로 바꿔주고 배열에 추가
		for(int i = 0 ; i <= N ; i++) {
			// 낮은수부터 체크하기 때문에 괜찮
			// 확인해서 1이며 방문하지 않았다면
			// dfs를 돈다.
			if(arr[v][i] == 1 && !check[i]) {
				cnt++; // 1번컴퓨터를 통해 걸리는 숫자를 세기 때문에 
				// dfs를 돌때만 cnt++해준다.
				dfs(i);
			}
		}
	}

	

	

}
