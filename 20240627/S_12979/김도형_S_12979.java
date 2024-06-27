class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 한 기지국의 커버범위
        int wid = 2 * w + 1;
        // 기지국 커버 범위의 시작 지점
        int start = 1;

        // 기지국 사이의 빈 공간을 체크
        for (int i = 0; i < stations.length; i++) {
            int left = stations[i] - w;
            if (start < left) {
                int gap = left - start;
                answer += (gap + wid - 1) / wid;
            }
            start = stations[i] + w + 1;
        }

        // 마지막 기지국 이후의 빈 공간을 체크
        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + wid - 1) / wid;
        }

        return answer;
    }
}
