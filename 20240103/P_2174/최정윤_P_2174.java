
import java.io.*;
import java.util.*;
//arr에는 방향으로 저장을 해두고, 몇번 로봇이 어떤 좌표에 있는지 따로 저장을 해두자! 
//어차피 arr에 번호까지 넣어두면 for문으로 1번로봇이 어디에 있는지 찾아야함 ! =>따로 저장한 이유
public class Pro_2174_로봇시뮬레이션 {
	static class Robot {
		int x, y;

		public Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		land = new int[B][A];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// N : 1, E : 2, S :3, W: 4
		// 오른쪽으로 회전 =>+1 4초과면 1로
		// 왼쪽으로 회전=>-1 0이하면 4로
		
		dr = new int[] { 1, 0, -1, 0 };
		dc = new int[] { 0, 1, 0, -1 };
		// 로봇 번호랑 위치 따로 저장해놔야한다.
		robot = new Robot[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			robot[i] = new Robot(x - 1, y - 1); // 로봇 번호의 위치 저장
			switch (st.nextToken()) {
			case "N":
				land[y - 1][x - 1] = 1;
				break;
			case "E":
				land[y - 1][x - 1] = 2;
				break;
			case "S":
				land[y - 1][x - 1] = 3;
				break;
			case "W":
				land[y - 1][x - 1] = 4;
				break;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			String cmd = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case "L":
				Robot r = robot[num];
				land[r.y][r.x] += (land[r.y][r.x] - cnt % 4 <= 0) ? -cnt % 4 + 4 : -cnt % 4;
				break;
			case "R":
				Robot r2 = robot[num];
				land[r2.y][r2.x] += (land[r2.y][r2.x] + cnt % 4 >= 5) ? cnt % 4 - 4 : cnt % 4;
				break;
			case "F":
				dfs(num, cnt);
				break;
			}
		}
		System.out.println("OK");
	}

	static int[][] land;
	static Robot[] robot;
	static int[] dr, dc;
	static int A, B, N;

	private static void dfs(int num, int cnt) {// 몇번 로봇이 앞으로 몇번가야하나
		if (cnt == 0) return;
		Robot r = robot[num];
		int nr = r.y + dr[land[r.y][r.x] - 1]; //land[r.y][r.x] - 1 : num 번 로봇의 방향
		int nc = r.x + dc[land[r.y][r.x] - 1];
		if (nr < 0 || nc < 0 || nr >= B || nc >= A) { //범위초과로 벽
			System.out.println("Robot " + (num + 1) + " crashes into the wall");
			System.exit(0);
		} 
		else if (land[nr][nc] != 0) { //다른 로봇이 있다.
			int Y = -1;
			for (int i = 0; i < N; i++) {  //그 로봇이 몇번인지 찾기 위함
				if (robot[i].x == nc && robot[i].y == nr) Y = i;
			}
			System.out.println("Robot " + (num + 1) + " crashes into robot " + (Y + 1));
			System.exit(0);
		} 
		else {
			land[nr][nc] = land[r.y][r.x]; //앞으로 전진한 칸 숫자 넣어주고
			land[r.y][r.x] = 0;  //원래 있던 칸 0으로 초기화
			robot[num] = new Robot(nc, nr); //로봇위치 새로 저장
			dfs(num, cnt - 1); //반복
		}
	}
}
