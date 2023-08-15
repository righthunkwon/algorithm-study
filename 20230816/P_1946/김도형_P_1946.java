Q1946_신입사원


package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1946_신입사원 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) { //tc만큼 반복
			
			
			
			int N = sc.nextInt(); //지원자의 숫자 입력받기
			
			int max = N; //뽑을 수 있는 최대 사람 수 초기화
			
			int [] rank = new int [N];  //면접 순위를 정렬
				
			
			for(int i=0;i<N;i++) { //입력 for문
				int a = sc.nextInt();    //서류 순위 입력
				rank[a-1]=sc.nextInt();    //면접 순위 입력 (순위는 1부터인데 인덱스는 0부터니까 a-1 해줌)=>서류순위대로 면접순위 정렬됨
			}
			
			int minRank=rank[0]; //서류 1등의 면접순위 (이거보다 등수가 크면 탈락!)

			for(int i=1;i<N;i++) { //서류 2등부터 비교시작
				if(rank[i]>minRank) {
					max--;
				}else {
					minRank=rank[i];
				}
				
			}
			
			System.out.println(max);
			
			
		} //tc for문
		
		
	}

}
