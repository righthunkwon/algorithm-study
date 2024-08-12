import java.util.*;
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        for (int i = start; i < end; i++) {
            double[] current = getDegree(i / 3600, (i % 3600) / 60, i % 60);
            double[] next = getDegree((i + 1) / 3600, ((i + 1) % 3600) / 60, (i + 1) % 60);

            boolean hMatch = isOverlap(current, next, 0, 2);// 겹쳤는지 체크
            boolean mMatch = isOverlap(current, next, 1, 2);

            if (hMatch && mMatch) {
                answer += (next[0] == next[1]) ? 1 : 2;
            } else if (hMatch || mMatch) {
                answer++;
            }
        }
        if (start == 0 || start == 43200) answer++;
        return answer;
    }
    // 시 분 초 계산
    public static double[] getDegree(int h, int m, int s) {
        final double HOUR_DEGREE = 360.0 / 12;
        final double MINUTE_DEGREE = 360.0 / 60;
        double hDegree = (h % 12) * HOUR_DEGREE + m * HOUR_DEGREE / 60 + s * HOUR_DEGREE / 3600;
        double mDegree = m * MINUTE_DEGREE + s * MINUTE_DEGREE / 60;
        double sDegree = s * MINUTE_DEGREE;
        return new double[] {hDegree, mDegree, sDegree};
    }
    // 이 부분이 핵심, 지나치는지 체크, 완전히 겹치는지는 정확하게 알 수 가 없으니까, 교차 했는지로 체크
    public static boolean isOverlap(double[] current, double[] next, int t1, int t2) {
        return (current[t1] > current[t2] && next[t1] <= next[t2]) ||
               (current[t2] == 354 && current[t1] > 354);// 354는 59초, 59분
    }
}