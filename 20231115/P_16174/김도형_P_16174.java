import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][]map = new int [N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		Queue<Integer>qx = new LinkedList<>();
		Queue<Integer>qy = new LinkedList<>();
		boolean[][]visit = new boolean[N][N];
		
		visit[0][0]=true;
		qx.add(0);
		qy.add(0);
		int []dx= {1,0}; //아래 이동
		int []dy= {0,1}; //오른쪽 이동
		
		while(!qx.isEmpty() || !qy.isEmpty()){ //bfs를 통해 -1 에 도착 가능 여부 확인
			int x=qx.poll();
			int y=qy.poll();
			
			for(int i=0;i<2;i++) {
				int nx=x+dx[i]*map[x][y]; 
				int ny=y+dy[i]*map[x][y];
				if(nx>=N ||ny>=N||visit[nx][ny])continue;//범위밖 or 방문한곳 패스
				
				if(map[nx][ny]==-1) {
					System.out.println("HaruHaru");
					return;
				}else {
					visit[nx][ny]=true;
					qx.add(nx);
					qy.add(ny);
				}
			}//for
		}//while
		System.out.println("Hing");
		
		
		
		
	}//main
}//class
