import java.util.*;
import java.io.*;
public class Main {
	static int N,M,max=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] chk;
	static int[][] xx={{0,1},{0,1},{-1,0},{-1,0}},yy={{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		chk=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int t,int sum) {
		if(t==N*M) {
			max=Math.max(max,sum);
			return;
		}
		int dx=t/M,dy=t%M;
		if(!chk[dx][dy]) {
			for(int d=0;d<4;d++) {
				int x1=dx+xx[d][0],y1=dy+yy[d][0],x2=dx+xx[d][1],y2=dy+yy[d][1];
				if(x1<0 || x2<0 || x1>=N || x2>=N || y1<0 || y2<0 || y1>=M || y2>=M || chk[x1][y1] || chk[x2][y2]) continue;
				chk[dx][dy]=true; chk[x1][y1]=true; chk[x2][y2]=true;
				dfs(t+1,sum+(map[dx][dy]*2)+map[x1][y1]+map[x2][y2]);
				chk[dx][dy]=false; chk[x1][y1]=false; chk[x2][y2]=false;
				
			}
		}
		dfs(t+1,sum);
	}
}
