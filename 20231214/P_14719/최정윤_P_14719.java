package baek;

import java.util.*;
import java.io.*;
//인덱스별로
//왼쪽부터 고일 수 있는 최대 왼쪽 높이를 저장하고
//오른쪽부터 고일 수 있는 최대 오른쪽 높이를 저장한다.
//ex) 왼쪽 높이 3 오른쪽 높이 5이면 더 작은 3만큼의 물이 고인다.
public class Pro_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[W];
		int[] left_h = new int[W];
		int[] right_h = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력끝

		// 왼쪽부터 본인 전 가장 높은 높이로 저장
		int high = 0;
		for (int i = 0; i < W; i++) {
			high = Math.max(high, arr[i]);
			left_h[i] = high;
		}
		// 오른쪽부터 본인 전 가장 높은 높이로 저장
		high = 0;
		for (int i = W - 1; i >= 0; i--) {
			high = Math.max(high, arr[i]);
			right_h[i] = high;
		}
		// 두개중 min 값이 빗물이 쌓일 수 있는 높이이다.(각 인덱스 별로)
		int rain = 0;
		for (int i = 0; i < W; i++) {
			if (arr[i] < Math.min(left_h[i], right_h[i])) {
			     rain += Math.min(left_h[i], right_h[i]) - arr[i];
			}
		}
		System.out.println(rain);

	}
}
