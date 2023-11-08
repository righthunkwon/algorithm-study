package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20923_숫자할리갈리게임 {
	
	static int N, M, dodo, su;
	static Deque<Integer> dodeq, sudeq;
	static List<Integer> doground, suground;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		dodeq = new ArrayDeque<>();
		sudeq = new ArrayDeque<>();
		
		// 이것도 deque로 구현했다가 38% 43% 틀렸습니다 존나뜸..
		// 먼저 낸게 뒤집어서 들어오니까 먼저 들어와서 queue 맞는데
		doground = new ArrayList<>();
		suground = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dodeq.addFirst(Integer.parseInt(st.nextToken()));
			sudeq.addFirst(Integer.parseInt(st.nextToken()));
		}// 입력 완
		
		/*
		 * 게임 끝나는 조건
		 * 1. 덱의 카드 수 == 0
		 * 2. M번 진행
		 */
		while(M > 0) {
			// 도도 턴
			dodo = dodeq.pollFirst(); // 도도의 덱에서 제일 위에 있는 카드 꺼내기 (처음 넣을때 addFirst 했음)
			doground.add(dodo); // 꺼낸 카드를 그라운드에 addLast
			if(youwin()) return; // 카드내고 비었으면 상대방 승
			
			if(dodo == 5) doget(); // 도도가 꺼낸 카드가 5라면 도도가 가져가기
			else if(suground.size() > 0 && dodo + suground.get(suground.size()-1) == 5) suget(); // 그렇지 않고, 두 카드 합이 5라면 수..가 가져가기
			
			// 한 턴 끝
			M--;
			if(M == 0) break;
			
			// 수 머시기 턴
			su = sudeq.pollFirst(); // 수.. 덱에서 제일 위에 있는 카드 꺼내기 (처음 넣을때 addFirst 했음)
			suground.add(su); // 꺼낸 카드를 그라운드에 addLast
			if(youwin()) return; // 카드내고 비었으면 상대방 승
			
			if(su == 5) doget(); // 수..가 꺼낸 카드가 5라면 도도가 가져가기
			else if(doground.size() > 0 && su + doground.get(doground.size()-1) == 5) suget(); // 그렇지 않고, 두 카드 합이 5라면 수..가 가져가기
			
			M--;
			
		}
		// 게임이 끝났으면 덱에 더 많은 카드 가진놈이 승리, 같으면 dosu
		if(dodeq.size() == sudeq.size()) System.out.println("dosu");
		else {
			if(dodeq.size() > sudeq.size()) System.out.println("do");
			else System.out.println("su");
		}
		
	}
	
	// 덱이 비었을 때 상대방 승
	static boolean youwin() {
		if(dodeq.isEmpty() || sudeq.isEmpty()) {
			if(dodeq.isEmpty()) System.out.println("su");
			else System.out.println("do");
			return true;
		}
		return false;
	}

	// 카드를 가져갈 땐 상대방 ground에 있는 카드부터 뒤집어서 밑에 쌓는다
	// 그라운드 List의 0번 인덱스가 가장 밑에 있는 카드(먼저 낸 카드)
	// 도도가 가져가기
	static void doget() {
		while(!suground.isEmpty()) dodeq.addLast(suground.remove(0));
		while(!doground.isEmpty()) dodeq.addLast(doground.remove(0));
	}
	
	// 수 어쩌고가 가져가기
	static void suget() {
		while(!doground.isEmpty()) sudeq.addLast(doground.remove(0));
		while(!suground.isEmpty()) sudeq.addLast(suground.remove(0));
	}
}
