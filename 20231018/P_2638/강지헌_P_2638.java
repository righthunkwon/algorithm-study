import java.util.*;
import java.io.*;
public class q2638 {
	static int N,M,ans=0;
	static int[] xx= {-1,0,1,0},yy= {0,1,0,-1};
	static int[][] map,m2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M]; m2=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(check()) {
			for(int i=0;i<N;i++) m2[i]=map[i].clone();
			dfs(0,0);
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(map[i][j]!=1) continue;
					int t=0;
					for(int k=0;k<4;k++) if(m2[i+xx[k]][j+yy[k]]==-1) t++;
					if(t>=2) map[i][j]=0;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
	static boolean check() {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) if(map[i][j]==1) return true;
		return false;
	}
	static void dfs(int x, int y) {
		m2[x][y]=-1;
		for(int i=0;i<4;i++) {
			int dx=x+xx[i],dy=y+yy[i];
			if(dx<0 || dx>=N || dy<0 || dy>=M || m2[dx][dy]!=0) continue;
			dfs(dx,dy);
		}
	}
}
