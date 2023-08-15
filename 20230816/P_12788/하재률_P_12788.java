package Algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 하재률_P_12788 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // CTP 회원 수
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 참가한 팀의 수
		M *= Integer.parseInt(st.nextToken()); // 팀 구성시 필요한 팀원 수
		
		// 기본 타입인 int는 Collections.reversOrder() 사용 불가능하기 때문에 Wrapper클래스(Integer)로 박싱해준다
		Integer[] arr = new Integer[N]; // CTP 회원이 가지고 있는 펜의 수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int sum = 0; // 합 저장용
		int res = 0; // 결과 저장용
		boolean isEmpty = false;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
			if(sum >= M) {
				res = i;
				isEmpty = true;
				break;
			}
		}
		if(isEmpty) {
			System.out.println(res + 1);
		} else System.out.println("STRESS");
		
	}
}
