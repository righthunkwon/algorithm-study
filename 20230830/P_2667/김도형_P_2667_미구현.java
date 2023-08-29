package silver;

import java.util.Scanner;

public class BaekJoon_Q2667_단지번호붙이기 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정사각형 지도의 크기 N 
		
		int[][]arr = new int [N][N]; // N*N 배열 생성
		
		
		for(int i=0; i<N;i++) {
			
			String str = sc.next(); //띄어쓰기 없으니까 문자열로 받아서 쪼갠다
			
			for(int j=0;j<N;j++) {
				
				arr[i][j]= str.charAt(j)-'0'; //문자열을 문자로, 문자를 다시 정수형으로 형변환해 넣어줌
				
			}
		}
			
			
			
	}
	
	
	
	
	
}
