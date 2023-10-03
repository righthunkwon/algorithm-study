package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	static int n, sx, sy, ex, ey; // 상근이 집 좌표, 펜타포트 좌표
	static String res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(i == 0) { // 상근이 집 좌표 입력
					sx = x;
					sy = y;
				}else if(i == n + 1) { // 펜타포트 좌표 입력
					ex = x;
					ey = y;
				}else { // 나머지는 편의점 입력
					list.add(new int[] {x, y});
				}
			}// 입력 완
			res = bfs(list)? "happy" : "sad";
			
			System.out.println(res);
			
		}
	}
	
	static boolean bfs(List<int[]> list) {
		/* 맥주 20캔 * 50보 = 1000
		 1000의 거리보다 작으면 길맥하면서 도착가넝
		 집과 펜타포트, 각 편의점을 정점이라 생각하고
		 queue안에 집부터 좌표를 넣은뒤에
		 거리가 1000 이하인 편의점을 방문하며 펜타포트에 도착할 수 있으면 true
		 아니면 false를 반환하는 메서드
		*/
		Queue<int[]> q = new LinkedList<>();
		boolean[] chk = new boolean[n];
		q.add(new int[] {sx, sy});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];
			// 펜타포트까지 맨허튼 거리가 1000 이하면 true 리턴 
			if(Math.abs(tx - ex) + Math.abs(ty - ey) <= 1000) return true;
			
			for(int i = 0; i < n; i++) {
				if(!chk[i]) {
					int nx = list.get(i)[0];
					int ny = list.get(i)[1];
					// i번째 편의점까지의 맨허튼 거리가 1000이하면 방문하고 편의점부터 출발
					if(Math.abs(tx - nx) + Math.abs(ty - ny) <= 1000) {
						chk[i] = true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		return false;
	}
}
