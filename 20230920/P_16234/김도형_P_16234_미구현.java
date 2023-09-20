package gold;

import java.util.Scanner;

public class BaekJoon_Q16234_인구_이동 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		int L = sc.nextInt();  //국경선 공유 두 나라 인구차이 L 이상 R 이하면 국경선 하루 연다..
		int R = sc.nextInt();
		
		int [][] arr = new int [N][N]; //N*N 크기의 땅
		

		for(int i = 0 ; i<N;i++) {
			for(int j=0; j<N ; j++) {
				
				arr[i][j] = sc.nextInt();  //인구 입력 끝
				
			}
		}
		
		//인구 이동 끝
		
		
		
		
	}//main

}//class
