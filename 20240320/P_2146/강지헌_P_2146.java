import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] chk = new boolean[N][N];
		int[] xx={-1,0,1,0}, yy={0,1,0,-1};
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1 && !chk[i][j]) {
					Queue<Node> Q = new LinkedList<>(),Q2 = new LinkedList<>();
					boolean[][] c2 = new boolean[N][N];
					chk[i][j]=true;
					c2[i][j]=true;
					Q.add(new Node(i,j,0));
					while(!Q.isEmpty()) {
						Node t = Q.poll();
						for(int k=0;k<4;k++) {
							int dx=t.x+xx[k],dy=t.y+yy[k];
							if(dx<0 || dx>=N || dy<0 || dy>=N || arr[dx][dy]==0 || chk[dx][dy]) continue;
							chk[dx][dy]=true;
							c2[dx][dy]=true;
							Q.add(new Node(dx,dy,0));
						}
						Q2.add(t);
					}
w:					while(!Q2.isEmpty()) {
						Node t = Q2.poll();
						for(int k=0;k<4;k++) {
							int dx=t.x+xx[k],dy=t.y+yy[k];
							if(dx<0 || dx>=N || dy<0 || dy>=N || c2[dx][dy]) continue;
							if(arr[dx][dy]==1) {
								ans=Math.min(t.t,ans);
								break w;
							}
							c2[dx][dy]=true;
							Q2.add(new Node(dx,dy,t.t+1));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
class Node {
	int x,y,t;
	Node(int x, int y, int t) {
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
