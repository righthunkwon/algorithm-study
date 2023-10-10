package level_22_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨배달
// DFS & 백트래킹 & 브루트포스 문제
// 치킨 거리가 최소가 되는지를 모든 경우의 수를 판단하며 최소값을 갱신
public class P_15686 {
   
	private static int n, m, ans;
	private static int[][] map;
	private static boolean[] visited; 
	private static ArrayList<int[]> house, kfc;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 크기
        m = Integer.parseInt(st.nextToken()); // 최대 치킨집의 수
        ans = Integer.MAX_VALUE; // 최소 치킨 거리
        
        
        // 도시 배열 생성 및 배열 요소 추가
        map = new int[n][n]; // 도시배열
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
		house = new ArrayList<>(); // 집(인덱스 0은 x좌표, 1은 y좌표)
		kfc = new ArrayList<>(); // 치킨집(인덱스 0은 x좌표, 1은 y좌표)
        
        // 도시를 돌며 집과 치킨집에 해당하는 좌표를 배열로(0은 x, 1은 y로) 추가
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (map[i][j] == 0) continue; // 황무지
        		else if (map[i][j] == 1) house.add(new int[] {i, j}); // 집
        		else if (map[i][j] == 2) kfc.add(new int[] {i, j}); // 치킨집
        	}
        }
        visited = new boolean[kfc.size()]; // 치킨집 방문처리 배열 생성

        dfs(0, 0);
        System.out.println(ans);
	}
	
	private static void dfs(int st, int depth) {
		// 기저부분(종료조건)
		if (depth == m) {
			int tmp = 0; // 최소값을 갱신하기 위한 임시 합
			
			// 집마다 방문한 치킨집을 돌며 최소 거리를 구하고 구한 최소 거리를 임시 합에 저장
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				
				// 각 집마다 선택된 각 치킨집의 최소 거리 구하기
				for (int j = 0; j < kfc.size(); j++) {
					if (visited[j]) {
						int dist = Math.abs(house.get(i)[0] - kfc.get(j)[0]) + Math.abs(house.get(i)[1] - kfc.get(j)[1]);
						min = Math.min(min, dist);
					}
				}
				tmp += min; // 최소 거리를 임시 최소 합에 더함
			}
			
			// 집마다 각 치킨집을 돌았을 때의 최소 거리의 합의 최소를 갱신
			ans = Math.min(ans, tmp);
			return;
		}

		// 재귀부분(반복수행)
		for (int i = st; i < kfc.size(); i++) {
			visited[i] = true; // 방문처리
			dfs(i + 1, depth + 1);
			visited[i] = false; // 방문취소
		}
	}
}
