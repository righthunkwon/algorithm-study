package baek;

import java.util.*;
import java.io.*;
//10퍼 시간초과 ...................................
public class Pro_1202_보석도둑 {
	static class Jwl implements Comparable<Jwl> {
		int weight, money;

		public Jwl(int weight, int money) {
			this.weight = weight;
			this.money = money;
		}

		public int compareTo(Jwl o) {
			return o.money - this.money;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Jwl> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			pq.add(new Jwl(w, m));
		}
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		} // 입력끝
		long result = 0;
		int bagCnt = K;
		Arrays.sort(bag);
		// 가장 비싼것부터 나오는데 가방 중 그 무게랑 같거나 살짝 높은거에 넣는게 이득 ?!
		while (!pq.isEmpty()) {
			Jwl jwl = pq.poll();
			for (int i = 0; i < K; i++) {
				if (jwl.weight <= bag[i]) {
					bag[i] = -1;
					bagCnt--;
					result += jwl.money;
					break;
				}
			}
			if (bagCnt == 0)
				break;
		}

		System.out.println(result);
	}
}
