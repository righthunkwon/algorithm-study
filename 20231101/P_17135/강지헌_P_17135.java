import java.io.*;
import java.util.*;
public class Main {
	static int N,M,D,ans=0;
	static int[] bow=new int[3];
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(ans);
	}

	public static void dfs(int c, int t) {
		if(c==3) {
			ans=Math.max(ans,go());
			return;
		}
		for(int i=t;i<M;i++) {
			bow[c]=i;
			dfs(c+1,i+1);
		}
	}
	
	public static int go() {
		int t=0;
		int[][] arr=new int[N][M];
		for(int i=N;i>0;i--) {
			for(int b:bow) {
				for(int d=1;d<=D;d++) {
					int cnt=kill(arr,d,i,b);
					if(cnt<0) continue;
					t+=cnt;
					break;
				}
			}
		}
		return t;
	}
	
	public static int kill(int[][] arr, int d, int l, int b) {
		int i;
		for(int j=b-d;j<=b+d;j++) {
			i=l-(d-Math.abs(j-b));
			if(i<0 || i>=l || j<0 || j>=M || map[i][j]==0) continue;
			if(arr[i][j]==0) {
				arr[i][j]=l;
				return 1;
			} 
			else if(arr[i][j]==l) return 0;
		}
		return -1;
	}
}
