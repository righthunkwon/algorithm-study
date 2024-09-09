import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue <String> q = new LinkedList<>();
        for(String s : cities) {
            s = s.toLowerCase();
            if(q.contains(s)) {
                answer++;
                q.remove(s);
                q.offer(s);
            }
            else {
                answer+=5;
                if(q.size() == cacheSize) q.poll();
                if(q.size() < cacheSize) q.offer(s);
            }
        }
        return answer;
    }
}
