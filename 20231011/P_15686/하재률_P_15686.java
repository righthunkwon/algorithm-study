package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 모든 치킨집 M개의 조합 중
// 집까지의 거리가 최솟값이 되는 조합을 출력하면 되는거 아니가?
// 그러려면 치킨집, 집의 좌표를 저장해둬야할듯
public class BOJ_15686_치킨배달 {
	static int N, M, ans;
	static int[][] map;
	static List<Pos> chicken, home;
	static boolean[] chk;
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 치킨집 개수
		
		map = new int[N][N]; // 맵
		chicken = new ArrayList<>(); // 치킨집 좌표 저장 
		home = new ArrayList<>(); // 집 좌표 저장
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new Pos(i, j));
				if(map[i][j] == 2) chicken.add(new Pos(i, j));
			}
		}// 입력 완
		
		ans = Integer.MAX_VALUE; // 최소값 구해야 하니
		chk = new boolean[chicken.size()];
		comb(0,0);
		System.out.println(ans);
	}
	// 모든 치킨집 조합 구하기
	static void comb(int idx, int cnt) {
		if(cnt == M) { // cnt가 M이되면 최소거리 계산하고 빠져나오기
			dis();
			return;
		}
		if(idx >= chicken.size()) return;
		
		// M개의 치킨집 조합 찾아보자
		chk[idx] = true;
		comb(idx + 1, cnt + 1);
		chk[idx] = false;
		comb(idx + 1, cnt);
	}
	// 최소 거리 계산
	static void dis() {
		int minDis = 0;
		// home 리스트 안에 존재하는 Pos들을 모두 계산
		for(int i = 0 ; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < chicken.size(); j++) {
				if(chk[j]) min = Math.min(min, Math.abs(chicken.get(j).x - home.get(i).x) +
							Math.abs(chicken.get(j).y - home.get(i).y));
			}
			minDis += min;
		}
		ans = Math.min(ans, minDis);
		return;
	}
			
}
