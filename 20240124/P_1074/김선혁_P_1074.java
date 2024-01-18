import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static int N;
	static int A;
	static int B;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 이거그냥 일단 4분면중에
		// 어디포함되어있는지 먼저 판단하고
		// 그전꺼 플러스해주고 
		// 재귀방식으로 또 나눠서 확인해도됨
		A = sc.nextInt();
		B = sc.nextInt();
		// N은 -1씩
		ans = 0;
		solve(N,A,B);
		System.out.println(ans);
	}
	public static void solve(int N, int x, int y) {
		// 일단 4분면중 어디인지 판단
		int tmp = (int)Math.pow(2, N-1);
//		System.out.println(ans+" "+tmp);
		if(N == 0) {
			// 이때 판단 가자
			return;
		}
		if(x>=tmp && y>=tmp) {
			// 4사분면
			ans += tmp *tmp *3;
			solve(N-1,x-tmp,y-tmp);
		}
		else if(x>=tmp && y<tmp) {
			// 3
			ans += tmp *tmp *2;
			solve(N-1,x-tmp,y);
		}
		else if(x<tmp && y>=tmp) {
			// 2
			ans += tmp *tmp;
			solve(N-1, x , y-tmp);
		}
		else {
			solve(N-1, x , y);
		}
	}

}
