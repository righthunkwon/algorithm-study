package level_25_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 센서의 수
		int k = Integer.parseInt(br.readLine()); // 집중국의 수
		int[] arr = new int[n]; // 센서 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 센서 입력
		}
		Arrays.sort(arr); // 센서 정렬


		// (1) 센서보다 집중국의 수가 많거나 같을 경우 (k >= n)
		// 집중국은 센서마다 1개씩 담당하므로 수신 가능 영역의 최소 길이는 0
		
		// (2) 집중국보다 센서의 수가 많을 경우 (k < n)
		// 집중국 간 차이를 저장하는 배열을 만들어 오름차순 정렬하면 이때 가장 앞부분의 
		// 간격을 차례대로 집중국이 부담하는 것이 최선(그리디)
		// 이때 집중국이 부담해야 되는 개수는 센서에서 집중국을 뺀 개수.
		
		// test case)
		// 센서			1 3 6 6 7 9 		
		// 차이			0 1 2 2 3
		// 집중국-센서(k-n)	4
		// 정답				5 (0+1+2+2)
		
		int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
 
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
	}
}
