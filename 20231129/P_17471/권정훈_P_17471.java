package level_31_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 게리맨더링
// 선거구의 연결성 판단 및 선거구 존재여부 판단
// 선거구가 정상적으로 되어 있으면 두 선거구에 포함된 인구차이의 최소값을 산출 
public class P_17471 {
	private static int n;
	private static int[] population;
	private static ArrayList[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 구역의 개수
		population = new int[n + 1]; // 구역별 인구의 수
		map = new ArrayList[n + 1][n + 1];

		// 구역별 인구의 수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// 인접한 구역의 정보 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 첫 입력
			for (int j = 1; j <= n; j++) {
				map[i][j].add(Integer.parseInt(st.nextToken()));
			}
		}

		getPrecinct(); // 선거구 판단
		getMinPopulation(); // 인구차이의 최소값 판단
	}

	// 선거구 판단
	private static void getPrecinct() {
		// 두 개 인지 판단

		// 연결성 여부 판단

	}

	// 인구차이의 최소값 판단
	private static void getMinPopulation() {

	}
}
