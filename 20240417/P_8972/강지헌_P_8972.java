import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] xx = {0,1,1,1,0,0,0,-1,-1,-1}, yy = {0,-1,0,1,-1,0,1,-1,0,1};
		int x=0,y=0;
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j]=='I') { x=i; y=j; map[i][j]='.';}
			}
		}
		char[] mo = br.readLine().toCharArray();
		int ans=0;
		for(char t : mo) {
			ans++;
			int dir = t-'0';
			x+=xx[dir]; y+=yy[dir];
			if(map[x][y]=='R') {
				System.out.println("kraj "+ ans);
				return;
			}
			int[][] chk = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='R') {
						int dx=i<x?i+1:(i==x?i:i-1), dy=j<y?j+1:(j==y?j:j-1);
						chk[dx][dy]++;
						map[i][j]='.';
					}
				}
			}
			if(chk[x][y]>=1) {
				System.out.println("kraj "+ ans);
				return;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(chk[i][j]==1) {
						map[i][j]='R';
					}
				}
			}
		}
		map[x][y]='I';
		for(int i=0;i<N;i++) {
			System.out.println(map[i]);
		}
	}
}
