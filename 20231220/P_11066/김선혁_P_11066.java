import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {		
		
		N = sc.nextInt();
		// 입력시 근데 어차피 누적합을 해야하니깐 sum을 하나
		// 만들어서 누적합도 해본다
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		// 각각의 책의 값을 입력해준다.		
		// 각 다 합쳐서 최소비용으로 책을 만들어야 하니깐
		// dp를 통해서
		// 각 합의 제일 적은 경우를 계속 치워가면서 해보자
		int[][] dp = new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			dp[i][i+1] = arr[i] + arr[i+1];
		}
		
		for (int k=1;k<=N;k++) { 
			for (int i =1;i+k<=N;i++) {
				int j = i + k;
				dp[i][j] = 987654321; 
				for (int x = i; x<j;x++) {
					//1회째는 dp초깃값인 int최대정수와 점화식을비교, 무조건 점화식의 값이 dp[i][j]
					//n회쨰는 dp[i][j] 기존값과 범위가달라진 점화식중 비교하여 최솟값이 dp[i][j]
					//모든 범위를 반복시 결국 가장최솟값이 dp[i][j]
					dp[i][j] = Math.min(dp[i][j],
							dp[i][x] + dp[x + 1][j] + sum[j] - sum[i - 1]);
				}
			}
		}
		// 어려워서 검색찬스 써봄..
		System.out.println(dp[1][N]);
		
		
		
		
		
		
		
		}
	}
	
}	

