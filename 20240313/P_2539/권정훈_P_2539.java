
import java.io.*;
import java.util.*;

// 모자이크
public class P_2539 {
	static int r,c,n,k;
	static ArrayList<Node> list;
	
	private static class Node implements Comparable<Node> {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node n) {
			return this.y - n.y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt(); // 행 개수
		c = sc.nextInt(); // 열 개수
		n = sc.nextInt(); // 색종이 장수
		k = sc.nextInt(); // 잘못 칠해진 칸 개수

		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		// 열 기준으로 정렬
		Collections.sort(list); 
		
		int start = 1;
		int end = Math.min(r, c); // 가로와 세로 중 더 큰 값
		while (start <= end) {
			int mid = (start + end) / 2;

			if (solve(mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}

	private static boolean solve(int mid) {
		int cnt = 0;
		int prev = 0;
		for (int i = 0; i < list.size(); i++) {
			Node curr = list.get(i);
			
			if (curr.x > mid) return false;
			if (prev == 0 || prev + mid <= curr.y) {
				prev = curr.y;
				cnt++;
				if (cnt > n) {
					return false;
				}
			}
		}
		return true;
	}

}
