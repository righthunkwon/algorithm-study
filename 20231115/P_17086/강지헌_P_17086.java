import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N,M,ans=0;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		List<Node> sh = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) sh.add(new Node(i,j));
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) continue;
				int dis=Integer.MAX_VALUE;
				for(Node t:sh) {
					dis=Math.min(dis, Math.max(Math.abs(t.x-i),Math.abs(t.y-j)));
				}
				ans=Math.max(ans, dis);
			}
		}
		System.out.println(ans);
	}
}
class Node {
	int x, y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
