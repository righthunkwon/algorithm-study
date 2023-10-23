package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빙산
// 매년 빙산은 주변 바닷물이 접한 칸 수만큼 녹는다. 
// 이번 문제에서는 외부바닷물과 내부바닷물을 나눌 필요가 없다.

// 1. 빙산이 한 덩어리일 경우 빙산을 녹인다.
// 2. 빙산이 두 덩어리로 나눠질 경우 반복횟수를 출력한다.
// 3. 빙산이 두 덩어리로 나눠지기 전에 빙산이 전부 녹으면 0을 출력한다.
// 4. 빙산을 녹인 뒤 여전히 빙산이 한 덩어리일 경우 다시 빙산을 녹인다.

// 빙산이 몇 덩어리로 나눠졌는지는 길을 죽 따라가는 느낌이므로 dfs로 구현한다.

// 빙산을 녹일 때 유의할 점은 이전의 빙산이 녹아버릴 경우
// 뒤에 판단하는 빙산의 경우 인접하는 바다 칸수가 의도치 않게 증가할 수 있므으로
// 이를 처리하기 위해 원래 빙산이었음을 별도로 기록하여 빙산이 바다가 되더라도 이를 빙산으로 인식하여 다음 빙산을 녹여야 한다.

public class P_2573 {
	
	private static int n, m, cnt, ans;
	private static int[][] map, melt;
	private static boolean[][] visited;
	
	// 상하좌우
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0; // 빙산이 두 덩어리 이상으로 분리되는 최초의 시간
        cnt = 0; // 빙산의 개수
        
        map = new int[n][m]; // 지도
        melt = new int[n][m]; // 얼마나 녹을지 기록
        visited = new boolean[n][m]; // 방문처리
        
        // 지도 배열 요소 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 풀이 로직
        while(true) {
        	// 빙산 덩어리 개수 세기(dfs)
            cnt = 0; 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] == false && map[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}
				}
            }
 
			// 빙산 덩어리의 개수 파악 후 조건에 맞으면 정답 출력
            if(cnt == 0) {
                System.out.println(0);
                break;
            } else if(cnt >= 2) {
                System.out.println(ans);
                break;
            }
 
            // 빙산 덩어리의 개수가 위 조건을 만족하지 않으면
            // 빙하를 녹이고 빙하를 녹이는데 걸린 시간을 증가시킨다.
            melting();
            ans++;
        }
	}
	
    private static void dfs(int x, int y) {
        visited[x][y] = true;
 
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				// 1년 후에 녹는 빙산의 양 구하기
				if (map[nx][ny] == 0) {
					melt[x][y]++;
				}

				// 재귀 호출
				if (visited[nx][ny] == false && map[nx][ny] != 0) {
					dfs(nx, ny);
				}
			}
		}
    }
	
    private static void melting() {    
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 빙산 녹이기
				map[i][j] -= melt[i][j];
				
				// 만약 녹일 빙산이 음수면 0으로 바꿔주기
				if (map[i][j] < 0) map[i][j] = 0;

				visited[i][j] = false; // 초기화
				melt[i][j] = 0; // 초기화
			}
		}
    }

}
