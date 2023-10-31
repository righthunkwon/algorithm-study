package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100_2048_easy {
	static int N, res = -1;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완
		// 위 아래 왼 오 4방향.. 5번 이동이니까
		// 4^5 = 1024가지 방법 다 해보고 가장 큰 수 뽑으면 될까?
		
		dfs(0);
		System.out.println(res);
	}
	static void dfs(int cnt) {
		if(cnt == 5) {
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					max = map[i][j] > max ? map[i][j] : max;
				}
			}
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			res = max > res ? max : res;
			return;
		}
		
		// 임시 배열에 맵 복사해두기
		int[][] tmp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
					up(); break;
				case 1:
					down(); break;
				case 2:
					left(); break;
				case 3:
					right(); break;
			}
			dfs(cnt + 1);
			
			// tmp -> map
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					map[j][k] = tmp[j][k];
				}
			}
		}
	}
	
	static void up() {
		for(int i = 0; i < N; i++) { // 가로줄 왼쪽부터 하나씩 돌건데
			int idx = 0; // 현재칸 조종할 인덱스
			for(int j = 1; j < N; j++) { // 위에서부터 하나씩
				
				int now = map[idx][i]; // 현재칸
				int next = map[j][i]; // 다음칸
				if(next == 0) continue; // 다음칸이 0이면 걍 건너뛰어
				
				if(now == 0) { // 현재칸이 0이면 땡겨주기
					map[idx][i] = next;
					map[j][i] = 0;
					
				}else if(now == next) { // 현재칸이 다음칸과 값이 같으면
					map[idx][i] *= 2; // 현재칸에서 합쳐지고
					map[j][i] = 0; // 다음칸은 0이된다
					idx++; // 현재칸 조종 인덱스 +1 (다음칸을 기준으로, 다음칸은 0이기때문에 continue되고 j는 다다음칸)
					
				}else { // 현재칸이 다음칸과 값이 다르면
					idx++; // 인덱스 증가시키고 
					map[idx][i] = map[j][i]; // 현재칸은 쓸모 없으니까 다음칸을 현재칸으로
					if(idx != j) map[j][i] = 0; // 빈 칸이 있는경우 처리
					// (세로로 2 0 4 일때 (j==1은 continue) idx==0 j==2, idx++ 된 (idx인 1)과 (j인 2)가 다르니까 4가 땡겨지고 4의 자리는 0이 되는 너낌  
				}
			}
		}
	}
	
	static void down() {
		for(int i = 0; i < N; i++) {
			int idx = N-1;
			for(int j = N-2; j >= 0; j--) {
				int now = map[idx][i];
				int next = map[j][i];
				if(next == 0) continue;
				
				if(now == 0) {
					map[idx][i] = next;
					map[j][i] = 0;
					
				}else if(now == next) {
					map[idx][i] *= 2;
					map[j][i] = 0;
					idx--;
					
				}else {
					idx--;
					map[idx][i] = map[j][i];
					if(idx != j) map[j][i] = 0;
				}
			}
		}
	}
	
	static void left() {
		for(int i = 0; i < N; i++) {
			int idx = 0;
			for(int j = 1; j < N; j++) {
				int now = map[i][idx];
				int next = map[i][j];
				if(next == 0) continue;
				
				if(now == 0){
					map[i][idx] = next;
					map[i][j] = 0;
				}else if(now == next) {
					map[i][idx] *= 2;
					map[i][j] = 0;
					idx++;
					
				}else {
					idx++;
					map[i][idx] = map[i][j];
					if(idx != j) map[i][j] = 0;
				}
			}
		}
	}
	
	static void right() {
		for(int i = 0; i < N; i++) {
			int idx = N-1;
			for(int j = N-2; j >= 0; j--) {
				int now = map[i][idx];
				int next = map[i][j];
				if(next == 0) continue;
				
				if(now == 0) {
					map[i][idx] = next;
					map[i][j] = 0;
				}else if(now == next) {
					map[i][idx] *= 2;
					map[i][j] = 0;
					idx--;
					
				}else {
					idx--;
					map[i][idx] = map[i][j];
					if(idx != j) map[i][j] = 0;
				}
			}
		}
	}
}
