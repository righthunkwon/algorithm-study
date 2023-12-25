import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 길이가 N의 수열의 연속된 숫자의 합이
		// M보다 커지는 최소 길이를 출력
		int[] arr = new int[N+1];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// arr에 먼저 입력되는 수열의 숫자를 입력

		// 2중 for문을 이용해서 풀면 당연히 시간초과
		// two point 라는 알고리즘을 사용해야 한다.

		int left = 0; 
		int right = 0;
		int sum = 0;
		int min = 987654321;
		//왼쪽, 오른쪽 포인터와 왼쪽과 오른쪽 포인터 사이의 부분합이 조건을 만족하는지 구분할 총 합, 길이의 최소값을 담을 min 선언

		// while문안에서 매 시행마다
		// 1. 왼쪽과 오른쪽 사이 부분합이 조건에 벗어나는가? ->  그럼 왼쪽을 당긴다.
		// 2. 만약 왼쪽을 다 당겨봤는데도 오른쪽 포인터가 끝에 닿았으면 조건을 만족할 부분합의 경우의 수가 없으므로 종료.
		// 3. 기본적으로 오른쪽을 최대한 늘리면서 조건을 최대한 만족하는 곳 까지 땡긴다.
		// 4. 매 시행의 마지막에는 부분합이 조건과 일치하는지 체크
		while (true) {
			// 부분합이 M보다 크거나 같으면
			// 좌측것을 빼고 오른쪽으로 한번 이동
//			System.out.println(left+" "+right+" "+sum+" "+min);
			if (sum >= M) {
				sum -= arr[left++];
			}
			// 만약 오른쪽이 끝에 닿았으면
			// 모두 탐색했다는 의미로 종료
			// 1. min이 중간에 바뀌었을 수도 있음
			// 2. M보다 큰수를 만들지 못해서 min이 integer.max 값일수도 있음
			else if (right == N) {
				break;
			}
			// 두가지 경우 아니라면 오른쪽으로 한칸 이동해서 오른쪽 수를 합함
			else {
				sum += arr[right++];
			}
			
			if (sum >= M) {
				min = Math.min(min, right - left);
//				최소 길이를 구해야 하기 때문에 오른쪽과 왼쪽 차 만큼이 길이
				// (이미 최소길이를 구하기 전에 right++을 통해서 sum을 넘은거라 +1안해도됨)
			}
		}
		// min값이 안바뀐것은 M이상값이 없다는 의미로 0출력
		if(min == 987654321) {
			System.out.println(0);
		}
		else {
			System.out.println(min);
		}

	}

}

