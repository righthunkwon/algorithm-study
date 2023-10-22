package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ_Q2573_빙산 {

	
	static int N,M;
	static int[][]arr;
	static boolean[][]visit;
	static Queue<Integer> qx, qy;
	static Stack<Integer> sx, sy, smelt;
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,1,-1};
	static int BingSanCnt;
	static int yearCnt; //몇년 지났는지
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		qx = new LinkedList<>(); //빙산 덩어리 수 카운트를 위한 큐
		qy = new LinkedList<>();
		sx = new Stack<>(); //녹일 빙산의 좌표 저장을 위한 스택
		sy = new Stack<>();
		smelt = new Stack<>(); //녹일 빙산의 주변 0의 갯수(녹을 양)을 저장할 스택
		
		yearCnt = 0; //몇년이 지났는지 카운트할 변수
		
		
		while(true) {
			
			visit = new boolean[N][M]; //방문배열 초기화
			BingSanCnt = 0; //빙산 덩어리 갯수 초기화
			
			for(int i =0; i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]>0 && visit[i][j]!=true) { //방문한적 없는 빙산이면
						countBingSan(i,j); //카운트해줌
					}
				}
			}//for
			
			if(BingSanCnt==1) { //빙산 덩어리 1개일 경우 녹이기 진행
				meltBingSan();
				
			}else if(BingSanCnt ==0) { //빙산 덩어리 아예 없으면 0을 출력하고 끝내기
				System.out.println(0);
				break;
				
			}else if(BingSanCnt >1) { //빙산 덩어리가 2개 이상으로 쪼개지면 몇년 지난건지 출력
				System.out.println(yearCnt);
				break;
			}
			
		}//while
		
	}//main
	
	public static void meltBingSan () {
		int cnt = 0; //녹일 빙산의 갯수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 일단 1인지 확인해서 빙산이면, 주변에 0이 있는지 확인하고 stack에 넣어줌
				if (arr[i][j] > 0 && (arr[i+1][j]==0 || arr[i-1][j]==0 || arr[i][j+1]==0 || arr[i][j-1]==0)) {
					int meltamount = 0;
					sx.add(i); //녹일 빙산 위치정보 스택에 넣어줌
					sy.add(j);
					for(int k=0;k<4;k++) {
						int nx= i+dx[k];
						int ny= j+dy[k];
						if(arr[nx][ny]==0) {
							meltamount++; //주변 0의 갯수만큼 녹일 양 더해줌
						}
					}
					smelt.add(meltamount); //해당 빙산이 얼마나 녹을지 스택에 넣음
					cnt++;//녹일 빙산 수 +1
				}
			}
		}
		
		if(cnt!=0) { //녹일 빙산이 있으면
			while (!sx.isEmpty() || !sy.isEmpty()) {
				int x = sx.pop(); //녹일 빙산 좌표 꺼내고
				int y = sy.pop();
				int melt = smelt.pop(); //해당 좌표의 빙산 녹일 양도 꺼내줌
			
				arr[x][y] -= melt; //녹일 빙산 주변0갯수만큼 녹여준다
				if(arr[x][y]<0) {
					arr[x][y]=0; //0보다 작아지면 같으면 0으로 만듬
				} 
				
			}
		}
		yearCnt++; //1년이 지난것..
	}//meltBingSan
	
	
	//bfs로 빙산 갯수 세자
	public static void countBingSan (int nx, int ny) {
		
		qx.add(nx); //빙산 발견했으면 큐에 좌표 넣어줌
		qy.add(ny); 
		visit[nx][ny]=true; //방문처리
		
		while (!qx.isEmpty() || !qy.isEmpty()) {
			nx = qx.poll();
			ny = qy.poll();
			
			for (int i = 0; i < 4; i++) { // 사방탐색
				int newx = nx + dx[i];
				int newy = ny + dy[i];
				//범위 내에 있고 방문한적 없는 빙산이면 큐에 좌표 넣어줌
				if (newx >= 0 && newy >= 0 && newx < N && newy < M && arr[newx][newy] > 0 && !visit[newx][newy]) {
					visit[newx][newy]=true;
					qx.add(newx);
					qy.add(newy);
				}
			}
		} // while
		
		BingSanCnt++; //bfs로 한 덩어리 다 돌았으면 빙산 덩어리 갯수 +1
		
	}//countBingSan
	
}
