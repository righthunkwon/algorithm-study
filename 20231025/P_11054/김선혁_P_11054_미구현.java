import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// 입력완료
		
		// 이문제는 음...낮은수를 찾아서
		// 포함할지 안할지 생각해야하는거면
		// dp인가?
		// 앞으로 쭉 증가랑
		// 뒤에서 쯕 증가하는거를
		// 가장큰수 기준으로
		// 최대의 개수를 세볼까?
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		for(int i =0;i<N;i++) {
			dp1[i] = 1;
			dp2[i] =1;
		}
		int max = 0;
		
		//일단 왼쪽에서 가장큰수 기준으로
		// 해당 i의 위치가 가장큰 수 위치일때
		// 증가하는 길이의 max를 구한다.
		for(int i =0;i<N;i++) {
			for(int j =0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp1[i] = Math.max(dp1[j] +1, dp1[i]);
					// 모두다 1로 되어있어서 
					// 갱신 이후에는 
					// i까지의 
					// 최대의 길이가 저장
				}
			}
		}
		for(int i =N-1;i>=0;i--) {
			for(int j =N-1;j>i;j--) {
				if(arr[j]<arr[i]) {
					dp2[i] = Math.max(dp2[j] +1, dp2[i]);
					// 모두다 1로 되어있어서 
					// 갱신 이후에는 
					// i까지의 
					// 최대의 길이가 저장
					// 위랑 같음
				}
			}
		}
		// 이제 dp에는 각 숫자까지의 최대길이가
		// 저장되어있으므로
		// 해당 숫자를 기준으로 두개합이
		// 가장큰 수를 max로 저장해서 출력
		for (int i = 1; i < N; i++) {
            max = Math.max(max, dp1[i] + dp2[i]);
        }
		//max인 지점의 숫자가 2번포함되었으므로 -1
		System.out.println(max-1);
	}
}
