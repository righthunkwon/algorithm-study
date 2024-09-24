class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100001;// 1 ≤ diffs[i] ≤ 100,000
        int start = 1;
        int end = diffs[0];
        
        // diffs 배열에서 최대값을 구하는 부분
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > end) {
                end = diffs[i];
            }
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            long totalTime = times[0];
            int prevTime = times[0];
            boolean toggle = true;
            for (int i = 1; i < diffs.length; i++) {
                if (diffs[i] > mid) {
                    totalTime += (diffs[i] - mid) * (times[i] + prevTime) + times[i];
                } else {
                    totalTime += times[i];
                }
                if (totalTime > limit) {
                    toggle = false;
                    break;
                }
                prevTime = times[i];
            }
            if (toggle) {
                end = mid - 1;
                answer = (answer > mid) ? mid : answer;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}