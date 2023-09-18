package silver;

import java.util.Scanner;

public class BaekJoon_Q1417_국회의원_선거 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 후보의 수 N

		int[] arr = new int[N - 1]; // N-1개짜리 배열 생성

		int cnt = 0; // 매수할 사람 수

		int X = sc.nextInt(); // 다솜이 예상 득표 수


		for (int i = 0; i < N - 1; i++) {

			arr[i] = sc.nextInt(); // 다솜이 제외 후보들 예상 득표 수 입력받기

		}


		while (true) {
			int maxidx = 0; // 최다 득표 예상자 index
			int max = 0; // 최다 득표 수 초기화
			
			if(N<=1) {  
				break;    //단일 후보면 cnt 0인 상태로 끝냄
			}

			for (int i = 0; i < N - 1; i++) {
				if (arr[i] > max) {
					max = arr[i];    // 최대 득표 수 구하고
					maxidx = i;     // 최다 득표예상자의 index
				} 
			}



			if (max >= X) {   //다솜이가 최다 득표 아니면
				arr[maxidx]--;     //최다 득표예정자 표 -1
				X++;               //다솜이 표 +1
				cnt++;             //매수 횟수 +1
			} else
				break;

		}

		System.out.println(cnt);

	}// main

}// class
