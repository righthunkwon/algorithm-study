import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		char[][][] arr = new char[4][5][3]; // 4개를 각자 char 배열로 만듬
		// 입력받는 arr은 총 4개의 숫자를 
		// 5줄에서 각 3칸씩 입력받아야 하고
		// 나머지 숫자는 char배열로 15칸으로 통합
		char []t0 =  "####.##.##.####".toCharArray();
		char []t1 =   "..#..#..#..#..#".toCharArray();
		char []t2 =   "###..#####..###".toCharArray();
		char []t3 = "###..####..####".toCharArray();
		char []t4 =  "#.##.####..#..#".toCharArray();
		char []t5 =  "####..###..####".toCharArray();
		char []t6 =   "####..####.####".toCharArray();
		char []t7 = "###..#..#..#..#".toCharArray();
		char []t8 = "####.#####.####".toCharArray();
		char []t9 =  "####.####..####".toCharArray();
		// 0부터 9까지 각 char배열 
		// 문제에 나와있는데로 입력한다.
		// 각 입력이 끝나면 time이라는 2차원 배열에
		// 15개의 char를 포함하고 있는 1차원 배열을 총 10줄 선언 
		char[][] time = new char[][] { t0,t1,t2,t3,t4,t5,t6,t7,t8,t9};	// 시간저장
				
			for(int j =0;j<5;j++) { // 한줄씩 입력받으면 i와 j가 반대로 되어야 입력이 잘됨
				for(int i =0;i<4;i++) {
				String tmp = sc.next();
				arr[i][j] = tmp.toCharArray(); // char 배열로 저장
			}
		}	
//		for(int i =0;i<4;i++) {
//			for(int j =0;j<5;j++) {
//				for(int k=0;k<3;k++) {
//					System.out.print(arr[i][j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}		
		
		int[] ans = new int[4]; // 각 정답의 숫자를 저장할 배열 ans
		int index=0; // ans의 저장 index
		for(int i=0;i<4;i++) {
			a : for(int in=0;in<10;in++) {
				b: for(int j =0;j<5;j++) {
					for(int k =0;k<3;k++) {						
						if(arr[i][j][k] == '#') {
							if(arr[i][j][k] != time[in][j*3+k]) { // 입력이 #일때 숫자가 .이면 
								break b; // 다음숫자를 검사하기 위해 break b
							}
						}
						if(j==4 && k==2) { // break를 거치지 않고 끝까지 가면
							ans[index++] = in; // 해당 숫자(최소) 만족하기 때문에 break a 
							break a;
						}
					} // k
				} // j
			} // in

		} // i
		for(int i =0;i<4;i++) {
			System.out.print(ans[i]);
			if(i==1) { // 출력양식 : i가 2번째 지나고 :을 넣어줌
				System.out.print(":");
			}
		}



	}

}
