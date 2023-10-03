package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q1049_기타줄 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //필요한 기타줄 수
		int M = sc.nextInt(); //브랜드 수
		
		int []pack = new int[M]; //패키지 가격 넣을 배열
		int []each = new int[M]; //낱개 가격 넣을 배열
		
		for(int i = 0; i<M;i++) {
			
			pack[i]=sc.nextInt();
			each[i]=sc.nextInt();
			
		}
		
		Arrays.sort(pack); //패키지 최소가격 구하기 위해 오름차순 정렬
		Arrays.sort(each); //낱개 최소가격 구하기 위해 오름차순 정렬
		
		int minpack = pack[0];
		int mineach = each[0];
		//낱개가격*6보다 패키지 가격이 비싸면 낱개로 다 사야함
		//낱개가격이 상식적으로 패키지 가격보다 비싸진 않겠지...???
		//그렇지 않으면 패키지+낱개로 딱 떨어지게 사거나 또는 패키지로만 여유있게 산다
		
		int ans = 0; //정답 초기화
		
		if (mineach*6 <= minpack) {
			
			ans = N*mineach;
			
		}else {
			
			ans = Math.min(((N/6) * minpack + (N%6)*mineach), (N/6+1)*minpack);
			
			
		}
		
		System.out.println(ans);
		
		
		
	}

}
