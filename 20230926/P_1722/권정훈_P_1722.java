package level_19_combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열의 순서
// 20!의 경우의 수가 나오므로 단순 순열이나 브루트포스 불가

// 순열이 사전 순으로 정렬되어 있을 경우, 
// 모든 경우를 확인해보지 않고도 K번째 순열을 찾아내거나 주어진 순열이 몇 번째 순열인지를 알아낼 수 있다.

// 1 2 3 4
// 1 2 4 3
// 1 3 2 4
// 1 3 4 2
// 1 4 2 3
// 1 4 3 2
//
// 2 1 3 4
// 2 1 4 3
// 2 3 1 4
// 2 3 4 1
// 2 4 1 3
// 2 4 3 1
//
//   ...

// 가령, 숫자 4개로 이루어진 순열의 경우의 수는 4!이지만,
// 맨 앞자리의 수가 1로 정해져 있을 경우 경우의 수는 3!이고,
// 마찬가지로 맨 앞자리의 수가 2로 정해져 있을 경우의 경우의 수는 3!이므로 경우의 수 확인을 단축할 수 있다.

// 즉, 앞의 요소부터 팩토리얼이 형성되는지 판단하고(이는 팩토리얼 배열을 미리 만들어서 판단)
// 전체 경우의 수를 가지치기하는 방식으로 풀이하면 효율성을 많이 높일 수 있다.
public class P_1722 {
	private static int n;
	private static int[] arr;
	private static long[] fact;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		arr = new int[n]; // 순열 배열
		fact = new long[21]; // 팩토리얼 배열
		visited = new boolean[21]; // 방문 확인 배열

		// 팩토리얼 배열 요소 값 1로 초기화
		for (int i = 1; i <= 20; i++) {
			fact[i] = 1;
		}

		// 팩토리얼 배열 요소 값 입력
		for (int i = 1; i <= 20; i++) {
			fact[i] = fact[i - 1] * i; // 팩토리얼(i!) 값 저장
		}

		st = new StringTokenizer(br.readLine());
		int question = Integer.parseInt(st.nextToken()); // 소문제

		// question1: k번째 입력
		if (question == 1) {
			long k = Long.parseLong(st.nextToken());

			// 팩토리얼 가짓수 치기
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= n; j++) {
					// 순열에 이미 존재하는 숫자면 넘어간다
					if (visited[j]) {
						continue;
					}

					// 팩토리얼 값이 k보다 작으면 k에서 팩토리얼 값을 빼준다
					if (arr[n - i - 1] < k) {
						k -= arr[n - i - 1];
					}

					// 팩토리얼 값이 k보다 크면 해당하는 원소의 숫자를 찾은 것.
					// a[i]에 저장하고 순열에 존재하는 숫자를 체크해준다
					else {
						arr[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
		}

		// question2: 임의의 순열 입력
		else {
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long ans = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < arr[i]; j++) {
					// 1부터 해당하는 원소까지 팩토리얼 값을 늘려가며 더해준다.
					if (visited[j]) {
						continue;
					}
					ans += arr[n - i - 1];
				}
				// 순열에 존재하는 숫자는 있다고 표시해준다.
				visited[arr[i]] = true;
			}
			sb.append(ans);
		}
		System.out.println(sb);
	}
}
