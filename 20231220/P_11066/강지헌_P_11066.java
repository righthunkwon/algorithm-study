import java.io.*;
import java.util.*;
public class Main {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int test=0;test<T;test++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] arr=new int[N+1];
			int[][] dp=new int[N+1][N+1];
			arr[1]=Integer.parseInt(st.nextToken());
			for(int i=2;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken())+arr[i-1];
			for(int i=1;i<N;i++) {
				for(int j=1;j+i<=N;j++) {
					int t=j+i;
					dp[j][t]=Integer.MAX_VALUE;
					for(int k=j;k<t;k++) {
						dp[j][t]=Math.min(dp[j][t], dp[j][k]+dp[k+1][t]+arr[t]-arr[j-1]);
					}
				}
			}
			System.out.println(dp[1][N]);
		}
	}
}
