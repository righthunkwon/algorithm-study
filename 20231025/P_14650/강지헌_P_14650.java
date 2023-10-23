import java.io.*;
import java.util.*;

public class Main {
	static int N,ans=0;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		dfs(0,0);
		System.out.println(ans);
	}
	
	public static void dfs(int t,int l) {
		if(l==N) {
			if(t%3==0) ans++;
			return;
		}
		for(int i=0;i<3;i++) {
			if(t==0 && i==0) continue;
			dfs(t*10+i,l+1);
		}
	}
}
