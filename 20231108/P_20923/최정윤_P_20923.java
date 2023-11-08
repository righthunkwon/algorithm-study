package baek;

import java.io.*;
import java.util.*;

public class Pro_20923_숫자할리갈리게임 {
	static Deque<Integer> dodo, su;
	static Queue<Integer> doground, suground;
	static int M, dodoCard, suCard;
	static String win;
	public static void main(String[] args) throws IOException {
		dodo = new LinkedList<Integer>();
		su = new LinkedList<Integer>();
		doground = new LinkedList<>();
		suground = new LinkedList<>();

		// first가 맨 아래 last 가 맨 위 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dodo.addLast(Integer.parseInt(st.nextToken()));
			su.addLast(Integer.parseInt(st.nextToken()));
		}
		dodoCard = 0;//각자 그라운드 맨 위 카드 숫자 기억해놓기
		suCard = 0; //0일 때는 그라운드에 카드 없는 것
		int cnt = 0;
		win = "";
		while (true) {
			gameDoDo();//도도가 카드 한장 뒤집기
			cnt++;
			if (cnt == M) {
				whoWin();
				break;
			}
			gameSu();
			cnt++;
			if (cnt == M) {
				whoWin();
				break;
			}
		}
		System.out.println(win);
	}

	private static void whoWin() {
		if (su.size() > dodo.size())
			win = "su";
		else if (su.size() == dodo.size())
			win = "dosu";
		else
			win = "do";
	}

	private static void gameDoDo() {
		dodoCard = dodo.peekLast();//도도 맨 위 카드 뒤집어서 그라운드 맨 위 카드 값 저장시키기
		doground.add(dodo.removeLast());//그라운드에 넣기
		if (dodo.size() == 0) {//그라운드에 놓았더니 카드가 없을 때 => 패
			System.out.println("su"); //su가 이김
			System.exit(0);
		}
		if (dodoCard != 0 && suCard != 0 && dodoCard + suCard == 5) {//양쪽 그라운드에 모두 카드가 있고, 맨 위 카드 합이 5이면 수연이가 카드 가져감 
			// 수연이가 가져감
			jong(doground, suground, su);// 상대 그라운드, 본인 그라운드, 본인 카드더미

		} else if (dodoCard == 5) {//내가 방금 뒤집은 것이 5일 때, 
			//도도가 가져감, 종을 친다.
			jong(suground, doground, dodo);
		}
	}

	private static void gameSu() {//사람만 바뀌고 같은 방식
		suCard = su.peekLast();
		suground.add(su.removeLast());
		if (su.size() == 0) {
			System.out.println("do");
			System.exit(0);
		}
		if (dodoCard != 0 && suCard != 0 && dodoCard + suCard == 5) {
			//수연이가 가져감
			jong(doground, suground, su);
		} else if (suCard == 5) {
			// 도도가 가져감
			jong(suground, doground, dodo);
		}

	}

	private static void jong(Queue<Integer> youground, Queue<Integer> myground, Deque<Integer> myCard) {//상대 그라운드, 내 그라운드, 내 카드더미
		while (!youground.isEmpty()) {//상대 그라운드의 바닥에 깔린 것부터 내 카드 아래로 넣는다.(뒤집어져 있으니까)
			myCard.addFirst(youground.poll());
		}
		while (!myground.isEmpty()) {//그다음 내 그라운드에 있는 것 내 카드 아래로 넣는다. 
			myCard.addFirst(myground.poll());
		}
		dodoCard = 0;//넣고 나면 그라운드 맨 위 카드숫자 없다고 초기화.
		suCard = 0;
	}
}
