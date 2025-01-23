import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int dp[]=new int[N+1];
		ArrayList<Integer> p[]=new ArrayList[N + 1];
		for(int i=1;i<=N;i++) {
			p[i]=new ArrayList<Integer>();
			p[i].add(0);
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			p[b].add(a);
		}
		for(int i=1;i<=N;i++) {
			for(int j:p[i])
				dp[i]=Math.max(dp[i],dp[j]+1);
			System.out.print(dp[i]+" ");
		}
    }
}
