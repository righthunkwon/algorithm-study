package study_240306;

import java.io.*;
import java.util.*;

public class Pro_4386_별자리만들기 {
	static class Line implements Comparable<Line> {
		int i, j;
		double dist;

		public Line(int i, int j, double dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}

		@Override
		public int compareTo(Line o) {
			return (int) (this.dist - o.dist);
		}
	}

	static List<Line> list;
	static double[][] xy;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		xy = new double[n][2];
		list = new ArrayList<>();
		double result = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			xy[i][0] = x;
			xy[i][1] = y;
		} // 입력 끝
//		모든 노드끼리의 거리 계산해놓자
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				list.add(new Line(i, j, cal(i, j)));
			}
		}
		// sort
		Collections.sort(list);

		parents = new int[n];
		for (int i = 0; i < n; i++) {// 본인의 부모 본인 설정
			parents[i] = i;
		}

		for (Line l : list) { // 노드가 짧은 것 부터 나오니까
			if (find(l.i) != find(l.j)) {// 연결되어있지않다면
				union(l.i, l.j);
				result += l.dist;
			}
		}
		System.out.printf("%.2f", result);
	}

	private static void union(int a, int b) {
	// 연결되어있지 않을떄만 여기 들어옴
		int x = find(a), y = find(b);
		if (x < y) parents[y] = x;
		else  parents[x] = y;
	}

	private static int find(int b) {
		if (b != parents[b])
			parents[b] = find(parents[b]);
		return parents[b];
	}

	private static double cal(int i, int j) {
		return Math.sqrt(Math.pow(xy[i][0] - xy[j][0], 2) + Math.pow(xy[i][1] - xy[j][1], 2));
	}
}
