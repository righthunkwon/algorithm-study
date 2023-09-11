package silver;

import java.util.Scanner;

public class BaekJoon_Q2563_색종이 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [][]arr = new int[101][101]; // 1~100 좌표를 가로 세로 크기로 가지는 흰 도화지를 담을 배열 생성 
		
		int N = sc.nextInt();  //색종이 수 N
		
		for(int paper = 0 ; paper<N; paper++) { //색종이 하나씩 칠해주기
			
			int x = sc.nextInt();
			int y = sc.nextInt();
		
			for(int i=x;i<x+10;i++) {    //가로세로 10씩을 1로 만들어줌 
				for(int j=y;j<y+10;j++) {   
					
					arr[i][j]=1;   //중복이 되더라도 1을 더해주는게 아니라 나중에 한번에 더해주면 칠해진 영역 구할 수 있음
					
				}
			}

		}//paper
		
		int ans = 0;
		
		for(int i = 1;i<101;i++) {
			for(int j =1; j<101;j++) {
				
				ans+=arr[i][j];    //도화지 모든 부분 탐색하면서 더해주면 칠해진 영역 넓이다
				
			}
		}
		
		System.out.println(ans);
		
		
	}//main

}
