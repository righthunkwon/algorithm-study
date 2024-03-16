import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 이거 정렬한 후에
		// 더하면서 만약
		// 전에숫자보다 작게되면 그대로 출력
		int[] arr = new int[N];
		for(int i = 0 ; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		Arrays.sort(arr);
		for(int i = 0 ;i<N;i++) {
			// 여기까지 더한값에서
			// +1한값보다 커지면 
			// 다음값 그대로 출력
			if(sum+1 < arr[i]) {
				break;
			}
			sum += arr[i];
		}
		System.out.println(sum+1);
	}
	


}
