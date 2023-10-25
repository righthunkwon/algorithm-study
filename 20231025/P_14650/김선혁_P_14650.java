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
		// 14650 실버 3
		// 0 , 1, 2 를 가지고 N자리의 3의 배수를 만들어보자.(개수파악)
		// N=1 -> 3의배수가 없어서 0
		// N=3 -> 201 , 111 , 21 , 102, 12 , 222 -> 6개
		// 이런식 
		
		
		//N자리니깐 bfs를 통해서
		// 숫자하나를 만들고 
		// 나눠서  나머지가 0되는지 확인?
		ans = 0;
		arr = new ArrayList<Integer>();
		dfs(0);
//		System.out.println(ans);
		// 숫자를 다 arr에 담아보자
		// 1의 자리부터 ㄱㄱ
		// --> 시간 초과 
		//------------------------------------------------------------
		
		
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
	
	
	
	public static void dfs(int cnt) {
		// N개만큼의 숫자가 다 선정되면 
		// 3의 배수인지 확인해보자
		if(cnt == N) {
			if(check()) {
				// 3의 배수이면 ans++
				ans++;
			}
			return;
		}
		// 첫번째 자리수가 0이 아니어야 하므로
		// cnt인 자리수가 0일때는 패스
		if(cnt != 0) {
			arr.add(0);
		dfs(cnt+1);
		arr.remove(cnt);
		}
		// 숫자가 1일때 
		arr.add(1);
		dfs(cnt+1);
		arr.remove(cnt);
		
		// 숫자가 2일때 
		arr.add(2);
		dfs(cnt+1);
		arr.remove(cnt);
	}
	public static boolean check() {
		int ans = 0;
		for(int i =0;i<arr.size();i++) {
			ans += arr.get(i)*Math.pow(10, i);
			// ans에 각자리수의 숫자를 곱해서
			// N자리의 숫자를 완성한다.
		}
		if(ans % 3 == 0) {
			// 3의배수이면 
			// true 반환
			return true;
		}
		return false;
	}
}
