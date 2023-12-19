import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K; 
	static boolean[] robot;
	static int left;
	static int right;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[] arr = new int[2*N];
		robot = new boolean[N];
		for(int i =0;i<2*N;i++) {
			arr[i] = sc.nextInt();
		}
		// 입력 끝
		
		// 벨트를먼저 움직이고
		// 그다음 로봇을 움직여보자
		
		left = 0;
		right = N;
		
		int ans = 0;
		while(true) {
			ans++;
			solve();
			if(K==0) {
				break;
			}
		}
		
	}
	public static void solve() {
		left --;
		right --;
		// 둘다 -- 헤주는데
		// 중간에 -1이 되면
		// 2*N-1로 바꿔준다.
		if(left ==-1) {
			left = 2*N-1;
		}
		if(right == -1) {
			right = 2*N-1;
		}
		// N-2번째부터 true면 false로 바꿔주고 
		// 
		 for(int i = N-2; i >= 0; i--) {
	            if(robot[i]) {
	                robot[i] = false;
	                //... 모르겠다 
	            }
	        }
		
	}
}	

