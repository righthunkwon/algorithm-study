package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
//	static int time;
//	static boolean[] chk; // 걍 재귀 돌릴때 씀
//	static int min;
//	static int[] memo; // 메모이제이션할때 씀
	static int[] time; // 각 좌표 걸리는 시간 저장용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈의 위치 0 ~ 100,000
		K = Integer.parseInt(st.nextToken()); // 동생의 위치 0 ~ 100,000
//		min = Integer.MAX_VALUE;
		time = new int[100001];
		
		solve(N);
		System.out.println(time[K]);
		
		// 두번째 방법 main 함수..
//		for(int i = 0; i < 100001; i ++) {
//			memo[i] = -1;
//		}
		
//		int res = solve(N);
//		System.out.println(res);
		
		// 첫번째 방법 main 함수..
//		chk = new boolean[100001];
		
//		solve(N, 0);
//		System.out.println(min);
	}
	
	// Queue를 썼다는 사실만으로 bfs 인가..?
	static void  solve(int N) {
		Queue<Integer> q = new LinkedList<>(); // 큐 생성
		q.add(N); // 시작값을 큐에 넣고
		time[N] = 0; // 시작점은 시간이 0이 걸린다 (어차피 int[]는 0 초기화라 안해줘도 될 듯?)
		
		while(!q.isEmpty()) {
			int x = q.poll(); // x는 현재 위치
			if(x == K) break; // 목표 위치 도달하면 break
			int next; // 다음 위치
			
			// 현재 위치에서 1더하기, 1뺴기, 2곱하기 중
			// 조건에 맞고, 방문하지 않았으면(도착 시간 계산이 되어있지 않았으면) 큐에넣고 다음을 계산하기
			for(int i = 0; i < 3; i++) {  
				if(i == 0) next = x - 1; // 다음 위치를 현재위치 + 1
				else if(i == 1) next = x + 1; // 다음 위치를 현재위치 - 1
				else next = x * 2; // 다음 위치를 현재위치 * 2
				
				if(next >= 0 && next <= 100000 && time[next] == 0) {
					q.add(next); // 조건에 맞으면 큐에 넣고 다음 위치를 계속 계산하자
					time[next] = time[x] + 1; // 다음 위치에 도달하면 시간을 + 1
				}
			}
		}
	}
}
	
	// 스택오버플로우 때문에 메모이제이션 해봤는데도 스택오버플로우 왜뜸 진짜모름
//	static int solve(int n) {
//		if(n == K) {
//			return 0;
//		}
//		
//		if(memo[n] != -1) {
//			return memo[n];
//		}
//		
//		int time = 1 + Math.min(Math.min(solve(n + 1), solve(n - 1)), solve(n * 2));
//		
//		memo[n] = time;
//		
//		return time;
//	}
	
	// 처음에 푼 거.. 문제 없어 보이는데 스택오버플로우뜸
//	static void solve(int n, int time) {
//		if(n == K) {
//			min = Math.min(min, time);
//			return;
//		}
//		
//		if(n < 0 || n > 100000 || chk[n] ) {
//			return;
//		}
//		
//		chk[n] = true;
//		solve(n + 1, time + 1);
//		solve(n - 1, time + 1);
//		solve(n * 2, time + 1);
//		chk[n] = false;
//	}

