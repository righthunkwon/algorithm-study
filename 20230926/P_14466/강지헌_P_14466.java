import java.io.*;
import java.util.*;

public class q14466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Node>[][] B = new ArrayList[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				B[i][j]=new ArrayList<>();
			}
		}
		int R = Integer.parseInt(st.nextToken()); //이 두놈들 때문에 한시간반동안 고민함
		int M = Integer.parseInt(st.nextToken()); //개같은 놈들
		for(int i=0;i<M;i++) {
			st =new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			B[a][b].add(new Node(c,d)); //배열에 좌표 저장
			B[c][d].add(new Node(a,b));
		}
		List<Node> C = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			C.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); //C에 소 좌표 저장
		}
		int cnt=0;
		int[] xx={1,0,-1,0},yy={0,1,0,-1};
		int[][] map=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j]==0) { //단지번호붙이기처럼 맵을 채웁니다.
					cnt++;
					Queue<Node> Q = new LinkedList<>();
					Q.add(new Node(i,j));
					map[i][j]=cnt;
					while(!Q.isEmpty()) {
						Node t = Q.poll();
nn:						for(int k=0;k<4;k++) {
							int dx=t.x+xx[k],dy=t.y+yy[k];
							if(dx<=0 || dx>N || dy<=0 || dy>N || map[dx][dy]!=0) continue;
							for(Node l:B[t.x][t.y]) if(l.x==dx && l.y==dy) continue nn;
							map[dx][dy]=cnt;
							Q.add(new Node(dx,dy));
						}
					}
				}
			}
		}
		int ans=0;
		for(int i=0;i<R;i++) {
			for(int j=i+1;j<R;j++) {
				if(map[C.get(i).x][C.get(i).y]!=map[C.get(j).x][C.get(j).y]) ans++; //다른 숫자가 있으면 구간이 나누어져있다 = 길을 건너야한다.
			}
		}
		System.out.println(ans);
	}
}
class Node {
	int x,y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
