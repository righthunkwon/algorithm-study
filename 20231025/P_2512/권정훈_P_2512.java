package level_27_binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 예산
// 특정 값을 찾을 때 시간초과의 우려가 생긴다면 이진탐색을 활용하자
// st, ed, mid는 인덱스로 잡을 수도 있지만 값으로 잡아 문제를 풀 수도 있다. 

// 이진탐색
// (1) 초기 탐색 범위는 배열 전체
// (2) st, mid, ed 설정

// (3) mid와 key를 비교
// (3-1) mid == key 이면 탐색 종료
// (3-2) mid < key 이면 st = mid + 1로 인덱스를 재설정 후 탐색
// (3-3) mid > key 이면 ed = mid - 1로 인덱스를 재설정 후 탐색

// (4) 만약 st > ed가 되면 일치하는 key가 존재하지 않음
public class P_2512 {
	
	private static int n, m, st, ed, mid, ans, sum;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		n = Integer.parseInt(br.readLine()); // 지방의 수
		arr = new int[n]; // 예산 배열
		ans = 0; // 배정된 예산 중 최대

		// 지방의 예산요청
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(arr); // 이진탐색을 위한 정렬
		m = Integer.parseInt(br.readLine()); // 총 예산
		
		// 예산합 구하기
		for (int num : arr) {
			sum += num;
		}
		
		// 이분탐색이 필요없을 경우(그대로 배정)
		if (sum <= m) {
			ans = arr[n-1]; // 최대값은 그냥 최댓값
		} 
		
		// 이분탐색이 필요할 경우(상한액 설정 후 배정)
		else {
			st = 0; // 시작
			ed = arr[n-1]; // 끝
			binarySearch(st, ed);
		}
		
		System.out.println(ans);
	}
	
	private static void binarySearch(int st, int ed) {
		while(st <= ed) {
			mid = (st + ed) / 2; // 최대 배정 예산(매번 갱신)
			sum = 0; // 초기화
			
			// 예산합 구하기
			for (int num : arr) {
				if (num < mid) {
					sum += num; 
				} else {
					sum += mid;
				}
			}
			
			// 예산 합이 한도 범위 내인 경우 더 최선이 있는지 찾아본다.
			if (sum <= m) {
				st = mid + 1;
				ans = Math.max(ans, mid);
			} 
			
			// 예산 합이 한도를 초과한 경우 상한액 기준점을 낮춘다.
			else {
				ed = mid - 1;
			}
		}
		
	}
}
