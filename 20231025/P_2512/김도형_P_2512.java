package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q2512_예산 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //지방의 수 N
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		Long [] arr = new Long[N];
		for(int i = 0; i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken()); //각 지방의 예산요청 입력받기
		}
		Long totalBudget = Long.parseLong(br.readLine());  //국가예산의 총액 입력
		//입력끝
		
		Arrays.sort(arr);  //오름차순 정렬

		//이분탐색을 위한 변수 선언
		Long start = 0L;
		Long end = arr[N-1];
		
		while(start<=end) {
			Long mid = (start+end)/2;
			long budget = 0; //반복문 돌면서 그때마다의 예산총액을 구하기 위해 변수 초기화
			for(int i=0; i<N;i++) { //배열을 돌면서 배정액들을 더해줌 
				
				//                  start            mid=123             end
				//123이 상한액일때..  111  121  122  122  124  127  129 ... 155
				// 배정되는 액수는    111  121  122  122  123  123  123 ... 123 
				if(arr[i]<=mid) { //상한액 이하의 예산요청은 요청 금액 그대로 배정
					budget += arr[i];
				}else { //상한액을 초과한 요청에는 상한액만큼의 금액을 배정
					budget +=mid;
				}
			}
			if(budget<=totalBudget) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}//while
		
		System.out.println(end);  //배정된 예산중 최대값은 end를 출력하면 됨
	}//main
}//class
