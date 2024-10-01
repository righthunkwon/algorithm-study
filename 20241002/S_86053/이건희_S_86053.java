class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = Long.MAX_VALUE;
        long l = 0;
        long r = (long) 1e15// 예제2번이 10^15 기준
        while (l <= r) {
            long m = (l + r) / 2;
            if (check(m, a, b, g, s, w, t)) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }

    private boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalCombined = 0;

        for (int i = 0; i < g.length; i++) {
            long tripTime = t[i];
            long maxLoad = w[i];

            long trips = time / (tripTime * 2);
            if (time % (tripTime * 2) >= tripTime) {
                trips++;
            }

            long max = trips * maxLoad;

            long gold = Math.min(g[i], max);
            long silver = Math.min(s[i], max);
            long combined = Math.min(g[i] + s[i], max);
            totalGold += gold;
            totalSilver += silver;
            totalCombined += combined;
        }
        return totalGold >= a && totalSilver >= b && totalCombined >= (a + b);
    }
}