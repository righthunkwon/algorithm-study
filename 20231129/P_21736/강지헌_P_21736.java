import java.io.*;
import java.util.*;
public class Main {
	static int N,M,x,y,dy[]= {-1,1,0,0},dx[]= {0,0,-1,1},ans;
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit=new boolean[N][M];
		for (int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
			for (int j=0;j<M;j++) {
				if(map[i][j]=='I') {x=i; y=j;}
			}
		}
		dfs(x,y);
		System.out.println(ans==0?"TT":ans);
	}
	private static void dfs(int x,int y) {
		visit[x][y]=true;
		for (int i=0;i<4;i++) {
			int xx=x+dx[i];
			int yy=y+dy[i];
			if(xx < 0 || yy < 0 || xx >= N || yy >= M || visit[xx][yy] || map[xx][yy]=='X') continue;
			if(map[xx][yy]=='P')  ans++;
			dfs(xx,yy);
		}
	}
}
