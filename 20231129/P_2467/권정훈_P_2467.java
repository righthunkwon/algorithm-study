package level_33_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액
// 투포인터
public class P_2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		int n = Integer.parseInt(br.readLine()); // 용액의 수  
		int[] arr = new int[n]; // 용액
		
		// 용액 배열 요소 입력
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		
		int min = Integer.MAX_VALUE; // 최소값
		int st = 0; // 시작
		int ed = n - 1; // 끝
		int idx1 = 0; // 작은 값의 인덱스
		int idx2 = 0; // 큰 값의 인덱스
		
		while (st < ed) {
			int sum = arr[st] + arr[ed];
			
			// 최소가 되는 특성값 갱신 
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				idx1 = st;
				idx2 = ed;
			}
			
			// 합이 0보다 크면 큰값을 감소시키고
			// 합이 0보다 작으면 작은 값을 증가시킨다.
			if (sum > 0) {
				ed--;
			} else {
				st++;
			}
		}
		System.out.println(arr[idx1] + " " + arr[idx2]);
	}
}
