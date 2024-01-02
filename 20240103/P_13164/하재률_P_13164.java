package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164_행복유치원 {
	/*
	 * 정렬된, 인접한 학생들 키의 차이를 하나 선택할때마다,
	 * 해당하는 둘을 한 그룹으로 묶는다는 뜻
	 * 1, 3, 5, 6, 10의 차 배열 : 2, 2, 1, 4
	 * 여기서 차이가 제일 적은 5 - 6 을 그룹으로 묶는 것 -> 차 배열에서 '1'을 티셔츠 만드는 비용에 추가
	 * 그 다음 1 - 3 을 그룹으로 묶는 것 -> 1 - 3 / 5 - 6 / 10 : 티셔츠 만드는 비용이 3
	 * or 3 - 5 를 그룹으로 묶는 것 -> 1 / 3 - 5 - 6 / 10 : 티셔츠 만드는 비용이 3
	 * 아래의 경우에도 3과 6의 차이 == 3, 5의 차이 + 5, 6의 차이
	 * 
	 * N명을 K개의 그룹으로 묶기..
	 * N명을 한 번 합치면 N - 1개의 그룹이 되고
	 * N명을 K 번 합치면 N - K개의 그룹이 된다
	 * N명을 N - K 번 합치면 N - (N - K) 개의 그룹 -> K개의 그룹이 된다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 원생 수
		int K = Integer.parseInt(st.nextToken()); // 나누려고 하는 조의 개수
		
		int[] arr = new int[N]; // 잼민이배열
		int[] tmp = new int[N-1]; // 키차이 배열
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i > 0) tmp[i-1] = arr[i] - arr[i-1];
		}
		Arrays.sort(tmp);
		int res = 0; // 티셔츠 만드는 비용
		for(int i = 0; i < N - K; i++) res += tmp[i];
		
		System.out.println(res);
		
	}
}
