import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// 양쪽의 두개를 비교해서 최솟값을 구해야함
		
		// 5개면합의 최소값 구해서 N을 두번 곱함
		int[] arr = new int[6];
		for(int i = 0;i<6;i++) {
			arr[i] = sc.nextInt();
		}
		// 3개 저장
		int[] min = new int[3];
		min[0] = Math.min(arr[0], arr[5]);
        min[1] = Math.min(arr[1], arr[4]);
        min[2] = Math.min(arr[2], arr[3]);
        // 최소값을 저장한다음 min값 구함 일단
        Arrays.sort(min);

        int ans = 0 ;
        
        // 마지막에 n을 두번곱함
	}
}
