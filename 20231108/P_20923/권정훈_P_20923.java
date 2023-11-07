package level_16_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P_20923 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 카드의 수
		int m = Integer.parseInt(st.nextToken()); // 게임 진행 횟수
		Deque<Integer> doDeck = new ArrayDeque<>(); // 도도의 덱
		Deque<Integer> suDeck = new ArrayDeque<>(); // 수연의 덱
		Deque<Integer> doGround = new ArrayDeque<>(); // 도도의 그라운드
		Deque<Integer> suGround = new ArrayDeque<>(); // 수연의 그라운드
		
		// 덱 세팅
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			doDeck.addFirst(Integer.parseInt(st.nextToken()));
			suDeck.addFirst(Integer.parseInt(st.nextToken()));
		}
		
		int turn = 0;
		while (true) {
			// 도도 차례
			doGround.addFirst(doDeck.pollFirst());
			if (doDeck.isEmpty()) break;
			
			// 도도 승리
			if (doGround.peekFirst() == 5) {
				// 수연 그라운드 카드 가져오기
				while (!suGround.isEmpty()) {
					doDeck.addLast(suGround.pollLast());
				}
				// 도도 그라운드 카드 가져오기
				while (!doGround.isEmpty()) {
					doDeck.addLast(doGround.pollLast());
				}
			}
			
			// 수연 승리
			if (!suGround.isEmpty() && suGround.peekFirst() + doGround.peekFirst() == 5) {
				// 도도 그라운드 카드 가져오기
				while (!doGround.isEmpty()) {
					suDeck.addLast(doGround.pollLast());
				}
				// 수연 그라운드 카드 가져오기
				while (!suGround.isEmpty()) {
					suDeck.addLast(suGround.pollLast());
				}
			}
			
			// 턴 증가 & 게임 종료 판단
			if (++turn == m) break;
				
			
			// 수연 차례
			suGround.addFirst(suDeck.pollFirst());
			if (suDeck.isEmpty()) break;
				
			// 도도 승리
			if (suGround.peekFirst() == 5) {
				// 수연 그라운드 카드 가져오기
				while (!suGround.isEmpty()) {
					doDeck.addLast(suGround.pollLast());
				}
				// 도도 그라운드 카드 가져오기
				while (!doGround.isEmpty()) {
					doDeck.addLast(doGround.pollLast());
				}
			}
			
			// 수연 승리
			if (!doGround.isEmpty() && suGround.peekFirst() + doGround.peekFirst() == 5) {
				// 도도 그라운드 카드 가져오기
				while (!doGround.isEmpty()) {
					suDeck.addLast(doGround.pollLast());
				}
				// 수연 그라운드 카드 가져오기
				while (!suGround.isEmpty()) {
					suDeck.addLast(suGround.pollLast());
				}
			}
			
			// 턴 증가 & 게임 종료 판단 
			if (++turn == m) break;
		}
		
		if (doDeck.size() == suDeck.size()) {
			System.out.println("dosu");
		} else if (doDeck.size() > suDeck.size()) {
			System.out.println("do");
		} else {
			System.out.println("su");
		}
	}
}
