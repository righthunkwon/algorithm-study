
import java.io.*;
import java.util.*;

// 미친 아두이노
public class P_8972 {
	private static int r, c;
	private static char[][] map;
	private static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	private static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	private static LinkedList<Node> crazyArdu;
	private static Node ardu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c]; // 보드판
		crazyArdu = new LinkedList<>(); // 미친아두이노 위치 저장
		for (int i = 0; i < r; i++) {
			str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'R') {
					crazyArdu.add(new Node(i, j));
				} else if (map[i][j] == 'I') {
					ardu = new Node(i, j);
				}
			}
		}
		String dir = br.readLine(); // 방향

		int cnt = 1; // 움직인 횟수
		boolean lose = false; // 종수 패배
		for (int k = 0; k < dir.length(); k++) {
			// 아두이노 이동
			
			// 
			map[ardu.x][ardu.y] = '.';
			ardu.x = ardu.x + dx[dir.charAt(cnt - 1) - '0'];
			ardu.y = ardu.y + dy[dir.charAt(cnt - 1) - '0'];

			if (map[ardu.x][ardu.y] == 'R') {
				lose = true;
				break;
			}
			map[ardu.x][ardu.y] = 'I';

			// 미친 아두이노 이동
//			if (!moveCrazyArdu()) {
//				lose = true;
//				break;
//			}
			cnt++;
		}

		// 정답 출력
		if (lose) {
			System.out.println("kraj " + cnt);
		} else {
			// 
		}
	}

	public static boolean moveCrazyArdu() {
		int[][] arduCnt = new int[r][c];

		int craze_arduino_size = crazyArdu.size();
		for (int i = 0; i < craze_arduino_size; i++) {
			Node curr = crazyArdu.poll();

		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arduCnt[i][j] == 1) {
					map[i][j] = 'R';
					crazyArdu.add(new Node(i, j));
				}
			}
		}
		return true;
	}
	
	// 

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
