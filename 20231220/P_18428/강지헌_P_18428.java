import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][] xy={{1,0},{0,1},{0,-1},{-1,0}};
	static ArrayList<int[]> T;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(in.readLine());
		StringTokenizer st;
		map=new char[N][N];
		T=new ArrayList<>();
		for(int i=0;i<N;i++){
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				map[i][j]=st.nextToken().charAt(0);
				if(map[i][j]=='T') T.add(new int[]{i,j});
			}
		}
		dfs(0,0,0);
		System.out.println("NO");
	}
	private static void dfs(int cnt,int x,int y){
		if(cnt==3) {
			if(check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		int dy;
		for(int dx=x;dx<N;dx++) {
			if(dx==x) dy=y+1;
			else dy=0;
			for(;dy<N;dy++) {
				if(map[dx][dy]=='X'){
					map[dx][dy]='O';
					dfs(cnt+1,dx,dy);
					map[dx][dy]='X';
				}
			}
		}
	}
	private static boolean check(){
		for(int[] i:T) {
			for(int[] j:xy) {
				int dx=i[0],dy=i[1];
				while(true){
					dx+=j[0]; dy+=j[1];
					if(dx<0 || dx>=N || dy<0 || dy>=N) break;
					if(map[dx][dy]=='S') return false;
					else if(map[dx][dy]=='O') break;
				}
			}
		}
		return true;
	}
}
