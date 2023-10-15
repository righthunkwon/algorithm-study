import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int max;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			arr = new int[2][N];
			int[][] dp = new int[2][N];
			for(int i =0;i<2;i++) {
				for(int j =0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 입력완료
			
			// 2열 n행만큼
			// arr배열에는 각각의 점수를 입력받고
			// dp에는 각각의 더 나은합을 기록
			dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            // 일단 첫번째 좌표에 각 첫번째 값 입력
            
            max = Math.max(dp[0][0], dp[1][0]);
            for (int i=1;i<N;i++) {
                if (i==1) {
                    dp[0][i] = dp[1][0] + arr[0][1];
                    dp[1][i] = dp[0][0] + arr[1][1];
                    max = Math.max(dp[0][i], dp[1][i]);
                    continue;
                    // 두번째 좌표는 첫번째 좌표에서 대각선 더한 것
                }
                // 그이외에는 그 대각선 전좌표까지 더한 값이랑 전전좌표랑 비교해서
                // 큰 값을 구한다음에
                // 현재좌표 값을 더함
                // 만약 현재 좌표보다 오른쪽 좌표가
                // 더 클수도 있기 때문에
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
                max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
            }
            System.out.println(max);

		}
	}








}
