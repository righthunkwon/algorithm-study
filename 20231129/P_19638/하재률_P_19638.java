package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19638_센티와마법의뿅망치 {
	// 우선순위 큐로 가장 큰 놈을 계속 뿅 하고 센치와 비교하자 ㅎ
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 수가 위로가게
		
		int N = Integer.parseInt(st.nextToken()); // 거인 수
		int H = Integer.parseInt(st.nextToken()); // 센치 키
		int T = Integer.parseInt(st.nextToken()); // 뿅 횟수
		int cnt = 0;
		
		for(int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
		// 입력완료
		String res = "YES";
		for(int i = 0; i < T; i++) {
			if(pq.peek() < H) break;
			if(pq.peek() > 1) {
				pq.add(pq.poll() / 2);
				cnt++;
			}
		}
		
		if(pq.peek() < H) {
			System.out.println(res);
			System.out.println(cnt);
		} else {
			res = "NO";
			System.out.println(res);
			System.out.println(pq.peek());
		}
		
		
	}
}
