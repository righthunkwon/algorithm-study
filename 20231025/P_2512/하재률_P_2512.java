package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());

		// 모두에게 예산 상한액을 배정하는 경우
		if((M / N) < pq.peek()) {
			System.out.println(M / N);
			return;
		}

		// 젤 짝은놈부터 빼서 비교..
		while(!pq.isEmpty()) {
			int poll = pq.poll();
			if(((M - poll) / pq.size()) >= pq.peek()) M -= poll;
			else {
				System.out.println((M-poll) / pq.size());
				break;
			}
			if(pq.size()==1) System.out.println(pq.poll());
		}

	}
}	
