package IM대비;

import java.util.Scanner;

public class BaekJoon_Q10157_자리배정 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt(); //가로 좌석수
		int R = sc.nextInt(); //세로 좌석수
		int K = sc.nextInt(); //관객의 대기번호
		
		int []dr = {-1,0,1,0};
		int []dc = {0,1,0,-1};  //시계방향 순회를 위한 델타 설정(상,우,하,좌)
		int dir = 0;
		
		int [][]arr = new int[R+2][C+2]; //좌석을 나타낼 배열(상하좌우 1칸씩 더 크게)
		
		
		//테두리 1로 만들기
		for(int i = 0; i<R+2; i++) {
			for(int j=0; j<C+2;j++) {  
				arr[i][j] = 1;
			}
		}

		for(int i = 1; i<R+1; i++) {
			for(int j=1; j<C+1;j++) {
				arr[i][j] = 0;
			}
		}
		
		int nr = R+1; //출발지점 (R,1)
		int nc = 1;

		
		
		
		if(K>C*R) {  //좌석이 모두 배정되어 해당 대기번호의 관객에게 좌석 배정 불가한 경우 0 출력
			System.out.println(0);
		}else {
			for(int i = 1; i<=K ; i++) {  //1부터 K번째까지 돌면서 대기번호 입력
				
				if(arr[nr+dr[dir]][nc+dc[dir]]==0) { //가고자하는 방향이 0이면 진행
					
					nr+=dr[dir];
					nc+=dc[dir];
					
					arr[nr][nc]= i;
			
				}else {
					dir=(dir+1)%4; //가고자하는 곳에 숫자 채워져있으면 방향전환
				
					nr+=dr[dir];
					nc+=dc[dir];
					
					arr[nr][nc]= i; 
				}
			}
			
			System.out.println(nc + " " + (R-nr+1));  //해당 (x,y)좌표 출력
			
		}
		
	
	}//main
	
	
}//class
