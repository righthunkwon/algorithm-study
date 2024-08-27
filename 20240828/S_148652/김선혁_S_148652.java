class Solution {
    public int solution(int n, long l, long r) {
        // 1은 11011 0은 0000으로 5개씩늘어나는데
        // 일단 5개 구역을 확인하면 될듯 
        
        // dfs를 통해서 어디 구역에 포함되는지 확인하면서
        // 개수 count
        return solve(n, l, r);
    }

    private int solve(int n, long l, long r) {
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
        
        long len = (long) Math.pow(5, n-1);
        int result = 0;
        // 주어진 구간 [l, r]을 순회하면서 각 위치에 대해 1인지 확인
        for (long i = l; i <= r; i++) {
            long pos = (i - 1) / len;  // 현재 위치가 5개의 구역 중 어느 구역에 속하는지 확인
            long offset = (i - 1) % len + 1;  // 현재 위치가 해당 구역 내에서 어디에 위치하는지 계산
            
            if (pos == 2) {
                // 가운데 구역 (세 번째 구역)은 항상 0으로 채워져 있으므로 무시
                continue;
            } else {
                // 가운데 구역이 아닌 경우, 해당 위치의 1의 개수를 재귀적으로 구함
                result += solve(n - 1, offset, offset);
            }
        }
        return result;
    }
}
