package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q15684_사다리_조작 {

	static int N, M, H;
	static int[][] arr;
	static int minline;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선의 개수
		M = Integer.parseInt(st.nextToken()); // 가로선의 개수
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수

		arr = new int[H + 2][N + 1]; // 사다리 정보 담을 배열
		// M+2로 한 이유는 마지막 줄은 도착지점임을 표시하기 위해 3으로 채울거라서..

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 몇번째 점선 위치인지
			int b = Integer.parseInt(st.nextToken()); // b번 세로선 to b+1번 세로전 연결
			arr[a][b] = 1;  //가로선 출발지 표시
			arr[a][b + 1] = 2;  //가로선 도착지 표시
		}

		for (int i = 1; i <= N; i++) {
			arr[H + 1][i] = 3; // 도착지점 입력
		}
		
		/////////////////////////////// 입력 끝////////////////////////////////////
		
		minline = -1; //정답 default값은 -1로 설정
		
		for(int i =0;i<4;i++) { //줄을 안긋는 경우, 1개, 2개,3개 긋는 경우의 수 확인
			jojac(1,1,0,i);
			if(minline!=-1)  //minline이 갱신됐으면 더 돌필요 없이 끝냄
				break;
		}
		
		System.out.println(minline);
		
	}// main

	// 최대 3개의 사다리를 사용해 조작하는 경우의수를 dfs로 구현할 예정
	public static void jojac(int x, int y, int cnt, int max) { //처음 x,y는 1 / cnt는 0 / max는 0 or 1 or 2 or 3

		// 기저
		if (cnt == max) { // max 1인 경우, 2인 경우, 3인 경우 각각 해볼것
			int i = 1;
			
			while(i<=N) {
				if(go(i)) { 
					i++;	
				}else 
					return;
			}//while
			
			if(i>N)
				minline = max; 
			return;
			
		}//if 
			
			

		// 재귀
		for(int i=x;i<=H;i++) {
			for(int j=1;j<N;j++) {
				
				if(i==x && j<y)continue;  //@@@@@@@@@@@@@@중요!!
				
				if(arr[i][j]!=0 || arr[i][j-1]==1 || arr[i][j+1]==1) continue; //0이 아니거나 양 옆 중에 이미 선이 있으면 패쓰
				
				arr[i][j]=1;
				arr[i][j+1]=2; //가로선 긋기
				
				jojac(i,j,cnt+1,max);
				arr[i][j]=0;
				arr[i][j+1]=0; //원상복구
				
			}
		}//for i
		
		

	}//jojac

	
	
	// 시작지점을 인자로 받아 사다리를 타고 내려와서 같은 위치로 가면 true를 반환, 다른 위치로 가면 false를 반환하는 메서드
	public static boolean go(int st) {
		

		int nx = 1;  
		int ny = st; //시작 세로선
		boolean [][]govisit = new boolean[H + 2][N + 1]; // 1->2  2->1   무한루프 방지용 방문체크 배열
		
		while (true) {

			if (arr[nx][ny] == 0) {
				govisit[nx][ny] = true;  //0이면 방문처리후 아래로 이동
				nx = nx + 1;
				
			} else if (arr[nx][ny] == 1) {  //1이면 방문처리 후, 오른쪽이 방문한적 없으면 오른쪽으로, 방문했었으면 아래로 이동
				govisit[nx][ny] = true;
				if (!govisit[nx][ny + 1]) {
					ny = ny + 1;
				} else {
					nx = nx+1;
				}
			} else if (arr[nx][ny] == 2) { //2면 방문처리 후, 왼쪽이 방문한적 없으면 왼쪽으로, 방문했었으면 아래로 이동
				govisit[nx][ny] = true;
				if(!govisit[nx][ny-1]) {
					ny = ny - 1;
				}else {
					nx = nx+1;
				}
			} else if (arr[nx][ny] == 3) {  //3이면 도착했으니 출발했던 y좌표와 현재 y좌표 비교해서 같으면 true, 틀리면 false 반환
				
				if(ny==st) {
					return true;
				}else {
					return false;
				}
			}
		}//while
	}// go

}//class
