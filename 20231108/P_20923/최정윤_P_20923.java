import java.io.*;
import java.util.*;

public class Main {
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
		dodoCard = 0;
		suCard = 0;
		int cnt = 0;
		win = "";
		while (true) {
			game1();
			cnt++;
			if (cnt == M) {
				whoWin();
				break;
			}
			game2();
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

	private static void game1() {
		dodoCard = dodo.peekLast();
		doground.add(dodo.removeLast());
		if (dodo.size() == 0) {
			System.out.println("su");
			System.exit(0);
		}
		if (dodoCard != 0 && suCard != 0 && dodoCard + suCard == 5) {
			// 수연이가 가져감
			jong(doground, suground, su);// 상대 그라운드, 본인 그라운드, 본인 카드더미

		} else if (dodoCard == 5) {
			jong(suground, doground, dodo);
		}
	}

	private static void game2() {
		suCard = su.peekLast();
		suground.add(su.removeLast());
		if (su.size() == 0) {
			System.out.println("do");
			System.exit(0);
		}
		if (dodoCard != 0 && suCard != 0 && dodoCard + suCard == 5) {
			jong(doground, suground, su);
		} else if (suCard == 5) {
			// 도도가 가져감
			jong(suground, doground, dodo);
		}

	}

	private static void jong(Queue<Integer> youground, Queue<Integer> myground, Deque<Integer> myCard) {
		while (!youground.isEmpty()) {
			myCard.addFirst(youground.poll());
		}
		while (!myground.isEmpty()) {
			myCard.addFirst(myground.poll());
		}
		dodoCard = 0;
		suCard = 0;
	}
}
