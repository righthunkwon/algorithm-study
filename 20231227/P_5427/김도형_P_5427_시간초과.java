package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q5427_불 {
	
	static int W,H,time;
	static char[][]map;
	static int[][]firemap;
	static boolean[][]SangVisit;//상근이 방문확인용
	static boolean[][]FireVisit;//불 방문 확인용
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,1,-1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); //테케 수
		for(int tc = 0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());//너비
			H = Integer.parseInt(st.nextToken());//높이
			map=new char[H][W];//지도 정보 입력 배열 생성
			firemap=new int[H][W];//불 퍼지는데 걸리는 시간 저장할 배열
			Queue<Integer>firex=new LinkedList<>();
			Queue<Integer>firey=new LinkedList<>(); //발화지점 저장용 큐
			
			flag = false; //탈출 성공여부 확인용 flag 초기화
			time = 0;
			
			int x=-1; //상근 위치 초기화
			int y=-1;
			for(int i=0;i<H;i++) {
				String str = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='@') { //상근 위치 저장
						x=i;
						y=j;
					}else if(map[i][j]=='*') {//발화지점 저장
						firex.add(i);
						firey.add(j);
					}
				}
			}
		
			//불 퍼뜨리기
			while(!firex.isEmpty() ||!firey.isEmpty()) {
				int fx=firex.poll();
				int fy=firey.poll();
				FireVisit=new boolean[H][W]; //불 방문 배열 초기화
				fireSpread(fx,fy,0); //불 퍼뜨리고
			}
			
			SangVisit=new boolean[H][W]; //상근 방문 배열 초기화
			escape(x,y,0); //탈출
			
			if(flag) {
				System.out.println(time);
			}else {
				System.out.println("IMPOSSIBLE");
			}
			
//			System.out.println(Arrays.deepToString(firemap));

			
		}//tc
	}//main
	
	//불 퍼뜨리기(발화지점 x,y),(d는 그 위치까지 퍼지는데 걸리는 최소시간)
	public static void fireSpread(int x,int y,int d) {
		Queue<Integer>qx=new LinkedList<>();
		Queue<Integer>qy=new LinkedList<>();
		Queue<Integer>qd=new LinkedList<>();
		qx.add(x);
		qy.add(y);
		qd.add(d);
		FireVisit[x][y]=true;
		
		while(!qx.isEmpty()||!qy.isEmpty()) {
			int nowx=qx.poll();
			int nowy=qy.poll();
			int nowd=qd.poll();
			for(int i=0;i<4;i++) {
				int nextx=nowx+dx[i];
				int nexty=nowy+dy[i];
				//맵 벗어나거나 벽이거나 방문했던 곳 pass
				if(nextx<0||nextx>=H||nexty<0||nexty>=W||map[nextx][nexty]=='#'||FireVisit[nextx][nexty])continue;
				//발화지점이거나 불이 먼저 퍼진곳이면 pass
				if(map[nextx][nexty]=='*'||(firemap[nextx][nexty]!=0&&firemap[nextx][nexty]<=nowd+1))continue;
				firemap[nextx][nexty]=nowd+1; //한칸 퍼질때마다 걸리는 시간 +1
				FireVisit[nextx][nexty]=true; 
				qx.add(nextx);
				qy.add(nexty);
				qd.add(nowd+1);
			}
		}
	}
	
	//탈출 시도
	public static void escape(int x,int y, int d) {
		Queue<Integer>qx=new LinkedList<>();
		Queue<Integer>qy=new LinkedList<>();
		Queue<Integer>qd=new LinkedList<>();
		qx.add(x);
		qy.add(y);
		qd.add(d);
		SangVisit[x][y]=true;
		
		while(!qx.isEmpty()||!qy.isEmpty()) {
			int nowx=qx.poll();
			int nowy=qy.poll();
			int nowd=qd.poll();
			for(int i=0;i<4;i++) {
				int nextx=nowx+dx[i];
				int nexty=nowy+dy[i];
				
				if(nextx<0||nextx>=H||nexty<0||nexty>=W) { //탈출 성공시
					flag=true; //플래그 바꾸고
					time=nowd+1;
					return; //나감
				}
				//맵 벗어나거나 벽이거나 방문했던 곳 pass
				if(map[nextx][nexty]=='#'||SangVisit[nextx][nexty])continue;
				//발화지점이거나 불이 먼저 퍼진곳이면 pass
				if(map[nextx][nexty]=='*'||(firemap[nextx][nexty]!=0&&firemap[nextx][nexty]<=nowd+1))continue;
//				firemap[nextx][nexty]=nowd+1; //한칸 퍼질때마다 걸리는 시간 +1
				SangVisit[nextx][nexty]=true; 
				qx.add(nextx);
				qy.add(nexty);
				qd.add(nowd+1);
			}
		}
	}
}//class
