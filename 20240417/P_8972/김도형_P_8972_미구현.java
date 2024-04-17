package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q8972_미친_아두이노 {
	
	static class Node{
        int x, y;
        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

	static int R, C;
	static char[][] map;
	
	static Queue<Node> jongsoo = new LinkedList<>();
    static Queue<Node> crazy = new LinkedList<>();

	static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String command = br.readLine(); //
			for (int j = 0; j < C; j++) {
				map[i][j] = command.charAt(j);
				if (map[i][j] == 'I')
					jongsoo.add(new Node(i, j));
				else if (map[i][j] == 'R')
					crazy.add(new Node(i, j));
			}
		}
		
		String direction = br.readLine(); //방향
		

	}// main
}
