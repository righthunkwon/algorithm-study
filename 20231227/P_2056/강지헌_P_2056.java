import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int N=Integer.parseInt(br.readLine());
		int[] dy=new int[N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			dy[i]=a;
			for(int j=0;j<b;j++) {
				int t=Integer.parseInt(st.nextToken());
				dy[i]=Math.max(dy[i],dy[t]+a);
			}
			ans=Math.max(ans,dy[i]);
		}
		System.out.println(ans);
	}
}
