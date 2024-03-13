package _20240313;

import java.util.*;
import java.io.*;

public class _1800_인터넷설치 {

	public class Main {
		static class Node {
			int end, weight;

			public Node(int end, int weight) {
				this.end = end;
				this.weight = weight;
			}
		}

		static int N, P, K;
		static List<List<Node>> adj;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 학생 번호
			P = Integer.parseInt(st.nextToken()); // 케이블선 개수
			K = Integer.parseInt(st.nextToken()); // 공짜로 제공하는 케이블선 개수

			adj = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adj.add(new ArrayList<>());
			}

			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				adj.get(a).add(new Node(b, c));
				adj.get(b).add(new Node(a, c));
			}//입력끝


		}//main


	}
}
