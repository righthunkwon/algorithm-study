Q12788_IUPC개최될수있을까

package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q12788_IUPC {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //CTP 회원 수
		
		int M = sc.nextInt(); //참가팀 수
		int k = sc.nextInt(); //팀당 팀원 수
		
		int []A=new int[N]; //각자 가진 펜의 수 넣을 배열
		for(int i = 0 ; i<N; i++) {
			A[i]=sc.nextInt(); //팬의 수 배열에 넣기
		}
		
		Arrays.sort(A);
		
		
		
		int pen=0;
		int cnt=0;   //팬을 빌려준 회원 수
		for(int i=N-1;i>=0;i--) {  //팬 많이 가진 회원꺼부터 빌리기 시작
			pen=pen+A[i];
			cnt++;
			if(pen>=M*k)	//@@@@@@@ > 라고 했다가 틀림..
				break;            //필요한 팬 숫자 넘어가면 for문 끝내기
			else
				continue;

		}
		if(pen<M*k)
			System.out.println("STRESS");  // 이거 안썼다가 틀림..
		else
			System.out.println(cnt);   
		
		
		
	}

}
