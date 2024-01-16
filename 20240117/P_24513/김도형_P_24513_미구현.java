package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q24513_좀비_바이러스 {

	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N][M];
		visit = new boolean[N][M];// 방문확인용 배열
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 1번 바이러스 시작지점 저장
					x1 = i;
					y1 = j;
				}
				if (map[i][j] == 2) { // 2번 바이러스 시작지점 저장
					x2 = i;
					y2 = j;
				}
			}
		} // 입력 끝
		Queue<Integer> qx1 = new LinkedList<>();
		Queue<Integer> qy1 = new LinkedList<>();
		Queue<Integer> qd1 = new LinkedList<>();
		
		Queue<Integer> qx2 = new LinkedList<>();
		Queue<Integer> qy2 = new LinkedList<>();
		Queue<Integer> qd2 = new LinkedList<>();

		qx1.add(x1);
		qy1.add(y1);
		qd1.add(0);
		visit[x1][y1]=true;
		qx2.add(x2);
		qy2.add(y2);
		qd2.add(0);
		visit[x2][y2]=true;
		
		//1번 바이러스는 퍼뜨리기 한번 하고나면 +3 해주기!
		while(!qx1.isEmpty()||!qy1.isEmpty()||!qx2.isEmpty()||qy2.isEmpty()) {
			
			int checkd1 = qd1.isEmpty() ? -1 : qd1.peek();
			int checkd2 = qd2.isEmpty() ? -1 : qd2.peek();
	
			
			while(checkd1==checkd2 && checkd1 != -1) { //깊이 동일하다면 1번 바이러스 먼저 싹 퍼뜨리기
				int nowx1=qx1.poll();
				int nowy1=qy1.poll();
				int nowd1=qd1.poll();
				
				map[nowx1][nowy1]+=3;
				
				for(int i=0;i<4;i++) {
					int nextx1=nowx1+dx[i];
					int nexty1=nowy1+dy[i];
					//이미 방문한곳 or 맵 벗어나면 넘어가기
					if(nextx1<0||nextx1>=N||nexty1<0||nexty1>=M||visit[nextx1][nexty1])continue;
					//3번바이러스 감염됐거나 치료제 있는 마을 pass
					if(map[nextx1][nexty1]==3||map[nextx1][nexty1]==-1)continue;
					
					map[nextx1][nexty1]=1;
					visit[nextx1][nexty1]=true;
					qx1.add(nextx1);
					qy1.add(nexty1);
					qd1.add(nowd1+1);
				}
				if(!qd1.isEmpty())checkd1=qd1.peek();
				
			}//while nowd1 = nowd2
			
			while(checkd1 > checkd2 && !qx2.isEmpty() && checkd1 != -1 ) { //깊이 다르면..2번 퍼뜨려
				int nowx2=qx2.poll();
				int nowy2=qy2.poll();
				int nowd2=qd2.poll();
				
				for(int i=0;i<4;i++) {
					int nextx2=nowx2+dx[i];
					int nexty2=nowy2+dy[i];
					//범위 밖 pass
					if(nextx2<0||nextx2>=N||nexty2<0||nexty2>=N)continue;
					if(map[nextx2][nexty2]==1) {
						map[nextx2][nexty2]=3;
						continue;
					}else if(visit[nextx2][nexty2]||map[nextx2][nexty2]==3||map[nextx2][nexty2]==-1)continue;
					
					map[nextx2][nexty2]=2;
					visit[nextx2][nexty2]=true;
					qx2.add(nextx2);
					qy2.add(nexty2);
					qd2.add(nowd2+1);
				}
				if(!qd2.isEmpty())checkd2=qd2.peek();
			}
			
		}//while
		int ans=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0 && map[i][j]!=3)ans++;
			}
		}
		System.out.println(ans);

	}// main
}
