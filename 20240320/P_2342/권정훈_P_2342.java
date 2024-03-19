
import java.io.*;
import java.util.*;

// Dance Dance Revolution
public class P_2342 {
	static int N; // 지시사항 수
	static List<Integer> list; // 지시사항 배열
	static int[][][] dp; // 순서, 왼발, 오른발
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new ArrayList<Integer>();
		N = list.size();
		dp = new int[N + 1][5][5];

		st = new StringTokenizer(br.readLine(), "");
		while (true) {
			int input = Integer.parseInt(st.nextToken());
			if (input == 0) {
				break;
			}
			list.add(input);
		}

		int ans = DDR(0, 0, 0);
		System.out.println(ans);
	}

	static int DDR(int direction, int left, int right) {
		// 종료조건
		// 모든 지시사항을 이행했을 때
		if (direction == N) return 0;

		// 메모이제이션
		if (dp[direction][left][right] != 0) {
			return dp[direction][left][right];
		}

		// 왼발 욺직이는 경우와 오른발 움직이는 경우 중 작은 경우로 갱신
		int leftEnergy = getEnergy(left, list.get(direction)) + DDR(direction + 1, list.get(direction), right);
		int rightEnergy = getEnergy(right, list.get(direction)) + DDR(direction + 1, left, list.get(direction));

		return dp[direction][left][right] = Math.min(leftEnergy, rightEnergy);
	}

	static int getEnergy(int from, int to) {
		// 동일 지점
		if (from == to) return 1;
		
		// 중앙에서 다른 지점
		if (from == 0) return 2;
		
		// 반대 지점
		if (Math.abs(from - to) == 2) return 4;
		
		// 인접 지점
		return 3;
	}
}
