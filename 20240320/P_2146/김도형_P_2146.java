import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static boolean [][]visit;
	static int [][]map;
	static int num,length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		num=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visit[i][j])bfs(i,j);
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println();
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
		
		length = 1000;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0)bridge(i,j,map[i][j]);
			}
		}
		
		System.out.println(length-1);
		
		
	}//main
	
	//대륙 번호붙이기용 bfs
	public static void bfs(int x,int y) {
		Queue<Integer>qx = new LinkedList<>();
		Queue<Integer>qy = new LinkedList<>();
			qx.add(x);
			qy.add(y);
			visit[x][y]=true;
			map[x][y]=num;
		
		while(!qx.isEmpty()||!qy.isEmpty()) {
			int nx = qx.poll();
			int ny = qy.poll();
			for(int i=0;i<4;i++) {
				int newx = nx+dx[i];
				int newy = ny+dy[i];
				if(newx<0||newy<0||newx>=N||newy>=N)continue;
				if(visit[newx][newy])continue;
				if(map[newx][newy]==1) {
				visit[newx][newy]=true;
				map[newx][newy]=num;
				qx.add(newx);
				qy.add(newy);
				}
			}
		}
		num++;
	}//bfs
	
	//x,y => 좌표  z =>대륙 번호
	public static void bridge(int x,int y,int z) {
		Queue<Integer>qx = new LinkedList<>();
		Queue<Integer>qy = new LinkedList<>();
		Queue<Integer>qd = new LinkedList<>(); //다리 길이
		visit=new boolean[N][N];
		
		qx.add(x);
		qy.add(y);
		qd.add(0);
		visit[x][y]=true;
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			int nx = qx.poll();
			int ny = qy.poll();
			int nd = qd.poll();
			int newd = nd+1;
			if(newd>=length)continue;
			for(int i=0;i<4;i++) {
				int newx = nx+dx[i];
				int newy = ny+dy[i];
				if(newx<0||newy<0||newx>=N||newy>=N)continue;
				if(visit[newx][newy])continue;
				if(map[newx][newy]==0) {
				visit[newx][newy]=true;
				qx.add(newx);
				qy.add(newy);
				qd.add(newd);
				}else if(map[newx][newy]!=z) { //다른 대륙 도착
					length = Math.min(length, newd);
				}else continue;
			}
		}
		
		//다른 대륙 도착하면 길이 갱신하고 넘어가기
		
		
	}
	
	
}//class
