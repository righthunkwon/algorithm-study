import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N =sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long sum=0;
		for(int i=0;i<N;i++) {
			sum+=Math.abs(arr[i]-(i+1));
		}
		System.out.println(sum);
		
	
	
		
	}
}
