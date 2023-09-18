package silver;

import java.util.HashSet;
import java.util.Scanner;

/*
 *  1 i x : i번째 기차의 x번째 좌석에 사람 타기
 *  2 i x : i번째 기차의 x번쨰 좌석 사람 내리기
 *  3 i : i번째 기차의 승객 모두 한칸씩 뒤로 이동. k번째 -> k+1번쨰 좌석 .. 20번째 앉았던 사람 하차
 *  4 i : i번쨰 기차의 승객 모두 한칸씩 앞으로 이동. k -> k-1 .. 1번째 앉았던 사람 하자
 *  
 *  1 => 비트마스킹 and 연산으로 사람 추가    A |= (1<<x)   
 *  2 => 비트마스킹   A &= ~(1<<x)
 *  3 => A * 2 하고  A &= ~(1<<21)  
 *  4 => A / 2 
 * */

public class BaekJoon_Q15787_기차가_어둠을_헤치고_은하수를 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 기차의 수
		int M = sc.nextInt(); // 명령의 수

		int[] arr = new int[N+1]; // 기차 담을 배열 (초기값 0)

		int trainNum ;
		int seatNum ;

		for (int i = 0; i < M; i++) { // 명령만큼 반복

			int a = sc.nextInt(); // 명령어 받기

			switch (a) {

			case 1:
				trainNum = sc.nextInt(); // A번쨰 기차임을 입력받음
				seatNum = sc.nextInt() -1 ;// x번쨰 좌석임을 입력받음(0~19좌석)
				
				arr[trainNum] |= (1<<seatNum); //seatNum번쨰 추가

				break;
			case 2:
				trainNum = sc.nextInt(); // A번쨰 기차임을 입력받음
				seatNum = sc.nextInt()-1;// x번쨰 좌석임을 입력받음
				
				arr[trainNum] &= ~(1<<seatNum); //seatNum번쨰 삭제
				
				break;
			case 3:
				trainNum = sc.nextInt(); // A번쨰 기차임을 입력받음
				
				arr[trainNum] = arr[trainNum]*2; //한칸씩 뒤로 밀고
				arr[trainNum] &= ~(1<<20);  //밀려서 20번째 좌석에 사람 앉으면 하차시킴
				break;
			case 4:
				trainNum = sc.nextInt(); // A번쨰 기차임을 입력받음
				
				arr[trainNum]=arr[trainNum]/2; //한칸씩 앞으로 밀고 1번쨰 사람은 버려짐
				break;

			}// switch
			
		} // for
		
//================================명령어 끝 =========================================
		
		HashSet<Integer> hash = new HashSet<>();  
		for(int i = 1;i<N+1;i++) {  //  (i = 0 ; i<N ; i ++)  이라고 했다가 틀림 ㅠㅠㅠ
			hash.add(arr[i]);
		}
		
		System.out.println(hash.size());
		
		
	}//main

}//class
