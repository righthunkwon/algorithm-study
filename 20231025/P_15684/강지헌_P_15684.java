import java.io.*;
import java.util.*;

public class Main {
	static int N,M,C;
	static int[][] arr;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[C][N];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		for(int i=0;i<4;i++) dfs(0,0,i);
		System.out.println(-1);
	}
	private static void dfs(int st, int c,int mc) {
		if(c==mc) {
			if(check()) {
				System.out.println(c);
				System.exit(0);
			}
			return;
		}
		for(int i=st;i<C;i++) {
			for(int j=0;j<N-1;j++) {
				int t=arr[i][j]+arr[i][j+1];
				if(j-1>=0) t+=arr[i][j-1];
				if(t==0) {
					arr[i][j]=1;
					dfs(i,c+1,mc);
					arr[i][j]=0;
				}
			}
		}
	}
	static boolean check() {
		for(int i=0;i<N;i++) {
			int t=i;
			for(int j=0;j<C;j++) {
				if(arr[j][t]!=0) t++;
				else if(t-1>=0 && arr[j][t-1]!=0) t--;
			}
			if(t!=i) return false;
		}
		return true;
	}
}
