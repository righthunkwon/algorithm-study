package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] sol = new int [N];
		for(int i=0;i<N;i++) {
			sol[i]=Integer.parseInt(st.nextToken());
		}// 입력 끝
		
		//  ans를 최댓값으로 설정한다.
		int ans = Integer.MAX_VALUE;
		// left는 sol배열 외쪽부터 탐색하고, right는 오른쪽부터 탐색을 시작한다
		int left=0, right=N-1;
		// 임시로 값을 저장할 a,b를 만든다
		int a=0, b=0;
		// 왼<오 일동안 반복문 진행한다
		while(left<right) {
			int sum = sol[left]+sol[right];
			// 더 작은 값을 ans에 저장한다
			ans = Math.min(ans,Math.abs(sum));
			// ans값이 갱신될때, a,b에 해당 용액의 값을 저장한다
			if(ans==Math.abs(sum)) {
				a = sol[left];
				b = sol[right];
			}
			// sum 값이 0보다 크고 작은지에 따라 다음 더할 용액값을 정한다
			// sum 값이 0일 경우 더이상 지속할 필요가 없으므로 나간다
			if(sum<0) left++;
			else if(sum>0) right--;
			else break;
		}
		// 이미 sol 배열은 sort가 된 상태이고 a,b값도 a<b인게 명확하므로
		// a, b를 차례대로 출력한다.
		System.out.println(a+" "+b);
		
		
		////// 이건 시간초과난 풀이ㅜㅜ

//		out: for(int i=0;i<N;i++) {
//			for(int j=N-1;j>=0;j--) {
//				int sum = 0;
//				if(i<j) {
//					sum = sol[i] + sol[j];
//					ans = Math.min(ans, Math.abs(sum));
//					if(ans == Math.abs(sum)) {
//						a = sol[i];
//						b = sol[j];
//					}
//					if(ans==0) break out;
//				}
//			}
//		}
//		System.out.println(Math.min(a, b)+" "+Math.max(a, b));
	} //main

}
