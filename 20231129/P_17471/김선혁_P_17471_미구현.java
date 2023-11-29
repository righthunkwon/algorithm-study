import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {	
	 static int N;
	 static int[] arr;
	 static ArrayList<Integer>[] list;
	 static boolean[] flag;
	static Set<Integer> set = new HashSet<>(); 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		N =sc.nextInt();
		// 먼저 조합을 통해서
		// 도시들을 선택한 후에
		// 그 도시를 기준으로
		// bfs 실행
		
		list = new ArrayList[N+1];
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
			// 구역의 번호를 일단
			// arr에다가 다 넣고
			arr[i] = sc.nextInt();
		}
		for(int i=1; i<N+1; i++) {
			int jl = sc.nextInt();
			for(int j=0; j<jl; j++) {
				int b= sc.nextInt();
				// 인접한 구역의 정보를
				//그대로 리스트에다가 다 담음
				list[i].add(b);
			}
		}
		
		for(int i =0;i<N-1;i++) {
			solve(1,); // dfs 돌림
		}
		
	}

	static void solve(int idx, int cost, int r, int stat) {
		if(r == 0) {
			if(set.add(stat)) {
				// 여기서 이제 값을 구해야함
			}
			return;
		}
		
		for(int i=idx; i<N; i++) {
			stat |= 1<<(i+1);
			solve(i+1, cost+arr[i+1], r-1, stat);
			stat ^= 1<<(i+1);
		}
	}

	
	class Pos {
	    int x;
	    int p;;
	 
	    Pos(int x, int p) {
	        this.x = x;
	        this.p = p;
	    }
	}

}
