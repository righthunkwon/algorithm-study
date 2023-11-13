import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int []dx= {-1,-1,-1, 0, 0, 1, 1, 1};
	static int []dy= {-1, 0, 1, 1,-1,-1, 0, 1}; //8방향 탐색용 델타
	static int N,M; 
	static int [][]arr; 
	static boolean[][]visit; //방문확인용
	static Queue<Integer> qx,qy; //bfs 좌표 저장용 큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		int max =0; //정답(최대 안전거리) 변수 선언
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0)continue; // 상어 있는 위치는 bfs할 필요 X 어차피 안전거리 0임..
				max=Math.max(max, bfs(i,j));
//				System.out.println("x="+i+"  y="+j+max);
			}
		}
		System.out.println(max);
	}//main
	
	public static int bfs(int x, int y) {
		int distance=0; //해당 좌표의 안전거리 저장할 변수
		visit = new boolean[N][M];
		qx=new LinkedList<>();
		qy=new LinkedList<>();
		qx.add(x);
		qy.add(y);
		visit[x][y]=true;
		
		l:while(!qx.isEmpty() || !qy.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			for(int i=0;i<8;i++) { //8방향으로 bfs진행
				int nextx=nowx+dx[i];
				int nexty=nowy+dy[i];
				//범위 벗어나거나 방문했던 곳은패쓰
				if(nextx<0||nexty<0||nextx>=N||nexty>=M||visit[nextx][nexty])continue;
				//1만나면 그곳과 초기 x,y와의 거리가 안전거리가 되므로 안전거리 구하고 while문 끝냄
				if(arr[nextx][nexty]==1) {
					distance=Math.max(Math.abs(x-nextx), Math.abs(y-nexty)); //대각선 이동 고려한 거리 계산
					break l;
				}else {
					visit[nextx][nexty]=true;
					qx.add(nextx);
					qy.add(nexty);
				}
			}
		}
		return distance; //해당 좌표의 안전거리 반환
	}
	
	
	
	
	
}
