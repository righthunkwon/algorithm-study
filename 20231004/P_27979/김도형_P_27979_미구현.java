package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q27979_볼링장_아르바이트 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [] arr = new int [N]; //무게 입력받기
		int [] arr_reverse = new int [N]; //거꾸로 뒤집은 배열
		
		int ans = N; //최대 N번의 이동
		
		for(int i = 0 ; i<N;i++) {
			
			arr[i]= sc.nextInt(); //
			arr_reverse[N-1-i]=arr[i];
		}
		
		
	}

}
