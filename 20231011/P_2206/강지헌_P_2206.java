import java.io.*;
import java.util.*;
public class q2206 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		boolean[][][] chk = new boolean[2][N][M];
		for(int i=0;i<N;i++) arr[i]=br.readLine().toCharArray();
		Queue<Node> Q = new LinkedList<>();
		Q.add(new Node(0,0,1,0));
		chk[0][0][0]=true;
		int[] xx= {-1,0,1,0}, yy= {0,1,0,-1};
		while(!Q.isEmpty()) {
			Node t=Q.poll();
			if(t.x==N-1 && t.y==M-1) {
				System.out.println(t.c);
				return;
			}
			for(int i=0;i<4;i++) {
				int dx=t.x+xx[i],dy=t.y+yy[i];
				if(dx<0 || dx>=N || dy<0 || dy>=M || (arr[dx][dy]=='1' && t.w==1) || chk[arr[dx][dy]-'0'+t.w][dx][dy]) continue;
				Q.add(new Node(dx,dy,t.c+1,t.w+arr[dx][dy]-'0'));
				chk[arr[dx][dy]-'0'+t.w][dx][dy]=true;
			}
		}
		System.out.println(-1);
	}
}
class Node {
	int x,y,c,w;
	Node(int x,int y,int c,int w) {
		this.x=x;
		this.y=y;
		this.c=c;
		this.w=w;
	}
}
