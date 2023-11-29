package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21736_헌내기는친구가필요해 {
	static char[][] map;
	static int N,M,idx=0,jdx=0,cnt=0;
	static int ans = 0;
	static boolean[][] visited;
	// 상, 하, 좌, 우
	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 캠퍼스 크기(가로)
		M = Integer.parseInt(st.nextToken()); // 캠퍼스 크기(세로)
		map = new char[N][M]; // 캠퍼스 정보들 넣은 배열
		visited = new boolean[N][M];
		
		// 입력 받아오기 + 도연이 위치 저장
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]= s.charAt(j);
				if(map[i][j]=='I') {
					idx = i; jdx = j;
				}
			}
		}//입력끝
		
		//도연이의 현재 위치에서 시작
		moving(idx,jdx);
		
		//ans가 0보다 크면 도연이가 만난 사람의 수(ans) 출력
		if(ans>0) System.out.println(ans);
		//ans가 0이면 도연이는 아무도 못만난 것이므로 TT출력
		if(ans==0) System.out.println("TT");
		
		
	}//main
	
	static void moving(int x, int y) {
		// 가장 많은 사람을 만난게 답이어야 하므로 ans와 cnt 비교해서 큰걸 ans로 저장
		ans = Math.max(ans, cnt);
		// x,y 방문체크
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			// 범위 벗어나거나 벽에 막히거나 이미 방문한 적 있으면 그냥 continue
			if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]=='X' || visited[nr][nc]==true) continue;
			// P이면  사람을 만난거니까 cnt 증가
			if(map[nr][nc]=='P') {
				cnt++;
			}
			// 반복
			moving(nr,nc);
		}
	}//moving

}
