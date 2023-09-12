package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q2589_보물섬 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Height = sc.nextInt();
		int Width = sc.nextInt();
		char [][]arr = new char[Height][Width];
		
		for(int i = 0 ; i<Height;i++) {
			String a = sc.next();
			for(int j = 0 ; j<Width;j++) {
				arr[i][j]= a.charAt(j);			//지도 입력받기
			}
		}//for i
		
		
		System.out.println(Arrays.deepToString(arr));
		
		
	}//main
	
}//class
