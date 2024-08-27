import java.util.*;

class Solution {
    static long len;
    public int solution(int n, long l, long r) {
        // 1은 11011 0은 0000으로 5개씩늘어나는데
        // 일단 5개 구역을 확인하면 될듯 
        
        // dfs를 통해서 어디 구역에 포함되는지 확인
        len = (long) Math.pow(5, n);
        return solve(n, l, r);
        
    }
    public static int solve(int n, long l, long r) {
        // dfs를 하면서 n이 1이된 경우 
        // 11011에서 범위 체크
        if (n == 1) {
            int[] arr = {1, 1, 0, 1, 1};
            int count = 0;
            for (long i = l; i <= r; i++) {
                if (arr[(int)(i - 1)] == 1) {
                    count++;
                }
            }
            return count;
        }

        long div = len / 5; 
        // 5개로 나눠지면서 확인
        int result = 0;

        // 각 구간을 체크하여 해당 구간에 속하는지 확인
        for (int i = 0; i < 5; i++) {
            // ex) 6~10 이런식으로 속하는지
            long start = i * div + 1;
            long end = (i + 1) * div;
            
            // 범위 밖
            if (r < start || l > end) {
                continue; 
            }

            if (l <= start && end <= r) {
                if (i == 2) { 
                    // 세 번째 섹션 (중간 0)
                    continue;
                } 
                else { // 첫 번째, 두 번째, 네 번째, 다섯 번째 섹션
                    result += (div / 5) * 4; // 4개의 1 포함
                }
            }
            else {
                if (i != 2) { // 중간 0이 아닌 경우 계속 탐색
                    result += solve(n - 1, Math.max(l, start) - start + 1, Math.min(r, end) - start + 1);
                }
            }
        }

        return result;
    }
}
