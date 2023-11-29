package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 피자 굽기
// 그리디 & 이분탐색
public class P_1756 {
	static int d, n, ans;
	static int[] oven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken()); // 오븐의 깊이(오븐의 지름의 개수)
		n = Integer.parseInt(st.nextToken()); // 피자의 개수
		oven = new int[d]; // 오븐 지름

		// 오븐의 지름 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < d; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}

		// 오븐의 지름 재설정
		// 이전에 이미 더 작은 지름이 존재할 경우
		// 이후 더 큰 지름이 존재하더라도 피자가 내려가지 못하므로
		// 오븐의 지름을 내림차순이 되도록 더 큰 값을 제거하며 값을 변경
		for (int i = 1; i < d; i++) {
			oven[i] = Math.min(oven[i], oven[i - 1]);
		}

		// 피자 하나씩 내려보기
		int lastFloor = d; // 피자가 놓여진 층 아래로는 더 내려갈 수 없으므로 해당 값을 갱신하며 마지막 층 찾기

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int pizza = Integer.parseInt(st.nextToken()); // 피자 지름
			lastFloor = searchLastFloor(pizza, lastFloor - 1, 0); // 이분탐색으로 마지막 층 갱신
			if (lastFloor == -1) break; // 피자를 놓을 수 없을 경우 break
		}
		ans = lastFloor + 1; // 1층부터 시작하므로 1을 더해준다
		System.out.println(ans);
	}

	public static int searchLastFloor(int pizza, int st, int ed) {
		if (st < 0) {
			return -1;
		}
		if (pizza > oven[ed]) {
			return -1;
		}
		if (pizza <= oven[st]) {
			return st;
		}

		int mid = (st + ed) / 2;
		if (oven[mid] >= pizza && oven[mid + 1] < pizza) {
			return mid;
		} else if (pizza > oven[mid]) {
			return searchLastFloor(pizza, mid - 1, ed);
		} else {
			return searchLastFloor(pizza, st, mid);
		}
	}
}
