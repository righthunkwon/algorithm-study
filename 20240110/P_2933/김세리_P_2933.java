package _20240110;

import java.util.*;
import java.io.*;

public class _2933_미네랄 {
	static int R,C,N;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] clusters;
	
	static class Node{
		int r,c;
		
		Node(int r, int c){
			this.r =r;
			this.c =c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			int dir=1; //왼->오
			if(i%2==1) dir=2; //오->왼
			
			destructMineral(a,dir);
			cluster();
			
		}
		
		for(int i=0;i<R;i++) {
			System.out.println(map[i]);
		}
		
	}//main
	
	static void destructMineral(int a, int dir) {
		if(dir==1) {// 왼->오
			for(int i=0;i<C;i++) {
				if(map[R-a][i]=='x') {
					map[R-a][i]='.';
					return;
				}
			}
		}else {// 오->왼
			for(int i=C-1;i>=0;i--) {
				if(map[R-a][i]=='x') {
					map[R-a][i]='.';
					return;
				}
			}
		}
	}//destructMineral
	
	static void cluster() {
		// 떨어질 덩어리가 있는지 살피고
		// 떨어질 덩어리를 떨어뜨린다
		
		// 먼저 덩어리의 개수를 센다(덩어리가 0이 아니면 떨어질게 있는거임)
		clusters = new int[R][C];
		
		// clusters 배열이 기본적으로 0으로 채워져 있으니까 cnt=1부터 시작해서 덩어리를 표시해준다
		int cnt=1;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='x' && clusters[i][j]==0) {
					if(foundCluster(i,j,cnt)) {
						return;
					}
					cnt++;
				}
			}
		}
		
		
	}//cluster
	static boolean foundCluster(int i, int j, int cnt) {
		
		int lowest = -1;
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> arr = new ArrayList<>();
		
		q.add(new Node(i,j));
		clusters[i][j]=cnt;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			lowest = Math.max(lowest, curr.r);
			
			for(int d=0;d<4;d++) {
				int nr = curr.r + dx[d];
				int nc = curr.c + dy[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(clusters[nr][nc]==0 && map[nr][nc]=='x') {
					clusters[nr][nc]=cnt;
					q.add(new Node(nr,nc));
				}
			}
			arr.add(curr);
		}//q
		
		//공중에 떠있다면
		if(lowest != R-1) {
			moveCluster(arr);
			return true;
		}
		return false;
		
	}//foundCluster
	static void moveCluster(ArrayList<Node> arr) {
		int move =1;
		for(Node node : arr) {
			map[node.r][node.c] ='.';
		}
		out: while(true) {
			for(Node node : arr) {
				if(node.r +move ==R || map[node.r+move][node.c]=='x') {
					move--;
					break out;
				}
			}
			move++;
		}
		for(Node node : arr) {
			map[node.r+move][node.c]='x';
		}
	}//moveCluster

}
