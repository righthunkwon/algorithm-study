package baek;

import java.util.Scanner;

public class Pro_17478_재귀함수가뭔가 {
	public static void main(String[] args) {
		// System.out.println("\"안녕하세요\"");
		//"를 출력하기 위해서는 \"를 쓰면 가능
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		answer(N, 0);
		String str = sb.toString();
		System.out.println(str);

	}

	public static StringBuilder sb;

	public static void answer(int N, int su) {
		if (N == 0) {
			print_(su);
			sb.append("\"재귀함수가 뭔가요?\"\n");
			print_(su);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			print_(su);
			sb.append("라고 답변하였지.\n");
			return;
		}
		print_(su);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		print_(su);
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		print_(su);
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		print_(su);
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		answer(N - 1, su + 1);
		print_(su);
		sb.append("라고 답변하였지.\n");
	}

	public static void print_(int su) {
		for (int i = 0; i < 4 * su; i++) {
			sb.append("_");
		}
	}
}
