import java.util.*;
import java.io.*;
public class q1987 {
	static int N,M,ans=0;
	static int[] xx= {-1,0,1,0},yy= {0,1,0,-1};
	static char[][] map;
	static boolean[] chk=new boolean[26];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		for(int i=0;i<N;i++) map[i]=br.readLine().toCharArray();
		dfs(0,0,1);
		System.out.println(ans);
	}
	static void dfs(int x, int y, int k) {
		chk[map[x][y]-'A']=true;
		ans=Math.max(ans,k);
		for(int i=0;i<4;i++) {
			int dx=x+xx[i],dy=y+yy[i];
			if(dx<0 || dx>=N || dy<0 || dy>=M || chk[map[dx][dy]-'A']) continue;
			dfs(dx,dy,k+1);
			chk[map[dx][dy]-'A']=false;
		}
	}
}
