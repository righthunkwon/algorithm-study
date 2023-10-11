import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502_연구소 {
	static int N, M;
    static int max = 0;
    static int[][] arr, virus;
    static boolean[][] visited;
	//상, 하, 좌, 우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 연구소 : arr
        arr = new int[N][M];
        
        // 바이러스 퍼진거 구할 때 연구소 배열 복제해서 구해준다
        virus = new int[N][M];
        
        // arr을 채운다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // dfs를 돌리며 가장 0이 많이 나오는 경우를 찾아낸다
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int cnt) {
    	
    	// 벽 3개 세웠으면 바이러스 퍼진 후 0의 개수를 센다 -> bfs 이용
        if (cnt == 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	// 연구소 배열에서 0 인 애들에 벽을 세울 수 있으므로
            	// 하나씩 바꿔서 벽 3개까지 세운다
            	if(arr[i][j]==0) {
            		arr[i][j]=1;
            		dfs(cnt+1);
            		arr[i][j]=0;
            	}
            }
        }
    }//dfs
    

    public static void bfs() {
    	Queue<int[]> q = new LinkedList<>();
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			virus[i][j]=arr[i][j]; // virus 배열을 채워주고
    			if(arr[i][j]==2)		// q에 2인 애들의 위치 값을 저장해둔다
    				q.add(new int[] {i,j});
    		}
    	}
        // q에서 바이러스 위치를 하나씩 꺼내서 퍼뜨리고
    	// 다시 바이러스가 퍼진 애들을 q에다 넣는 식으로 해서 바이러스가 다 퍼질때까지 while문을 돌려준다
    	while(!q.isEmpty()) {
    		int[] tmp = q.poll();
    		int x = tmp[0];
    		int y = tmp[1];
    		
    		for(int i=0;i<4;i++) {
    			int nr = x + dr[i];
    			int nc = y + dc[i];
    			
    			if(nr>=0 && nc>=0 && nr<N && nc<M && virus[nr][nc]==0) {
    				virus[nr][nc]=2;
    				q.add(new int[] {nr,nc}); // 새롭게 바이러스 퍼진 애들을 다시 큐에 넣음
    			}
    		}
    	}
    	
    	// 이제 q가 다 비워지면, 바이러스가 다 퍼졌단 의미임.
    	// 0의 개수를 세서 sum에다 넣고, 그 sum의 값이 최대인 것을 max로 하여 반환한다
        int sum=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 0) sum++;
            }
        }
        
        max = Math.max(max, sum);
    }//bfs
}

