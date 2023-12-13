package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q16236_아기_상어 {
	static int[]dx= {-1,0,0,1};
	static int[]dy= {0,0,0,1};
	static int N;
	static int[][]map;
	static int nx,ny; //아기상어 현위치
	static int totaltime; //물고기 잡아먹는 총 시간
	static int size; //상어 사이즈
	static int cnt; //현재 사이즈에서 먹은 물고기 수
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //공간 크기 N
		map = new int[N][N]; //공간 정보
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					nx=i;
					ny=j;
				}//9나오면 그때의 i,j 를 현위치 nx, ny로 설정
			}
		}//입력끝
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}//출력확인용
		
		System.out.println("현위치:"+nx+","+ny);
		//bfs를 통해 먹을 수 있는 먹이 탐색
		//(자신보다 작거나 같은 곳으로만 이동하다가 자신보다 작은 곳 나오면 먹는다)
		
		totaltime = 0; //총 먹는 시간 초기화(정답)
		size = 2; //아기상어 크기 초기화
		cnt =0; //현재 먹은 물고기 수 초기화
		
		while(true) {
			
			bfs(nx,ny);
			if(!flag)break;
			
		}
		System.out.println(totaltime);
	
	}//main
	//아기상어의 현재 위치 x y / 아기상어의 현재 크기 size / 현 사이즈에서 먹은 먹이 수 cnt
	public static void bfs(int x,int y) { 
		//상,좌,우,하 순으로 탐색하다가 먹을 수 있는거 나오면 break해준다!
		boolean [][]visit = new boolean[N][N];
		int time=0; //이번 먹이 먹는 턴에 걸린 시간 초기화
		Queue<Integer>qx=new LinkedList<>(); //x좌표 넣을 큐
		Queue<Integer>qy=new LinkedList<>(); //y좌표 넣을 큐
		Queue<Integer>qd=new LinkedList<>(); //그 좌표의 깊이 저장할 큐(해당 좌표까지 가는데 걸린 시간)
		visit[x][y]=true;
		qx.add(x);
		qy.add(y);
		qd.add(0); 
		flag = false;
		
		i:while(!qx.isEmpty() || !qy.isEmpty()) {
			int nowx=qx.poll();
			int nowy=qy.poll();
			int nowd=qd.poll();
			for(int i=0;i<4;i++) {
				int nextx=nowx+dx[i];
				int nexty=nowy+dy[i];
				int nextd=nowd+1;
				//맵 밖으로 벗어나거나 아기상어보다 큰 물고기면 pass, 방문했던곳이어도 pass
				if(nextx<0 || nexty<0 || nextx>=N || nexty>=N ||map[nextx][nexty]>size ||visit[nextx][nexty])continue;
				
				if(map[nextx][nexty]<size) { //작으면 먹어버리기
					cnt++; //먹은 물고기 수 +1
					map[nextx][nexty]=0; //먹혔으니까 0으로
					nx=nextx;
					ny=nexty;
					if(cnt==size) { //먹은 물고기 수가 자기 사이즈와 같으면
						size++;
						cnt=0;
					}
					totaltime+=nextd; //총 시간 더해주기
					flag=true; //먹었으니까 flag 바꿔주기
					break i;
				}else { //아기상어와 크기 같은 물고기면 더 이동
					qx.add(nextx);
					qy.add(nexty);
					qd.add(nextd);
					visit[nextx][nexty]=true;
				}
			}
		}//while

	}
}//class
