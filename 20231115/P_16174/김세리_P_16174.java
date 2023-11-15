package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16174_점프왕쩰리_Large {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static String ans = "Hing";
	static int[] dr = {1,0}; // 아래, 오른쪽
	static int[] dc = {0,1}; // 아래, 오른쪽
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
			}
		}//입력끝
		
		// 쩰리는 0,0에서 출발
		visited[0][0]=true;
		jjelly(0,0);
		
		// ans의 기본 값을 Hing으로 해두었기 때문에
		// HaruHaru로 바뀐 경우를 제외하곤 기본 값인 Hing이 출력된다.
		System.out.println(ans);

	}//main
	static void jjelly(int x, int y) {
		
		// 값이 -1이라면 원하는 곳에 도달하여 쩰리가 승리한 것이다
		// 정답 값을 HaruHaru로 바꿔주고 되돌아간다
		if(map[x][y] == -1) {
			ans = "HaruHaru";
			return;
		}

		for(int i=0;i<2;i++) {
			
			int nr = x + dr[i]*map[x][y];
			int nc = y + dc[i]*map[x][y];
			
			// 쩰리가 범위를 벗어나면 continue하게 한다
			// 어차피 움직이기 못하게 되면 함수가 끝나서 return 된다
			if (nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			// 방문했던 곳에 다시 와도 그냥 continue한다
			if (visited[nr][nc]) continue;
			
			// 방문한 곳은 true로 바꿔준다.
			// 이 뒤에 다시 false로 바꾸는걸 하면 시간초과 뜨니까 주의
			visited[nr][nc]=true;
			jjelly(nr,nc);
		}
		
	}//jjelly
}
