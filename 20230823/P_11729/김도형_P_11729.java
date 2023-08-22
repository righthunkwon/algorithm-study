package algostudy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q11729_하노이_탑 {

	static int[] Nums = { 0, 1, 2, 3 };  // 숫자 스왑을 위한 배열
	static int cnt = 0;  //옮긴 횟수 세는 변수
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    //println으로 출력했더니 시간초과 나서 bufferedWriter 씀

	public static void main(String[] args) throws IOException {
		
		

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int swapNum = 1;   

		for (int i = 0; i < N; i++) {
			swapNum = swapNum * 2; // 옮긴 횟수는 ( 2^N-1 ) 이다
		}
		swapNum = swapNum - 1;
		System.out.println(swapNum); // 옮긴 횟수 출력

// @@@@@@@@@@@@@@@@@수행 과정 출력@@@@@@@@@@@@@@@@@@@@@@@@@
	
		move(N);
		
		bw.close();
		
		
	}// main

	static public void firstswap(int[] arr) {

		int tmp = arr[2];
		arr[2] = arr[3];
		arr[3] = tmp; // 2와 3 스왑

	}

	static public void secondswap(int[] arr) {

		int tmp = arr[1];
		arr[1] = arr[2];
		arr[2] = tmp; // 1과 3 스왑

	}

	static public void move(int n) throws IOException {
		
		int X = 1;    // swapNum 과 동일

		for (int i = 0; i < n; i++) {
			X = X * 2; // 옮긴 횟수는 ( 2^N-1 ) 이다
		}
		X = X - 1;
		

		
		if (n == 1) {
			bw.write(String.valueOf(Nums[1]) + " " + String.valueOf(Nums[3])+"\n");  // 1 3 출력
			cnt++;   //출력횟수 ++
		}
		while (n > 1) {
			
			
			firstswap(Nums);  //2,3 바꾸고
			move(n - 1);      // n-1 번째 실행
			firstswap(Nums);  //2,3 다시 원위치
		
			bw.write(String.valueOf(Nums[1]) + " " + String.valueOf(Nums[3])+"\n");   // 1 3 출력
			
			secondswap(Nums); //1,3 바꾸고
			move(n - 1);      // n-1번째 실행
			secondswap(Nums); // 1,3 원위치
			
			cnt++;		////출력횟수 ++
			n--;		// 재귀함수를 위해 n 하나씩 줄여감
			
			if(cnt>=X)
				break;   //   swapNum 만큼의 줄을 출력했으면 멈추기
			

		}

	}

}// class
