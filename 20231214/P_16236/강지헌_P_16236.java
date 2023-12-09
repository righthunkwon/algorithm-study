import java.util.*;
import java.io.*;
public class Main {
    static int N,M,max=Integer.MIN_VALUE;
    static int[][] map;
    static int[] xx= {0,1,0,-1}, yy= {-1,0,1,0};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	map=new int[N][N];
    	Queue<Node> Q = new PriorityQueue<>((o1,o2) -> {
    		if(o1.c==o2.c) {
    			if(o1.x==o2.x) return o1.y-o2.y;
    			return o1.x-o2.x;
    		}
    		return o1.c-o2.c;
    	});
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					Q.add(new Node(i,j,0));
					map[i][j]=0;
				}
			}
		}
		int size=2,cnt=0,ans=0;
		boolean[][] chk = new boolean[N][N];
		while(!Q.isEmpty()) {
			Node t=Q.poll();
			if(map[t.x][t.y]>0 && map[t.x][t.y]<size) {
				cnt++;
				map[t.x][t.y]=0;
				if(cnt==size) {
					size++;
					cnt=0;
				}
				ans+=t.c;
				t.c=0;
				Q.clear();
				chk=new boolean[N][N];
			}
			for(int i=0;i<4;i++) {
				int dx=t.x+xx[i],dy=t.y+yy[i];
				if(dx<0 || dx>=N || dy<0 || dy>=N || map[dx][dy]>size || chk[dx][dy]) continue;
				chk[dx][dy]=true;
				Q.add(new Node(dx,dy,t.c+1));
			}
		}
		System.out.println(ans);
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
