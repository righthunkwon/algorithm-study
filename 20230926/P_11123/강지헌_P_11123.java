import java.io.*;
import java.util.*;
public class q11123 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int te=1;te<=T;te++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			int[] xx={1,0,-1,0}, yy={0,1,0,-1};
			int ans=0;
			for(int i=0;i<N;i++) map[i]=br.readLine().toCharArray();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='#') { //#일때 다 .으로 지우기
						ans++; //정답 하나씩 더해주기
						Queue<Node> q = new LinkedList<>();
						q.add(new Node(i,j));
						map[i][j]='.';
						while(!q.isEmpty()) {
							Node t=q.poll();
							for(int k=0;k<4;k++) {
								if(t.x+xx[k]<0 || t.x+xx[k]>=N || t.y+yy[k]<0 || t.y+yy[k]>=M || map[t.x+xx[k]][t.y+yy[k]]!='#') continue;
								map[t.x+xx[k]][t.y+yy[k]]='.';
								q.add(new Node(t.x+xx[k],t.y+yy[k]));
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
class Node {
	int x,y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
