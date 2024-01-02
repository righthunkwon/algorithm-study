package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q16197_두_동전 {
	static int []dx= {-1,1,0,0};
	static int []dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 세로
		int M = Integer.parseInt(st.nextToken());// 가로
		char[][] map = new char[N][M];
		boolean flag=false;
		int ax=-1;
		int ay=-1; //첫 동전 좌표 초기화
		int bx=-1;
		int by=-1; //두번째 동전 좌표 초기화
		int ans = -1; //정답 초기화
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o'&&!flag) { //첫 동전 찾으면 위치 저장
					ax=i;
					ay=j;
					flag=true;
				}
				if(map[i][j]=='o'&&flag) { //두번째 동전 찾으면 위치 저장
					bx=i;
					by=j;
				}
			}
		}//입력끝

		//두 동전의 좌표 정보 넣을 큐 생성
		Queue<Integer>axq = new LinkedList<>();
		Queue<Integer>ayq = new LinkedList<>();
		Queue<Integer>bxq = new LinkedList<>();
		Queue<Integer>byq = new LinkedList<>();
		Queue<Integer>cntq= new LinkedList<>();//움직인 횟수 저장용 큐
		axq.add(ax);
		ayq.add(ay);
		bxq.add(bx);
		byq.add(by);
		cntq.add(0);
		
		while(!axq.isEmpty()||!ayq.isEmpty()||!bxq.isEmpty()||!byq.isEmpty()||!cntq.isEmpty()) {
			int nax=axq.poll();
			int nay=ayq.poll();
			int nbx=bxq.poll();
			int nby=byq.poll();
			int cnt=cntq.poll();
			
			if(cnt==10)break; //버튼 10번 눌렀으면 out
			
			for(int i=0;i<4;i++) {
				int newax=nax+dx[i];
				int neway=nay+dy[i];
				int newbx=nbx+dx[i];
				int newby=nby+dy[i];
				
				//첫 동전 이동할 위치가 범위 안이고 벽이면 
				if(newax>=0 && neway>=0 && newax<N && neway<M && map[newax][neway]=='#') {
					newax=nax;
					neway=nay; //이동 안하고 그대로 유지..
				}
				//두번째 동전 이동할 위치가 범위 안이고 벽이면 
				if(newbx>=0 && newby>=0 && newbx<N && newby<M && map[newbx][newby]=='#') {
					newbx=nbx;
					newby=nby; //이동 안하고 그대로 유지..
				}
				
				//동전 하나만 떨어지는 경우를 찾아야되니까..
				int fallcoin=0; //떨어지는 동전 수
				if(newax<0||neway<0||newax>=N||neway>=M)fallcoin++;
				if(newbx<0||newby<0||newbx>=N||newby>=M)fallcoin++;
				
				if(fallcoin==1) { //동전 딱 하나만 떨어지는 경우
					System.out.println(cnt+1); //정답 출력하고 끝내기
					return;
				}else if(fallcoin==0) { //둘다 안떨어지면
					axq.add(newax);
					ayq.add(neway);
					bxq.add(newbx);
					byq.add(newby);
					cntq.add(cnt+1);
				}else if(fallcoin==2) { //둘다떨어지면
					continue;
				}
			}
		}
		System.out.println(ans);
	}// main
}// class
