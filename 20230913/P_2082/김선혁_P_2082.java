import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 실버3 2082 시계
		// 총 4개의 숫자가 있고
		// 앞의 두자리는 시간, 뒤의 두자리는 분
		// 4개의 칸 각각은 세로5줄 가로3줄로 #과 .으로 구성이 되어있다.
		// #은 불이 켜져있는 것으로 4개의 시간 각각은 완전한 상태가 아니고
		// 현재 #의 위치를 만족하는 가장 빠른 시간을 찾아야함!!
		// 우선적으로 4개의 시간 세로5, 가로3줄이므로 
		// 4x5x3의 배열을 만들어준다. -> 4x15로 하려했지만 입력에서 빡세서 포기
		Scanner sc = new Scanner(System.in);
		char[][][] arr = new char[4][5][3]; // 4개를 각자 char 배열로 만듬
		// 입력받는 arr은 총 4개의 숫자를 
		// 5줄에서 각 3칸씩 입력받아야 하고
		// 나머지 숫자는 char배열로 15칸으로 통합
		// 각각 0~9까지의 숫자 
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
		// 각 i는 4개의 시간 for문을 돌려
		// 0~9까지의 시간중 j가4 k가 2를 도달하게되면 만족한다는 의미로  
		// 맞는 것을 찾는다면 i가 바뀌어야 하므로
		// a에서 break 해버리고
		// 그전에 일치하지 않는 것을 찾게된다면
		// 10개의 숫자중 현재 숫자 다음 숫자를 검사해야하므로
		// j에서 break해버림 --> 현재 불들어온 것과 2를 검사하다가 불일치 ->+1해서 3으로 검사
		for(int i=0;i<4;i++) {
			a : for(int in=0;in<10;in++) { // 0~9까지 time
				b: for(int j =0;j<5;j++) { // 세로5
					for(int k =0;k<3;k++) { // 가로3			
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
