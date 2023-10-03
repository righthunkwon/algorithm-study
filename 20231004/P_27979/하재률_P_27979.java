package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27979_볼링장아르바이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 볼링공 개수
		int[] arr = new int[N]; // 볼링공 무게 입력받을 배열
		boolean[] chk = new boolean[N]; // 정리한 볼링공 쳌
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완
		int cnt = 0; // 정리된 볼링공 개수 카운트
		int tmp = 0; // 정리된 볼링공 무게 가장 큰 놈 저장용
		int tmpIdx = 0; // 정리된 볼링공 무게 가장 큰 놈의 인덱스 저장용
		int max = arr[0];
		// 두번째 볼링공부터 앞에 공보다 무게가 작은지 체크해나갈거야
		for(int i = 1; i < N; i++) {
			if(arr[i] < max) { // 앞에 공보다 가벼우면 정리해야된다
				chk[i] = true; // 옮겨야 할 공이라고 체크해주고
				if(arr[i] > tmp) {
					tmp = arr[i]; // 옮긴 공 중 무게 가장 큰 놈 저장
					tmpIdx = i; // 그 놈의 인덱스 저장
				}
			}
			else max = arr[i]; // 뒤에 공이 더 무거우면 max값 갱신
		}
		for(int i = 0; i < tmpIdx; i++) { // 옮긴 공 중 가장 무거웠던놈 인덱스 전까지만 for문 돌려서
			if(arr[i] < tmp && !chk[i]) chk[i] = true; // 그 놈의 무게보다 가볍고, 정리 안된놈이면 정리해주자
		}
		
		// 옮긴 공들 개수 세어주기
		for(int i = 0; i < N; i++) {
			if(chk[i]) cnt++;
		}
		
		System.out.println(cnt);
	}
}
