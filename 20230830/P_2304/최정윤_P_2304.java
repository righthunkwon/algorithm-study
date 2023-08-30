package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//문제를 읽고 하고 싶었던 것은 위치 순서대로 높이를 저장하는 것
		//위치를 인덱스로, 그 위치의 높이를 위치 인덱스의 값으로 넣고싶다.
		//최대 위치를 알아야 배열 생성가능
		//최소 위치는 for문 덜 돌기위해
		//최대 높이는 기준점이기 때문에  구한다
		//최대 위치, 최소위치, 최대높이 받기
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N]; 			 //위치
		int[] H = new int[N];// 일단 값저장  //높이
		int maxL = 0, minL = 1000;//N이 1000이 최대값
		int maxH = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
			maxL = Math.max(maxL, L[i]);
			maxH = Math.max(maxH, H[i]);
			minL = Math.min(minL, L[i]);
		} // 입력끝

		int[] arr = new int[maxL + 1];// 1부터
		for (int i = 0; i < N; i++) {
			arr[L[i]] = H[i];
		} // arr인덱스가 기둥자리 값이 높이
		int i;
		int high = 0;
		int result = 0;
		//한칸의 넓이= 한칸의 높이: 높이를 더하면 된다.
		//1)위치가 작은 것부터 ~ 최대높이위치전까지
		//오목한 부분이 나오면 안되기 때문, 자신의 높이가 아닌 현재까지의 최대높이를 더해주어야한다.
		
		for (i = minL; i <= maxL && arr[i] != maxH; i++) {
			if (arr[i] > high) {
				high = arr[i];
			}
			result += high;
		}
		//최대높이 더해주고
		result += maxH;
		
		//2)위치가 제일 큰 것부터 ~ 최대 높이 후까지
		//위에서 최대높이일때의 i값에서 끝났기 때문에 i보다 큰 인덱스까지 돌면 된다.
		high = 0;		
		for (int j = maxL; j > i; j--) {
			if (arr[j] > high) {
				high = arr[j];
			}
			result += high;
		}
		System.out.println(result);
	}
}
