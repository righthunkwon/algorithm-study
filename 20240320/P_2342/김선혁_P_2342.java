import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	static int[][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ar.add(0);
		while(true) {
			int input = sc.nextInt();
			if(input == 0) {
				break;
			}
			// 일단 ar에 넣음
			ar.add(input);
		}
		// 입력끝
		dp = new int[ar.size()+1][5][5]; // (4+1)
		// 각각 경우의수 dp로 계산
		
		// 최소의 수를 구해야해서 먼저 숫자 다 넣고 시작
		for(int in=0;in<ar.size();in++) {
			for(int i = 0;i<5;i++) {
				for(int j =0;j<5;j++) {
					dp[in][i][j] = 987654321;
				}
			}
		}
		dp[0][0][0] = 0;
		// 오른쪽 갈지 왼쪽갈지 모든 경우의 수 다해보고
		// 방문처리해서 백트래킹
		// 왼쪽 발을 밟을 경우와
		// 오른쪽 발을 움직여 밟을 경우로 나누어서
		// 왼쪽발 갔을 경우와 오른쪽발 갔을 경우를 전항에서 각자 더함
		for(int in = 1 ; in<ar.size();in++) {
			// 옮겨야할 위치 먼저 꺼내고
			int tmp = ar.get(in);
			for(int i = 0 ;i<5;i++) {
				for(int j= 0;j<5;j++) {
					// 왼쪽 옮길경우
					dp[in][tmp][j] = Math.min(dp[in][tmp][j] , dp[in-1][i][j] + solve(i , tmp));
					// 오른쪽 옮길 경우
					dp[in][i][tmp] = Math.min(dp[in][i][tmp] , dp[in-1][i][j] + solve(j, tmp));
				}
			}
			
			
		}
		int ans = 987654321;
		// 이제 다 정했으니 마지막 좌표들 중 최소점을 찾아보자
		for(int i = 0 ;i<5;i++) {
			ans = Math.min(ans, dp[ar.size()-1][ar.get(ar.size()-1)][i]);
			ans = Math.min(ans, dp[ar.size()-1][i][ar.get(ar.size()-1)]);
		}
		System.out.println(ans);
		
	}
	public static int solve(int a , int tmp) {
		// 시작지점에서는 무조건 2
		if(a== 0) {
			return 2;
		}
		// 둘이같으면 1
		else if(a == tmp) {
			return 1;
		}
		// 반대방향이면 4
		else if((a+tmp)%2 ==0) {
			return 4;
		}
		// 나머진 3
		else {
			return 3;
		}
	}
}
