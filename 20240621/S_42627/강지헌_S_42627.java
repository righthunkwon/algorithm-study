import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer=0, e=0, n=0, c=0, l=jobs.length;
        Arrays.sort(jobs, (o1,o2) -> { return o1[0]-o2[0]; });
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1,o2) -> { return o1[1]-o2[1]; });
        while(c < l) {
        	while(n < l && jobs[n][0] <= e) q.add(jobs[n++]);
        	if(q.isEmpty()) e = jobs[n][0];
            else {
        		int[] t = q.poll();
        		answer += t[1] + e - t[0];
        		e += t[1];
        		c++;
        	}
        }
        return answer/l;
    }
}
