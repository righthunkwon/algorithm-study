import java.util.*;

class Solution {
    private int[] p;
    public int solution(int n, int[][] costs) {
		Arrays.sort(costs, (o1,o2) -> {
            if (o1[2] == o2[2]) return o1[1] - o2[1];
			return o1[2] - o2[2];
        });
		p = new int[n];
		for (int i = 0; i < p.length; i++) p[i] = i;
		int answer = 0;
		for (int i = 0; i < costs.length; i++) {
			int s = find(costs[i][0]), e = find(costs[i][1]);
			if (s != e) {
				p[e] = s;
				answer += costs[i][2];
			}
		}
		return answer;
    }
    private int find(int c) {
		if (p[c] == c) return c;
		return p[c] = find(p[c]);
	}
}
