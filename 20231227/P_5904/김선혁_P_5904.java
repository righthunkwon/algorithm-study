import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 일단 수열의 개수부터 dp를 이용해서 해보자
		
		 dp = new int[30];
		
		dp[0] = 3;
		dp[1] = 10;
		for(int i=2;i<29;i++) {
			dp[i] = dp[i-1] *2 + (i+3);
		}
		// 이러면 일단 moo의 길이가 dp에 반영
		
//		System.out.println(dp[28]);
		// 직접 sysout 해보니깐 28까지만 유효함
		// 29부터는 10의 10승 이상이라?
		
		
		// dp에서 dfs 해볼까
		N = sc.nextInt();
		solve(28);
		
	}
	public static void solve(int idx) {
		if(idx==0) {
			if(N==1) {
				System.out.println("m");
			}
			else {
				System.out.println("o");
			}
			System.exit(0);
		}
		// 0까지 간경우 m과 o 분리해서 출력
		
		if(N> dp[idx-1] + idx+3) {
			// 절반을 기준으로 뒤쪽인 경우
			N -= (dp[idx-1]+idx+3);
			solve(idx-1);
		}
		else if(N> dp[idx-1]) {
			// 가운데 사이에 위치한 경우
			// 바로 다음거는 m 
			// 나머지는 o로 출력하고 끝낸다.
			if(N ==dp[idx-1]+1) {
				System.out.println("m");
			}
			else {
				System.out.println("o");
			}
			System.exit(0);
		}
		else {
			// 절반을 기준으로 앞쪽인 경우
			solve(idx-1);
		}
		return;
		
	}
	
}	

