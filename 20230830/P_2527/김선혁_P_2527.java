package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 먼저 위에 있는 것부터 구해보자
		// 난 좌표바꾸기 귀찮아서 위에서부터 구현할래
		for(int tc=1;tc<=4;tc++) {
			int[][] arr = new int[4][2];
			for(int i =0;i<4;i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();					
			}


			if(arr[0][0]>arr[3][0] || arr[0][1] > arr[3][1] || arr[1][0] < arr[2][0] || arr[1][1] < arr[2][1]){
				System.out.println("d");
			}
			// 가짓수
			// 높이가 같을때 큰 좌표와 작은좌표 x좌표가 같음
			else if((arr[1][1] == arr[2][1] && arr[1][0] == arr[2][0]) || (arr[0][1] == arr[3][1] && arr[0][0] == arr[3][0]) ||
					(arr[1][1] == arr[2][1] && arr[0][0] == arr[3][0]) || (arr[1][0] == arr[2][0] && arr[0][1] == arr[3][1])){
				System.out.println("c");
			}

			else if(arr[1][0] == arr[2][0] || arr[0][0] == arr[3][0] || arr[1][1] == arr[2][1] || arr[0][1] == arr[3][1]) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}


		}
	}


}
