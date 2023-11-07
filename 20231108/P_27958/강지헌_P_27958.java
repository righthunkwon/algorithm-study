import java.io.*;
import java.util.*;

public class Main {
	static int[][] map,score;
	static int[] arr;
	static int[] xx= {-1,0,1,0}, yy= {0,1,0,-1};
	static int N,M,t,ans;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map = new int[N][N];
		score = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j]=Integer.parseInt(st.nextToken());
			score[i]=map[i].clone();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[M];
		for(int i=0;i<M;i++) arr[i]=Integer.parseInt(st.nextToken());
		dfs(0,0,map);
		System.out.println(ans);
	}
	private static void dfs(int c, int s, int[][] a) {
		int[][] sc=new int[N][N];
		
		if(c==M) {
			ans=Math.max(ans,s);
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sc[j]=score[j].clone();
			}
			int[][] tmp=chk(i,a,arr[c]);
			dfs(c+1,s+t,tmp);
			for(int j=0;j<N;j++) {
				score[j]=sc[j].clone();
			}
		}
	}
	private static int[][] chk(int x, int[][] a,int pow) {
		t=0;
		int[][] tmp=new int[N][N];
		
		for(int i=0;i<N;i++) tmp[i]=a[i].clone();
		for(int i=0;i<N;i++) {
			if(tmp[x][i]!=0) {
				if(tmp[x][i]>=10) {t=score[x][i]; tmp[x][i]=0;}
				else if(tmp[x][i]>pow) tmp[x][i]-=pow;
				else {
					t=score[x][i];
					for(int j=0;j<4;j++) {
						int dx=x+xx[j],dy=i+yy[j];
						if(dx<0 || dx>=N || dy<0 || dy>=N || score[x][i]/4<tmp[dx][dy]) continue;
						tmp[dx][dy]=score[x][i]/4;
						score[dx][dy]=score[x][i]/4;
					}
					tmp[x][i]=0;
				}
				break;
			}
		}
		return tmp;
	}
	
}
