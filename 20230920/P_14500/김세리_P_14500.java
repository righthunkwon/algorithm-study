import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500_테트로미노 {
	static int N, M;
	static int max=0;
	static int[][] paper;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] nr = {-1, 1 , 0, 0};
	static int[] nc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		// 테트로미노를 놓을 종이 크기: 세로 N,가로 M
		paper = new int[N][M];
		visited = new boolean [N][M];
		
		// 종이에 쓰여 있는 수를 입력한다
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 전체를 dfs돌린다
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 처음 시작점을 true로 바꾸고, 끝난 후에 다시 false로 바꿔준다
				visited[i][j]=true;
				// cnt는 처음 시작할 때 한 칸이 생기는 것이므로 1부터 시작한다
				dfs(i,j,paper[i][j],1);
				visited[i][j]=false;
			}
		}
		System.out.println(max);
		

	}//main
	
	static void dfs(int x, int y, int sum, int cnt) {
		// cnt가 4이면 나간다
		// 가장 큰 sum의 값이 max가 된다
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			// 시작 지점에서 상하좌우로 이동한다
			// 'ㅗ'모양을 제외한 나머지 모양은 결국 시작점에서 3번 이동하면 나오는 모든 모양에 해당한다
			int dr = x + nr[i];
			int dc = y + nc[i];
			if(dr<0||dc<0||dr>=N||dc>=M) { // 범위 벗어나는 경우
				continue;
			}
			if(!visited[dr][dc]) {
				
				// 중간에 cnt가 2일때 'ㅗ'모양을 위해 2번째 지점으로 다시 돌아와서 dfs를 한 번 더 돌린다
				if(cnt==2) {
					visited[dr][dc]=true;
					dfs(x,y,sum+paper[dr][dc],cnt+1);
					visited[dr][dc]=false;
				}
				
				visited[dr][dc]=true;
				dfs(dr,dc,sum+paper[dr][dc],cnt+1);
				visited[dr][dc]=false;
				
				
			}
			
		}
		
	}//dfs

}

