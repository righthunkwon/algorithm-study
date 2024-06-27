import java.util.*;

class Solution {
    public int solution(int[] a) {
        int N = a.length, min = Integer.MAX_VALUE, answer=0;
        int[] lm = new int[N], rm = new int[N];
        for (int i = 0; i < N; i++) lm[i] = min = Math.min(min, a[i]);
        min = Integer.MAX_VALUE;
        for (int i = N-1; i >= 0; i--) rm[i] = min = Math.min(min, a[i]);
        for (int i = 0; i < N; i++) if (lm[i] >= a[i] || rm[i] >= a[i]) answer++;
        return answer;
    }
}
