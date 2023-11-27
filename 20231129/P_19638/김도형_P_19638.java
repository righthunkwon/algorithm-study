package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_Q19638_센티와_마법의_뿅망치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 거인 나라 인구수
		int H = Integer.parseInt(st.nextToken()); // 센티의 키
		int T = Integer.parseInt(st.nextToken()); // 뿅망치 횟수 제한

		// 높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;

		for (int i = 0; i < T; i++) { // 뿅망치질 on

			int x = pq.poll();
			if (x < H) {
				pq.add(x);
				break;
			} // 센티가 가장 크면 끝내
			if (x == 1) {
				pq.add(x);
				break;
			} // 젤 큰 거인이 키가 1이어도 끝내
			x = x / 2;
			pq.add(x);
			cnt++;
		}

		int x = pq.poll();
		if (x < H) {
			System.out.println("YES");
			System.out.println(cnt);
		} else {
			System.out.println("NO");
			System.out.println(x);
		}

	}

}
