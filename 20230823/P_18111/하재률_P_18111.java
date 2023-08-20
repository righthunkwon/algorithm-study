package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111_마인크래프트 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		int max = 0; // 지금 제일 높은 땅 높이 저장용
		int min = 256; // 지금 제일 낮은 땅 높이 저장용
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > max) max = arr[i][j]; // 최소값 저장
				if(arr[i][j] < min) min = arr[i][j]; // 최대값 저장
			}
		}
		
		int minTime = Integer.MAX_VALUE; // 땅고르기 걸리는 최소 시간 저장용
		int height = 0;  // 고른 뒤 땅 높이 저장용
		// 고른 땅의 높이는 최저높이 ~ 최고높이 사이야
		for(int h = min; h <= max; h++) {
			int tmp = B; // 블럭의 개수 초기화
			int time = 0; // h 높이일때 걸리는 시간
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 지금 위치가 h보다 작으면 쌓기. 블럭당 1초
					if(arr[i][j] < h) {
						tmp -= (h - arr[i][j]);
						time += (h - arr[i][j]);
					// 크면 제거. 블럭당 2초
					} else if(arr[i][j] > h){
						tmp += (arr[i][j] - h);
						time += ((arr[i][j] - h) * 2);
					}
				}
			}// 높이당 한 사이클 검사 for문
			// 블럭이 0개 미만이면 break
			if(tmp < 0) break;
			// 최소 시간 갱신
			if(time <= minTime) {
				minTime = time;
				height = h;
			}
		}// 전체 for문
		System.out.println(minTime + " " + height);		
	}
}
