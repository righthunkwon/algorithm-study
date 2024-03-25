import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static long arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 숫자 하나를 기준잡고
		
		// 나머지 두개숫자를 투포인터로
		// 양끝에서 쭊 더해봄
		// abs값이 최소인 값 구함
		long sum = Long.MAX_VALUE;
		arr = new long[N];
		for(int i = 0 ; i<N;i++) {
			arr[i] = sc.nextLong();
		}
		// 입력끝
		long[] ans = new long[3]; 
		Arrays.sort(arr);
		// 먼저 정렬하고 숫자하나 기준잡음
		// 기준잡는 숫자는 최소 숫자로 그 이후로 
		// 나머지 두숫자가 움직일거임 
		for(int i = 0 ;i<N-1;i++) {
			int left = i+1;
			int right = N-1;
			// 이제 while문으로 두개 구해보자
			while(true) {
				// left가 이상되면 break
				if(right<=left) {
					break;
				}
				long tmp = arr[i] + arr[left] + arr[right];
				// sum값 먼저 최소값 갱신하고
				// 숫자가 음수면 left+ 
				// 양수면 right--
				if(sum > Math.abs(tmp)) {
					sum = Math.abs(tmp);
					ans[0] = arr[i];
					ans[1] = arr[left];
					ans[2] = arr[right];
				}
				if(tmp > 0) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
		
		
	}

}
