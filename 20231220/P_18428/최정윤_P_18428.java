package baek;

import java.io.*;
import java.util.*;
public class Pro_18428_감시피하기 {
	static class Place {
		int r, c;

		public Place(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		way = new char[N][N];
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		t = new ArrayList<>();
		x = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				way[i][j] = st.nextToken().charAt(0);
				if (way[i][j] == 'T') { //선생님이 5이하 이므로 따로 저장, 선생님 기준으로 학생이 보이는지 판단하자
					t.add(new Place(i, j));
				} else if (way[i][j] == 'X') {//장애물 설치가능한 좌표 다 저장
					x.add(new Place(i, j));
				}
			}
		} // 입력 끝

		dfs(0, 0);
		System.out.println("NO");//다 감시에 걸려야 여기로 옴

	}

	static List<Place> x, t;
	static char[][] way;
	static int[] dr, dc;
	static int N;

	private static void dfs(int cnt, int xidx) {
		if (cnt == 3) {//장애물 설치 완료
			find();		//선생님 기준에서 학생이 보이냐
			return;
		}
		if (xidx == x.size())
			return;
		Place p = x.get(xidx);  //xidx자리에 
		way[p.r][p.c] = 'O';	//장애물설치
		dfs(cnt + 1, xidx + 1);
		way[p.r][p.c] = 'X';	//장애물없애기
		dfs(cnt, xidx + 1);
	}

	private static void find() {
		for (Place p : t) {
			for (int i = 0; i < 4; i++) {
				int nr = p.r;
				int nc = p.c;
				while (true) {
					nr += dr[i];
					nc += dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || way[nr][nc] == 'O')//범위 초과, 장애물있으면 다른쪽 확인
						break;
					else if (way[nr][nc] == 'S') {//학생이 있다면 감시못피함
						return;
					}
				}
			}
		}
		System.out.println("YES");//여기까지 왔다는 것은 감시 피할 수 있는 경우가 있음 출력후 종료
		System.exit(0);
	}
}
