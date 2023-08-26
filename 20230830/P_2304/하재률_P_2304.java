package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
	public static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		height = new int[1001]; // 높이들을 담을 배열. index는 좌표다
		
		int stIdx = 987654321; // 시작 좌표
		int endIdx = -1; // 마지막 좌표
		int topIdx = 1; // 제일 높은 가진 기둥 좌표
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			stIdx = Math.min(stIdx, L);
			endIdx = Math.max(endIdx, L);
			height[L] = H;
			if(height[topIdx] < height[L]) topIdx = L; // 젤 높은기둥 좌표 저장
		}
		// 왼쪽 + 최대 높이 + 오른쪽
		int res = left(stIdx, topIdx) + height[topIdx] + right(endIdx, topIdx);
		
		System.out.println(res);
		
	}
	// 왼쪽 영역 계산
	public static int left(int x, int y) {
		int sum = 0;
		int high = 0;
		for(int i = x; i < y; i++) {
			high = Math.max(high, height[i]); // 계단식으로 더 커지면 저장하자
			sum += high;
		}
		return sum;
	}
	
	// 오른쪽 영역 계산 -> 왼쪽 영역 반대로
	public static int right(int x, int y) {
		int sum = 0;
		int high = 0;
		for(int i = x; i > y; i--) {
			high = Math.max(high, height[i]);
			sum += high;
		}
		return sum;
	}
}
