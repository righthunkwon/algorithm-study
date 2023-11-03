package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q1105_팔 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String L = sc.next();
		String R = sc.next();
		
		int l = L.length();
		int r = R.length();
		
		if(l!=r) { //두 숫자 자릿수가 다르면 0 출력하고 끝
			System.out.println(0);
			return;
		}
		int idx=0; //확인해볼 숫자의 자리수(맨 앞자리부터 확인예정)
		int cnt=0; //최소 8 갯수 카운트
		
		while(true) {
			if(idx>=l)break;  //모든 자릿수 확인했으면 break
				
			if(L.charAt(idx)!=R.charAt(idx)) break; //해당 자리 숫자 비교해서 다르면 break

			if(L.charAt(idx)=='8')cnt++; //해당자리 숫자가 8로 같으면 8이 무조건 1개 포함되니까 1더해주고
										// 다음자리 숫자 확인
			idx++; 
		}
		System.out.println(cnt);
	}

}
