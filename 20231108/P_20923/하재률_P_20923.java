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
			dodo = dodeq.pollFirst();
			doground.add(dodo);
			if(youwin()) return; // 카드내고 비었으면 상대방 승
			
			if(dodo == 5) doget();
			else if(suground.size() > 0 && dodo + suground.get(suground.size()-1) == 5) suget();
			
			// 한 턴 끝
			M--;
			if(M == 0) break;
			
			// 수 머시기 턴
			su = sudeq.pollFirst();
			suground.add(su);
			if(youwin()) return;
			
			if(su == 5) doget();
			else if(doground.size() > 0 && su + doground.get(doground.size()-1) == 5) suget();
			
			M--;
			
		}
		
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
