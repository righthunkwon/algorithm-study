package _20240117;

import java.util.*;
import java.io.*;

public class _1863_스카이라인쉬운거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 스카이라인 맨 위에 꼭지점만 넣어준다
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int ans=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// pq가 비어있지 않고 pq에서 제일 큰 값이 b보다 작거나 같을 때
			if(!pq.isEmpty() && b>=pq.peek()) {
				// pq에 b가없다면 b를 넣어주고, 건물 수도 세준다
				if(!pq.contains(b)) {
					pq.add(b);
					ans++;
				}
				// b가 0이 아닐때
			} else if (b!=0) {
				// pq가 비어있지 않고 pq에서 제일 큰 수가 b보다 크면
				// 그 위에수들은 빼서 버린다
				// b가 더 작은게 나온 시점에서 그 초과하는 값들은 다시 새로운 건물이기 때문.
				while(!pq.isEmpty() && pq.peek()>b) {
					pq.poll();
				}
				//pq에 없는 b값이라면 다시 더해주고 건물 수도 세준다
				if(!pq.isEmpty() && !pq.contains(b)) {
					pq.add(b);
					ans++;
					// pq가 비어있어도 다시 b를 넣어주고 건물수도 세준다
				}else if(pq.isEmpty()) {
					pq.add(b);
					ans++;
				}
				// b가 0일 땐 pq안에 있는 값들을 전부 버린다
				// pq 안에 있는 값들은 이제 새로운 건물로 세줘야 하기 때문이다
			} else {
				while(!pq.isEmpty()) {
					pq.poll();
				}
			}

		}
		System.out.println(ans);
	}//main
}
