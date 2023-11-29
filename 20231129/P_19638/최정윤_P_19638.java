package baek;

import java.io.*;
import java.util.*;

public class Pro_19638_센티와마법의뿅망치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long H = Integer.parseInt(st.nextToken());
		long T = Integer.parseInt(st.nextToken());
		// 큰값부터꺼내기
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		} // 입력끝

		//생각하기 복잡하니까 걍 바로 출력후 종료시키자 
		int cnt = 0;
		while (T >= cnt) {//=가 붙는 이유는 마지막 한번 하고 나의 키랑 한번더 비교해주기 위해 
			if (pq.peek() < H) {//나보다 키 작으면 바로 출력 종료
				System.out.println("YES");
				System.out.println(cnt);
				System.exit(0);
				break;
			}
			if (pq.peek() == 1) { //가장 큰 키가 1인데 위에 통과한 것이면 1보다 작아질 수 없으므로 거인이 나보다 키가 작아질 수 없다. =>출력 종료
				System.out.println("NO");
				System.out.println(1);
				System.exit(0);
				break;
			}
			if (T > cnt) {
				pq.add(pq.poll() / 2);
			}
			cnt++;
		}
		System.out.println("NO");
		System.out.println(pq.poll());
	}
}
