import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] chk;
	static int N;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		chk = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println("Hing");
	}
	private static void dfs(int x,int y) {
		chk[x][y]=true;
		if(x==N-1 && y==N-1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		if(map[x][y]==0) return;
		if(x+map[x][y]<=N-1 && !chk[x+map[x][y]][y]) dfs(x+map[x][y],y);
		if(y+map[x][y]<=N-1 && !chk[x][y+map[x][y]]) dfs(x,y+map[x][y]);
	}
}
