import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Q1949_우수_마을 {

	static int [][] dp; //dp[a][0]:a마을 채택안한 경우  dp[a][1]:a마을 채택한 경우
	static int n;
	static int [] arr;
	static List<Integer>[]adj;
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken()); //인구 정보 저장
		}

		adj = new ArrayList[n+1]; 
		for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
		for(int i=1;i<n;i++) { //인접 정보 저장
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
//		//입력확인용
//		for(int i=1;i<=n;i++) {
//			System.out.println("<"+i+">번마을과 인접한 마을");
//			for(int j=0;j<adj[i].size();j++) {
//				System.out.print(adj[i].get(j)+" ");
//			}
//			System.out.println();
//		}
		dp = new int[n+1][2];
		dfs(0,1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}//main
	
	//이전마을, 현재마을
	static void dfs(int before, int now) {
		dp[now][0] = 0;
		dp[now][1] = arr[now];
		
		for(int city : adj[now]) {
			if(city == before)continue; //왔던 마을로 다시 탐색 x
			dfs(now,city);
			
			dp[now][0] += Math.max(dp[city][0], dp[city][1]); //현재 마을 채택안하는 경우 
			dp[now][1] += dp[city][0]; //현재 마을 채택하는 경우
		}
	}//dfs
	

}
