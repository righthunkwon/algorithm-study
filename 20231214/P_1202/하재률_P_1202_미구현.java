package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {
	// 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수
		
		int[][] boseok = new int[N][2];
		int[] bag = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			boseok[i][0] = Integer.parseInt(st.nextToken());
			boseok[i][1] = Integer.parseInt(st.nextToken());
		}// 보석 입력
		
		for(int i = 0; i < K; i++) bag[i] = Integer.parseInt(br.readLine()); // 가방 입력

		// 보석은 무게로 오름차순
		Arrays.sort(boseok, (a, b) -> Integer.compare(a[0], b[0]));
		Arrays.sort(bag);
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < 2; j++) {
//				System.out.print(boseok[i][j] + " ");
//			}
//			System.out.println();
//		}
		// 우선순위 큐는 가격 큰 거 기준으로
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
		
		int cnt = 0; // 보석 몇 개 담을지
		int res = 0;
		
		// 가방 작은거부터 하나씩 채울거야.
		for(int i = 0; i < K; i++) {
			// 보석 하나씩 확인해서 넣기
			while(cnt < N) {
				if(boseok[cnt][0] <= bag[i]) {
					pq.add(new int[] {boseok[cnt][0], boseok[cnt][1]});
					cnt++;
				} else break;
			}
			// 현재 가방에 넣을 수 있는 보석들 res에 +
			if(!pq.isEmpty()) res += pq.poll()[1];
		}
		System.out.println(res);
	}
}
