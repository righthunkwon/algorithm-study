import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int s = 0, e = distance;
        while (start <= end) {
            int mid = (s + e) / 2;
            int cur = 0;
            int cnt = 0;
            for (int rock : rocks) {
                int diff = rock - cur;
                if (diff < mid) {
                    cnt++;
                    if (cnt > n) break;
                } else {/
                    current = rock;
                }
            }
            if (distance - cur < mid) cnt++;
            if (cnt > n) {
                e = mid - 1;
            } else {
                answer = mid;
                s = mid + 1;
            }
        }
        return answer;
    }
}