import java.io.*;
import java.util.*;

public class Main {
	static int[][] chk,f;
	static char[][] arr;
	static int[] xx= {-1,0,1,0}, yy= {0,1,0,-1};
	static int N,M,ans;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		chk = new int[N][M]; f = new int[N][M];
		for(int i=0;i<N;i++) arr[i]=br.readLine().toCharArray();
		dfs(0,0,0);
		System.out.println(ans);
	}
	static void dfs(int x, int y, int c) {
		f[x][y]=c;
		if(arr[x][y]=='H') {
			ans=Math.max(ans,c);
			return;
		}
		for(int i=0;i<4;i++) {
			int dx=x+xx[i]*(arr[x][y]-'0'),dy=y+yy[i]*(arr[x][y]-'0');
			if(dx<0 || dx>=N || dy<0 || dy>=M) {
				ans=Math.max(ans,c+1);
				continue;
			}
			if(f[dx][dy]>c) continue;
			if(chk[dx][dy]!=0) {
				System.out.println(-1);
				System.exit(0);
			}
			chk[dx][dy]=c;
			dfs(dx,dy,c+1);
			chk[dx][dy]=0;
		}
	}
	
}
class Node {
	int x,c;
	Node(int x,int c) {
		this.x=x;
		this.c=c;
	}
}
