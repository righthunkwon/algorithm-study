import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] record = new int[N];
        int total = stages.length;

        for (int stage : stages) {
            if (stage >= 1 && stage <= N) {
                record[stage - 1]++;
            }
        }

        double[] rate = new double[N]; 
        int remain = total;
        for (int i = 0; i < N; i++) {
            if (remain > 0) {
                rate[i] = (double) record[i] / remain;
                remain -= record[i];
            } else {
                rate[i] = 0;
            }
        }

        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i + 1;
        }

        Arrays.sort(idx, (a, b) -> {
            if (rate[a - 1] == rate[b - 1]) {
                return Integer.compare(a, b);
            } else {
                return Double.compare(rate[b - 1], rate[a - 1]);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = idx[i];
        }

        return answer;
    }
}