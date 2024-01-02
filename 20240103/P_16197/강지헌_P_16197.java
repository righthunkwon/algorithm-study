import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] xy={{-1,0},{1,0},{0,-1},{0,1}};
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] map=new char[N][M];
		Queue<Node> Q=new LinkedList<Node>();
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<M;j++) if(map[i][j]=='o') Q.add(new Node(i,j,0));
		}
		while(!Q.isEmpty()) {
			Node C1=Q.poll();
			Node C2=Q.poll();
			if(C1.t>=10) {
				System.out.println(-1);
				return;
			}
			for(int d=0;d<4;d++) {
				boolean f1=false,f2=false;
				int x1=C1.x+xy[d][0],y1=C1.y+xy[d][1],x2=C2.x+xy[d][0],y2=C2.y+xy[d][1];
				if(x1>=N || x1<0 || y1>=M || y1<0) f1=true;
				if(x2>=N || x2<0 || y2>=M || y2<0) f2=true;
				
				if(f1 && f2) continue;
				if(f1 || f2) {
					System.out.println(C1.t+1);
					return;
				}
				if(map[x1][y1]=='#' && map[x2][y2]=='#') continue;
				if(map[x1][y1]=='#') { x1=C1.x; y1=C1.y; }
				if(map[x2][y2]=='#') { x2=C2.x; y2=C2.y; }
				Q.add(new Node(x1,y1,C1.t+1));
				Q.add(new Node(x2,y2,C1.t+1));
			}
		}
		System.out.println(-1);
	}
}
class Node {
	int x,y,t;
	Node(int x,int y,int t){
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
