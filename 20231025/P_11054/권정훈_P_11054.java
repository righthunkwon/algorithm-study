import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 긴 바이토닉 부분 수열
// LIS(최장 증가 부분수열) & LDS(최장 감소 부분수열)
// LIS의 최대와 LDS의 최대의 합이 전체의 최대이다.
public class P_11054 {
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        String[] s = br.readLine().split(" ");
			int[] arr = new int[n];
			int[] dp1 = new int[n + 1];
			int[] dp2 = new int[n + 1];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
	 
			int ans = 0;
			
			// 정방향
			for (int i = 0; i < n; i++) {
				dp1[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && dp1[j] >= dp1[i]) {
						dp1[i] = dp1[j] + 1;
					}
				}
			}

			// 역방향
			for (int i = n - 1; i >= 0; i--) {
				dp2[i] = 1;
				for (int j = n - 1; j > i; j--) {
					if (arr[i] > arr[j] && dp2[j] >= dp2[i]) {
						dp2[i] = dp2[j] + 1;
					}
				}
			}

			// 정방향과 역방향의 합 - 1의 배열 요소를 순회하며 최대값을 갱신
			for (int i = 0; i < n; i++) {
				ans = Math.max(dp1[i] + dp2[i] - 1, ans);
			}

			System.out.println(ans);
		}
	}
	 
