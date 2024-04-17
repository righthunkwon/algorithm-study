import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int T=1;;T++) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int[][] arr = new int[N][N];
			int[][] chk = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					chk[i][j]=Integer.MAX_VALUE;
				}
			}
			int[] xx={-1,0,1,0},yy={0,1,0,-1};

			PriorityQueue<Node> Q =new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
			Q.add(new Node(0,0,arr[0][0]));
			chk[0][0]=arr[0][0];
			while(!Q.isEmpty()) {
				Node t=Q.poll();
				if(t.x==N-1 && t.y==N-1) {
					System.out.println("Problem "+T+": "+t.c);
					break;
				}
				for(int i=0;i<4;i++) {
					int dx=t.x+xx[i],dy=t.y+yy[i];
					if(dx<0 || dx>=N || dy<0 || dy>=N || chk[dx][dy]<=t.c+arr[dx][dy]) continue;
					Q.add(new Node(dx,dy,t.c+arr[dx][dy]));
					chk[dx][dy]=t.c+arr[dx][dy];
				}
			}
		}
	}
}
class Node {
	int x,y,c;
	Node(int x,int y,int c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
}
