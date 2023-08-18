import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 그리디라...
		// 일단 입력받은 좌표를 기준으로?
		// 각 거리의 합이
		// 가장 작은것들끼리 모음??
		Scanner sc = new Scanner(System.in);

		int N= sc.nextInt();
		int K= sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();			
		}
		Arrays.sort(arr);
		// 이 배열에서 각 항의 차이를 구함
		int[] narr = new int[N-1];
		for(int i=0;i<N-1;i++) {
			narr[i] = arr[i+1]-arr[i];
		}
		// 각 차이를 구했음 . 이때 가장 큰 값을 K-1번 만큼 패스
		// 각 길이에서 K-1개를 뺀 나머지 거리의 합
		// 예시에서는 1 3 묶고 3에서 6 패스, 6에서9까지 -> 2+ 3 = 5;
		
		int[] narr1= narr; 
		Arrays.sort(narr1);
		// 개수는 현재 사이의 거리므로 N-1개의 항
		// 정렬한 후에 맨뒤에 큰 길이를 안세면됨
		// K-1개만큼 뺀거까지만 
		int sum =0;
		for(int i=0;i<N-1-(K-1);i++) {
			sum+= narr1[i];
		}
		System.out.println(sum);
		

	}
}
