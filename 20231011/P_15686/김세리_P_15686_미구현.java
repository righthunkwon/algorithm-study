import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15686_치킨배달 {
	static int N,M;
	static int min =9876543;
	static int[][] arr, home, chicken;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
//		fix = new int [N][N];
		home = new int [2][2*N];
		chicken = new int [2][13];
		visited = new boolean[N][N];
		Arrays.fill(home[0], -1);
		Arrays.fill(home[1], -1);
		Arrays.fill(chicken[0], -1);
		Arrays.fill(chicken[1], -1);
		int hdx =0;
		// arr : 도시 지도 채우기
		// visited : 벽을 세울 수 있는 공간 외엔 true로 입력하기
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j) - '0';
				if(arr[i][j]==0 || arr[i][j]==1) visited[i][j]=true;
				if(arr[i][j]==1) home[hdx][0]=i; home[hdx][1] = j; hdx++;
			}
		}
		//dfs돌려서 0의 최대개수 구한다
		dfs(0,0,0);
		System.out.println(min);
		
	}//main
	public static void dfs(int x, int y, int cnt) {
		if(cnt==M) {
			// M개 치킨집 고른걸로 지도 바꿈
			
			int sum=0;
			for(int i=0;i<2*N;i++) {
				int d=0;
				int dis=N+1;
				
				for(int j=0;j<13;j++) {
					if(home[i][0]!=-1 && chicken[j][0]!=-1) {
						d=Math.abs(home[i][0]-chicken[j][0]) + Math.abs(home[i][1]-chicken[j][1]);
						dis = Math.min(dis, d);
					}
					
				}
				sum += dis;
			}
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int nx = x + i;
				int ny = y + j;
				if(nx<0 || ny<0 || nx>N || ny>N) continue;
				if(!visited[nx][ny]) {
					
					visited[nx][ny] = true;
					arr[nx][ny] = 3;
					chicken[cnt][0]=nx; chicken[cnt][1] = ny;
					dfs(nx,ny,cnt+1);
					visited[nx][ny] = false;
					arr[nx][ny] = 2;
				}
			}
		}
		
		
	}//dfs

		
	
}
