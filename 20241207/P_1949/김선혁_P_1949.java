package 백준;

import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	static ArrayList<Integer>[] ar;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 1.주민수는 최대로
		// 2.'우수 마을'끼리는 서로 인접해 있을 수 없다.
		// 3. 적어도 하나의 '우수 마을'과는 인접해 있어야 한다
		
		// --> 주민수의 최대가 되려면 dp 사용해야함
		arr = new int[N+1];
		for(int i = 1 ; i<= N;i++) {
			arr[i] = sc.nextInt();
		}
		ar = new ArrayList[N+1];
		for(int i = 1 ;i <= N ;i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ;i < N-1 ;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		// 초기화랑 다리 추가 완료
		// 이제 dfs를 통해서 1에서 시작 하여 
		// 트리의 아래로 내려간 후 거꾸로 밑에서부터 해당 마을을 포함했을때랑 안했을때 계산
		dp = new int[N+1][2]; // 0은 미포함 , 1은 포함
		// 만약 올라갈때 밑이 1이었다면 해당마을은 0, 반대로 밑이 미포함이면 해당마을은 포함해야함
		// 이런식으로 최대값 갱신
		dfs(1,0);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}
	public static void dfs(int now, int prior) {
		for(int i = 0 ;i<ar[now].size();i++) {
			int tmp = ar[now].get(i);
			if(tmp == prior) {
				continue;
			}
			// 연결된 곳에서 새롭게 dfs 진행
			// 맨마지막까지 쭉 dfs를 통해서 내려간 후에
			// 그 결과를 위로 가져옴
			dfs(tmp, now);
			// 해당마을 선택안할때는 전에값 모든것들 중에 최대값 선택
			dp[now][0] += Math.max(dp[tmp][0], dp[tmp][1]);
			// 해당마을 선택시는 선택안할 때 전의값들 추가
			dp[now][1] += dp[tmp][0];
			
		}
		// 해당 마을을 선택할 경우 1에 기록
		dp[now][1] += arr[now];
		return;
	}

}
