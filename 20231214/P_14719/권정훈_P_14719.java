package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
// 각 인덱스 별로 부분적으로 생각
// 각 인덱스를 기준으로 왼쪽과 오른쪽의 최대 높이를 찾고,
// 그 높이 중 작은 값과 인덱스의 높이 만큼은 물이 차므로 누적합
public class P_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken()); // 세로
		int w = Integer.parseInt(st.nextToken()); // 가로
		int ans = 0; // 빗물의 누적합
		int[] arr = new int[w]; // 높이 배열
		
		// 높이 배열 값 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 처음과 마지막을 제외한 빗물 계산
		for (int i = 1; i < w - 1; i++) {
			int left = 0; // 왼쪽 높이
			int right = 0; // 오른쪽 높이

			// 현재 인덱스를 기준으로 왼쪽 최대 높이 찾기
			for (int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}

			// 현재 인덱스를 기준으로 오른쪽 최대 높이 찾기
			for (int j = i + 1; j < w; j++) {
				right = Math.max(arr[j], right);
			}

			// 현재 인덱스의 높이가 
			// 왼쪽 최대 높이와 오른쪽 최대 높이 모두보다 작을 경우에만
			// 둘의 최대 높이 중 작은 높이와 현재 높이의 차이만큼 빗물이 찬다.
			if (arr[i] < left && arr[i] < right) {
				ans += Math.min(left, right) - arr[i];
			}
		}
		System.out.println(ans);
	}
}
