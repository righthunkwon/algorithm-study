package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q3343_장미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong(); //구매할 장미 N개
		long A = sc.nextLong(); //첫 꽃집 꽃다발 당 장미 A개
		long B = sc.nextLong(); //첫 꽃집 꽃다발 가격 B
		long C = sc.nextLong(); //두번째 꽃집 꽃다발 당 장미 C개
		long D = sc.nextLong(); //두번째 꽃집 꽃다발 가격 D

		long minCost = Long.MAX_VALUE; //최소비용 초기화
		
		//B÷A 랑 D÷C랑 비교해서 구분 (뭐가 더 싸게 사는건지)
		long cheapCnt,cheapP,expensiveCnt,expensiveP;
		
		if(B*C < A*D) { //장미 개당 가격 첫 꽃집이 더 쌀 때
			cheapCnt=A; 
			cheapP=B;
			expensiveCnt=C;
			expensiveP=D;
		}else {//두번쨰 꽃집이 더 쌀 때
			cheapCnt=C;
			cheapP=D;
			expensiveCnt=A;
			expensiveP=B;
		}
		
		for (int i = 0; i < cheapCnt; i++) { 
			//최소공배수 개념에 의해 더 비싼 꽃다발은 더 싼 꽃다발 구성 장미 갯수보다 많이 구매할 필요x
			//why? 그럴바엔 싼 꽃다발 사는게 무조건 이득..
			
			//(꽃 개당 가격이)비싼 꽃다발 i개 구매했을 때, 싼 꽃다발 필요 갯수 j개
		    long j = (long)Math.ceil((double)(N-i*expensiveCnt)/cheapCnt);
		    if(j<0) {
		    	j=0; //j가 음수가 될수는 없으니..
		    }
		    minCost = Math.min(minCost, i*expensiveP+j*cheapP);
		    if(j==0) {
		    	break; //j가 0개 되면 끝내
		    }
		}
		System.out.println(minCost);
	}
}



