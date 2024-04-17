package study_240417;

import java.io.*;
import java.util.*;


public class Pro_8972_미친아두이노 {
	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];
		List<Node> mc = new ArrayList();
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == 'I') {
					jong = new Node(i, j);
				} else if (board[i][j] == 'R') {
					mc.add(new Node(i, j));
				}
			}
		}
		String[] dir = br.readLine().split("");

		dr = new int[] { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
		dc = new int[] { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
		cnt = 0;
		for (int i = 0; i < dir.length; i++) {
			cnt++;
			board[jong.r][jong.c] = '.';
			int d = Integer.parseInt(dir[i]) - 1;
			jong.r += dr[d];
			jong.c += dc[d];
			if (board[jong.r][jong.c] == 'R') { //졌다면
				System.out.println("kraj " + cnt);
				System.exit(0);
			}
			board[jong.r][jong.c] = 'I';
			HashMap<String, Integer> map = new HashMap<>();
			for (Node n : mc) {
				board[n.r][n.c] = '.';   //움직일 거니까 자리비우기
				Node newMc = minDist(n); //가장 가까운 곳으로 가기
				int sum = map.getOrDefault(newMc.r + "," + newMc.c, 0) + 1;
				map.put(newMc.r + "," + newMc.c, sum);
			}
			mc = new ArrayList<>(); //배열 초기화
			for (String a : map.keySet()) {
				if (map.get(a) == 1) { //1개의 아두이노만 있을 경우만 담기
					String[] arr = a.split(",");
					board[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = 'R';
					mc.add(new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
				}
			}
		}
		for (int k = 0; k < R; k++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[k][j]);
			}
			System.out.println();
		}
	}

	static Node jong;
	static int cnt, R, C;
	static int[] dr, dc;

	public static Node minDist(Node mc) {
		int r = mc.r;
		int c = mc.c;
		int minR = 100;
		int minC = 100;
		int min = 202;
		for (int i = 0; i < 9; i++) {
			if (i == 4) //본인 위치 그대로 있는 경우 제외
				continue;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			int dist = Math.abs(jong.r - nr) + Math.abs(jong.c - nc);
			if (dist == 0) { // 종수가 짐
				System.out.println("kraj " + cnt);
				System.exit(0);
			}
			if (dist < min) {
				min = dist;
				minR = nr;
				minC = nc;
			}
		}
		return new Node(minR, minC);
	}
}
