package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1417_국회의원선거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 후보의 수
		int[] arr = new int[N];
//		int max = 0;
//		int idx = 0;
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}// 입력 완료
		
		////////////////////// 그냥 이렇게도 풀어보았다..
		// N이 1일땐 걍 0 출력해버리자
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		int dasom = arr[0]; // 굳이 저장해줄 필요 없지만 가독성을 위해
		Arrays.sort(arr, 1, N); // 다솜이 빼고 정렬
		
		while(dasom <= arr[N-1]) { // 마지막 인덱스가 최댓값이니까
			dasom++; // 다솜이 득표수 증가
			arr[N-1]--; // 최대 득표 후보 득표수 감소
			ans++; // 조작완료++
			Arrays.sort(arr); // 다시 정렬하기
		}
		
		/////////////////// 원래 이렇게 풀었는데요
//		for(int i = 1; i < N; i++)
//		if(arr[i] > max) {
//			max = arr[i]; // 최대 득표수 구하기
//			idx = i; // 최대 득표수 후보의 idx구하기
//		}
//		
//		// 다솜이가 최대 득표수가 되면 while탈출
//		while(arr[0] <= max) {
//			arr[0]++; // 다솜이 득표수 하나 올리고
//			arr[idx]--; // 최대 득표 후보 하나 빼고
//			max = 0; // 최대값 초기화
//			ans++; // 조작완료++
//			
//			// 다시 최대 득표수와 그 후보idx 구해주기
//			for(int i = 1; i < N; i++) {
//				if(arr[i] > max) {
//					max = arr[i];
//					idx = i;
//				}
//			}
//		}
		System.out.println(ans);
		
	}
}
