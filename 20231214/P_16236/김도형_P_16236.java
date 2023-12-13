package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q16236_아기_상어 {
	static int[]dx= {-1,0,0,1};
	static int[]dy= {0,-1,1,0};
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
				if(map[i][j]==9) {
					nx=i;
					ny=j;
					map[i][j]=0; //0으로 바꿔줘야됨 @@@@@@@@@@@@@이거 떄문에 틀렸었다!
				}//9나오면 그때의 i,j 를 현위치 nx, ny로 설정
			}
		}//입력끝
		
		//bfs를 통해 먹을 수 있는 먹이 탐색
		//(자신보다 작거나 같은 곳으로만 이동하다가 자신보다 작은 곳 나오면 먹는다)
		totaltime = 0; //총 먹는 시간 초기화(정답)
		size = 2; //아기상어 크기 초기화
		cnt =0; //현재 먹은 물고기 수 초기화
		while(true) {
			bfs(nx,ny);
			if(flag==false)break; //먹을 물고기 없으면 break
		}
		System.out.println(totaltime);
	}//main
	
	//아기상어의 현재 위치 x y / 아기상어의 현재 크기 size / 현 사이즈에서 먹은 먹이 수 cnt
	public static void bfs(int x,int y) { 
		//상,좌,우,하 순으로 탐색하다가 먹을 수 있는거 나오면 break해준다!
		boolean [][]visit = new boolean[N][N]; //방문확인용 배열
		boolean [][]eatable = new boolean[N][N]; //먹을 수 있는 먹이 체크용
		Queue<Integer>qx=new LinkedList<>(); //x좌표 넣을 큐
		Queue<Integer>qy=new LinkedList<>(); //y좌표 넣을 큐
		Queue<Integer>qd=new LinkedList<>(); //그 좌표의 깊이 저장할 큐(해당 좌표까지 가는데 걸린 시간)
		visit[x][y]=true;
		qx.add(x);
		qy.add(y);
		qd.add(0);
		int minDis = Integer.MAX_VALUE; //가장 가까운 먹이까지의 거리 초기화
		flag = false; //일단 false로 바꿔주고 물고기 먹으면 true로..
		
		i:while(!qx.isEmpty() || !qy.isEmpty()) {
			int nowx=qx.poll(); //현재 x좌표
			int nowy=qy.poll(); //현재 y좌표
			int nowd=qd.poll(); //현재 거리
			for(int i=0;i<4;i++) {
				int nextx=nowx+dx[i];
				int nexty=nowy+dy[i];
				int nextd=nowd+1; //깊이(걸린시간)+1
				//맵 밖으로 벗어나거나 아기상어보다 큰 물고기면 pass, 방문했던곳이어도 pass
				if(nextx<0 || nexty<0 || nextx>=N || nexty>=N ||map[nextx][nexty]>size ||visit[nextx][nexty])continue;
				if(nextd>minDis)continue; //거리가 더 가까운 먹이가 있었으면 더 볼필요 없따
				if(map[nextx][nexty]!=0 && map[nextx][nexty]<size) { //0이아니고 작으면 '먹을 수 있는 물고기'다
					minDis=nextd;
					eatable[nextx][nexty]=true; //먹을 수 있다고 표시
					visit[nextx][nexty]=true;
				}else { //아기상어와 크기 같은 물고기면 더 이동
					qx.add(nextx);
					qy.add(nexty);
					qd.add(nextd);
					visit[nextx][nexty]=true;
					flag=false;
				}
			}
		}//while
		
		//먹을 수 있는거중에 위쪽 ,왼쪽 우선 선택..
		i:for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(eatable[i][j]) { //먹을 수 있는 먹이 찾으면
					cnt++; //먹은 물고기 수 +1
					map[i][j]=0; //먹혔으니까 0으로
					nx=i;
					ny=j;
					if(cnt==size) {//먹은 물고기 수가 자기 사이즈와 같으면
						size++; //사이즈 늘려주고
						cnt=0;//현재 사이즈에서 먹은 갯수 0으로
					}
					totaltime+=minDis; //이번에 먹기까지 걸린시간을 총 시간에 더해주기
					flag=true; //먹었으니까 flag 바꿔주기
					break i;
				}
			}
		}
	}
}//class


/*
 * ★★★★그냥 bfs로 가장 먼저 찾은 먹을 수 있는 물고기 먹게 했을 때 틀린 이유!!★★★★★
 * 
 * 위 -> 왼 -> 오 -> 아 순서로 탐색할 때 거리가 1 또는 2인 위치의 탐색 순서는 아래와 같다.

       5
    6  1  7
 8  2  0  3  12
    9  4  10
       11
위쪽에 있는 물고기를 우선적으로 탐색해야 하므로 9, 10, 11번보다 12번을 먼저 탐색해야 올바른 답을 출력합니다. (올바른 순서는 5 -> 6 -> 7 -> 8 -> 12 -> 9 -> 10 -> 11입니다.)

 *
 */
