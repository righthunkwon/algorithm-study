import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String M = sc.next();
//		// 먼저 하나를 입력받고
//		// 인덱스가 증가함에 따라
//		// 같은 글자가 나오면 +1씩해보자
//		int ans = 0;
//		int tmp = 0;
//		for(int i = 0 ; i<N.length();i++) {
//			for(int j =tmp ; j <M.length(); j++) {
//				// 두개가 일치하면 일치하는 지점 이후부터 확인하면되니깐
//				// tmp를 j로 갱신
//				if(N.substring(i,i+1).equals(M.substring(j,j+1))) {
//					ans ++;
//					tmp = j+1;
//					break;
//				}
//			}
//		}
//		System.out.println(ans);
//		투포인터는 밑에 반례때매 안됨 도저히 모르겠음
//		ABCDEFG
//		BCDEFGA
		
		int[][] dp = new int[N.length()+1][M.length()+1];
		for(int i = 1 ; i<=N.length();i++) {
			for(int j = 1;j<=M.length();j++) {
				String a = N.substring(i-1,i);
				String b = M.substring(j-1,j);
				// 두글자가 같으면 전항까지의 값 +1
				// 두글자가 다르면 i-1 또는 j-1항의 최대값으로 기록
				
				// 둘중 하나라도 0인경우 0기록
				if(a.equals(b)) {
					dp[i][j] = dp[i-1][j-1] +1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[N.length()][M.length()]);
		
	}
}
