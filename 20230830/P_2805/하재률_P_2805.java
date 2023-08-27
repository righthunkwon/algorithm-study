package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 범위가 크니 계산하는 정수들은 long으로 선언해주도록 하자
		int N = Integer.parseInt(st.nextToken()); // 나무의 수 1 <= N <= 1,000,000 
		int M = Integer.parseInt(st.nextToken()); // 상근이가 가져가려는 나무의 길이 1 <= M <= 2,000,000,000
		int[] arr = new int[N];
		long end = 0; // 입력 받으면서 제일 긴 나무 찾을거야
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 나무의 길이는 0 <= x <= 1,000,000,000 
			if(end < arr[i]) end = arr[i];
		}
		long start = 0; // 이진 탐색을 위한 start값 초기화
		long mid = 0; // 이진 탐색을 위한 mid값
		long res = 0; // 결과값 저장용
		// 이진 탐색 시작
		while(start <= end) { // start가 end보다 작거나 같을때만 반복한다
			long total = 0; // total은 탐색 한 번 할 때마다 초기화 시켜줘야해
			mid = (start + end) / 2; // mid값 (각 나무를 어디서 자를건지.. 처음은 중간부터 잘라보고 M 값과 비교하는 방식이야)
			for(int i = 0; i < N; i++) {
				if(arr[i] > mid) total += (arr[i] - mid); // 위에서 설정한 mid값으로 잘라서 나무를 얼마나 가져갈 수 있는지 total에 저장
			}
			if(total < M) { // 자른게 가져가야할거보다 작으면 더 잘라야해(mid 기준 왼쪽으로 탐색)
				end = mid  - 1;
			} else { // 자르게 가져가야할거보다 많으면 덜 잘라야해(mid기준 오른쪽 탐색)
				res = mid;
				start = mid + 1;
			}
		}
		System.out.println(res);
	}
}