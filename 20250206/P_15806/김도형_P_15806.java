import java.io.*;
import java.util.*;

public class BOJ_P5_15806_영우의_기숙사_청소 {
	
	//곰팡이 퍼져나가는 방향
	  static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //방 크기 n*n
		int m = Integer.parseInt(st.nextToken()); //곰팡이 수
		int k = Integer.parseInt(st.nextToken()); //검사하는 방바닥 좌표의 수
		int t = Integer.parseInt(st.nextToken()); //청소 검사까지 남은 일수
		
		//곰팡이 존재 여부 저장(짝수일,홀수일 구분해서)
		boolean [][][] mold = new boolean[2][n+1][n+1]; 
		
		Queue<int[]>q1 = new LinkedList<>(); //홀수일째 사용할 큐
		Queue<int[]>q2 = new LinkedList<>(); //짝수일째 사용할 큐
		
		//곰팡이 위치 입력
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			q1.add(new int[] {0,y,x}); // 0일차(현재)곰팡이 위치 큐에 넣고
			mold[0][y][x]=true; //곰팡이 좌표 체크
		}
		
		// t일간 곰팡이 전파
		for(int i=1;i<=t;i++) {
			//날짜별로 사용할 큐 선택(홀수일에 q1 , 짝수일에 q2)
			Queue<int[]>nowQ = (i%2==1)? q1 : q2;
			Queue<int[]>nextQ = (i%2==1)? q2 : q1;
			
			if(nowQ.isEmpty())break; 
			
			while(!nowQ.isEmpty()) {
				int[]now = nowQ.poll();
				int z = now[0]; 
				int y = now[1];
				int x = now[2];
				boolean check = false; //증식 여부(하나도 증식하지 못했을 경우 소멸시키기 위해)
				
				for(int j=0;j<8;j++) {
					int nz = (z+1)%2; //현재 짝수였으면 홀수로, 홀수였으면 짝수로
					int ny = y+dy[j];
					int nx = x+dx[j];
					if(ny<1 || nx<1 || ny>n || nx>n)continue; //범위 벗어나면 패스
					if(mold[nz][ny][nx])continue; //이미 곰팡이 체크된상태면 패스
					nextQ.add(new int[] {nz,ny,nx});
					mold[nz][ny][nx]=true;
					check = true;
				}
				if(!check)mold[z][y][x]=false; //증식 못했으면 사라짐
			}
		}
		
		boolean flag = false; //청소해야되는지 여부
		
		//검사하는 방바닥 위치 입력
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(mold[t%2][y][x]) { //t일째에 검사하는 위치에 곰팡이 있으면 청소해야함
				flag = true;
			}
		}
		
		System.out.println(flag?"YES":"NO");
		
		
	}//main

}
