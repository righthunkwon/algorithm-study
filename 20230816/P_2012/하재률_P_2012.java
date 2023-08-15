package Algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 하재률_P_2012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 참가 학생 수
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}// 입력 완료
		
		Arrays.sort(arr); // 오름차순으로 정렬 후 실제 등수를 빼주는 방법을 이용할거에요
		long sum = 0; // 불만도의 합 저장용 sum. 최악의 경우 50만명의 예상 등수가 모두 1일때 int범위 초과
		
		for(int i = 0; i < N; i++) {
			// 참가 학생 수만큼 돌면서... 실제 등수는 1등부터니까 (i + 1) 를 빼준 값의 절댓값
			sum += Math.abs(arr[i] - (i + 1));
		}
		
		System.out.println(sum);
	}
}
