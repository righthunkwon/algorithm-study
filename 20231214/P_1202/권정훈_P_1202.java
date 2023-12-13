import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 보석 도둑

// 1. 보석은 무게 순으로 오름차순 정렬
// 2. 가방의 최대 무게를 입력받은 뒤 오름차순 정렬
// 3. 가격 순서대로 내림차순 정렬하는 우선순위 큐 생성
// 4. 반복문을 수행하며 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담기
// 5. 가장 가격이 비싼 우선순위 큐의 제일 첫번째 요소를 꺼내 누적합
public class P_1202 {

	private static class Jewel {
		int m; // 무게
		int v; // 가격

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 보석 개수
		int k = sc.nextInt(); // 가방 개수

		// 보석 정보 배열 요소 삽입
		List<Jewel> jewelList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			jewelList.add(new Jewel(m, v));
		}

		// 보석을 무게 기준으로 오름차순 정렬
		Collections.sort(jewelList, (o1, o2) -> o1.m - o2.m);

		// 가방 무게 배열 요소 삽입
		int[] bagWeight = new int[k];
		for (int i = 0; i < k; i++) {
			bagWeight[i] = sc.nextInt();
		}

		// 가방을 무게 기준으로 오름차순 정렬
		Arrays.sort(bagWeight);

		long ans = 0; // 보석 가격 합의 최대값
		int jewelListIdx = 0; // 보석 인덱스
		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v); // 가격 내림차순 정렬
		
		// 반복문을 통해 가방을 순회하며
		// 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위큐에 담는다.
		for (int i = 0; i < k; i++) {
			while (jewelListIdx < n && jewelList.get(jewelListIdx).m <= bagWeight[i]) {
				Jewel curr = jewelList.get(jewelListIdx++);
				pq.add(new Jewel(curr.m, curr.v));
			}
			if (!pq.isEmpty()) {
				ans += pq.poll().v;
			}
		}
		System.out.println(ans);
	}

}
