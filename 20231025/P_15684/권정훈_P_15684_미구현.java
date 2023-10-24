import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사다리 조작
// 문제 상이 안 떠올라용,,,
public class P_15684 {
	
    private static int n, m, h, ans;
    private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
	        st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken()); // 세로
	        m = Integer.parseInt(st.nextToken()); // 가로
	        h = Integer.parseInt(st.nextToken()); // 가로선 위치 개수
	        ans = 0; // 추가해야 하는 가로선의 개수
	        
	        map = new int[h + 1][n + 1];
	        
	        // 가로선 정보
	        for (int i = 0; i < m; i++) {
	            st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());

	            map[x][y] = 1;
	        }
	}
	
	private static void dfs(int nx, int cnt, int size) {
		
	}
}
