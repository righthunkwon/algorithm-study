package AlgoStudy;

import java.util.Scanner;

public class BaekJoon_Q14466_소가_길을_건너간_이유6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N * N 목초지
		int K = sc.nextInt(); // K마리의 소 (1~100, K<=N^2)
		int R = sc.nextInt(); //R줄에 걸쳐 길 주어짐
		
		int [][]arr = new int [R][4];
		
	
		for(int i = 0; i<R; i++) { 
			
			arr[i][0]=sc.nextInt(); //r
			arr[i][1]=sc.nextInt(); //c
			arr[i][2]=sc.nextInt(); //r'
			arr[i][3]=sc.nextInt(); //c'
			
		}
		
		int [][] cow = new int [K][2];
		
		for(int i=0; i<K; i++) {
			
			cow[i][0]=sc.nextInt(); //소의 위치(행)
			cow[i][1]=sc.nextInt(); //소의 위치(열)
			
		}
		
		// gg..
		
		
	}
}
