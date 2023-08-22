import java.util.Scanner;

// 하노이의 탑
// 점화식 도출 영상 : https://www.youtube.com/watch?v=lG1UVOCMZwE&ab_channel=%ED%80%80%ED%85%80%EC%88%98%ED%95%99
public class P_11729 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// [점화식]
		// 이후원판 = 이전원판 + 1 + 이전원판

		// [자세한 설명]
		// 원판의 위치를 A, B, C 라 했을 때 A에 있던 3개의 원판을 C에 옮기는 경우의 수는 7가지이다.(직접 해보면 나온다.)
		// 이때 4개의 원판의 위치를 옮기는 경우의 수는 3개의 원판을 C에 옮기든 B에 옮기든 경우의 수는 같으므로
		// 3개의 원판을 B에 옮긴 뒤, 마지막 가장 큰 원판 하나를 C에 옮기고, B에 있던 3개의 원판을 C에 옮기는 경우의 수와 동일하다.
		// 즉, 4개의 원판을 옮기는 경우의 수는 3개의 원판을 옮기는 경우의 수(7) + 1 + 3개의 원판을 옮기는 경우의 수(7) 이므로
		// 15이고, 이를 n개의 원판을 옮기는 경우의 수로 일반화한다면 2^n - 1번이 나온다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 원판의 개수
		sb.append((int) Math.pow(2, n) - 1 + "\n"); // 하노이의 탑 원판 총 이동 횟수 : 2^n - 1
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
	}

	// n개의 원판은 최종적으로는 A에서 C로 옮긴다.
	// 이를 위해 n-1개의 원판은 A에서 B로 옮긴 뒤, 이를 다시 B에서 C로 옮겨야 한다.
	private static void hanoi(int n, int A, int B, int C) { // 원판의 개수, 출발지, 경유지, 목적지

		// 원판의 개수가 1개일 경우
		if (n == 1) {
			sb.append(A + " " + C).append("\n");
			return;
		}

		// 재귀 호출
		hanoi(n - 1, A, C, B);
		sb.append(A + " " + C + "\n");
		hanoi(n - 1, B, A, C);
	}
}
