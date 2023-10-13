import java.io.*;
import java.util.*;
public class q9466 {
	static int N,s,ans;
	static int[] arr;
	static boolean[] c1,c2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int te=0;te<T;te++) {
			ans=0;
			int N=Integer.parseInt(br.readLine());
			arr=new int[N+1]; c1=new boolean[N+1]; c2=new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
			for(int i=1;i<=N;i++) {
				if(c2[i]) continue;
				dfs(i);
			}
			System.out.println(N-ans);
		}
	}
	static void dfs(int t) {
		c2[t]=true;
		if(!c2[arr[t]]) dfs(arr[t]);
		else if(c2[arr[t]] && !c1[arr[t]]) {
			ans++;
			for(int i=arr[t];i!=t;i=arr[i]) ans++;
		}
		c1[t]=true;
	}
}
