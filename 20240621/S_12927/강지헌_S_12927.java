import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: works) Q.add(i);
        while(n-->0) {
            int t = Q.poll();
            if(t>0) t--;
            Q.add(t);
        }
        for(int i: Q) answer+=i*i;
        return answer;
    }
}
