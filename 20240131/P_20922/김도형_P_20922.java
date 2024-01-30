package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q20922_겹치는_건_싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수열의 길이 
		int K = Integer.parseInt(st.nextToken()); //같은 정수 K개 이하로 포함하도록..
		int []arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력 끝
		int []cnt = new int[100001]; //갯수 체크용
		int maxleng = 0; //정답 초기화
		int start = 0;
		cnt[arr[start]]=1;
		for(int end=1;end<N;) {
			if(cnt[arr[end]]+1 <= K) { //현재 연속수열 다음에 오는 원소를 넣었을 때 조건 충족하면 수열에 추가
				cnt[arr[end]]++;
				end++;
				maxleng = Math.max(maxleng, end-start);
			}else {
				cnt[arr[start]]--;
				start++;
			}
		}//for
		System.out.println(maxleng);
	}//main
}//class
