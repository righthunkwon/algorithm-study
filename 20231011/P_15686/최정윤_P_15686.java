

package baek;

import java.io.*;
import java.util.*;

public class Pro_15686_치킨배달 {
	static int sum;
	static int min;
	static List<int[]> list;
	static List<int[]> list2;
	static int N;
	static int M;
	static int[][] map;
	static boolean[] visited;
	static int[] dr;
	static int[] dc;
	static int[][] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		select = new int[M][2];
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();//1인 집 모아두기
		list2 = new ArrayList<>();//2인 치킨집 모아두기
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					list2.add(new int[] { i, j });
				else if (map[i][j] == 1)
					list.add(new int[] { i, j });
			}
		} // 입력끝
		visited = new boolean[list2.size()];
		if (list2.size() < M)
			M = list2.size();
		select(0, 0);

		System.out.println(min);
	}

	private static void select(int idx, int listidx) {
		if (idx == M) {//M개 선택되었다면
			sum = 0;
			for (int i = 0; i < list.size(); i++) {//집부터 치킨집까지 거리 합 구해라
				int[] home = list.get(i);
				int distance = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {//집 기준 모든 치킨집 돌면서 어떤 치킨집이 가장 가까운지 
					int[] chick = select[j];
					distance = Math.min(Math.abs(home[0] - chick[0]) + Math.abs(home[1] - chick[1]), distance);
				}
				sum += distance;
			}
			min = Math.min(sum, min);
			return;
		}
		if (listidx == list2.size())
			return;
		select[idx] = list2.get(listidx);
		select(idx + 1, listidx + 1);
		select(idx, listidx + 1);
	}
}
