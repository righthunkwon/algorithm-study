package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q2638_치즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //세로
		int M = sc.nextInt(); //가로
		int [][]arr = new int[N][M];
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		//입력 끝
		
		System.out.println(Arrays.deepToString(arr));

		/*
		 * 1. 일단 외부공기를 전부 -20으로 바꿔줌(by BFS)
		 * 2. 배열 탐색하다가 치즈 만나면 사방의 합을 구해보고 -17보다 작으면 스택에 위치정보 넣기
		 * 3. 탐색 다 했으면 스택에 들어간 위치들 빼면서 다 -20으로 바꿔주고
		 * 	  녹을 위치 주변에 0이 있다면 BFS를 통해 -20으로 만들어주고 count +1
		 * 4. count 출력
		 * 
		 * */
		
		
	}//main
	
	
	public static void bfs() {
		
		
	}
	
	
	
}//class
