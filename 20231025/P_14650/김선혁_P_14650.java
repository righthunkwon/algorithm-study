import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Integer> arr;
	static int ans;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		N  =sc.nextInt();		
		//N자리니깐 bfs를 통해서
		// 숫자하나를 만들고 
		// 나눠서  나머지가 0되는지 확인?
//		ans = 0;
//		arr = new ArrayList<Integer>();
//		dfs(0);
		// 숫자를 다 arr에 담아보자
		// 1의 자리부터 ㄱㄱ
		// 개수를 세보니깐 
		// n=1 0 / 2 2 / 3 6 / 4 18 / 5  54 / 6 162
		// n이 2 이후로 3씩 곱해져 나가는걸 알수 있다.
		
		
		int[] dp = new int[10];
		dp[1] = 0;
		dp[2] = 2;
		for(int i=3;i<=9;i++) {
			dp[i] = dp[i-1]*3;
		}
		System.out.println(dp[N]);
		
	}
	
	
	
//	public static void dfs(int cnt) {
//		if(cnt == N) {
//			if(check()) {
//				ans++;
//			}
//			return;
//		}
//		if(cnt != 0) {
//			arr.add(0);
//		dfs(cnt+1);
//		arr.remove(cnt);
//		}
//		
//		arr.add(1);
//		dfs(cnt+1);
//		arr.remove(cnt);
//		
//		arr.add(2);
//		dfs(cnt+1);
//		arr.remove(cnt);
//	}
//	public static boolean check() {
//		int ans = 0;
//		for(int i =0;i<arr.size();i++) {
//			ans += arr.get(i)*Math.pow(10, i);
//		}
//		if(ans % 3 == 0) {
//			System.out.println(arr.size());
//			System.out.println(ans);
//			// 3의 배수가 되려면
//			// 201 , 111 , 21 , 102, 12 , 222
//			return true;
//		}
//		return false;
//	}
}
