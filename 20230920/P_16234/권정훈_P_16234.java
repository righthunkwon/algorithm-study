import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 인구 이동
// 노드로 클래스 분리해서 하려고 했는데 짬바가 부족하다...
public class P_16234 {
	private static int n, l, r;
	private static int[][] map;
	private static boolean[][] visited;
	
	// 상하좌우
	private static int[] dx = {0,0,-1,1}; 
	private static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 땅의 크기
		l = sc.nextInt(); // 국경선이 열리는 인구차이의 최소
		r = sc.nextInt(); // 국경선이 열리는 인구차이의 최대
		map = new int[n][n]; // 땅 배열
		visited = new boolean[n][n]; // 방문처리 배열
		
		// 땅 배열 요소 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		visited[x][y] = true; // 방문처리
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
		}
	}
	
    public static class Node {
        int x; 
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
