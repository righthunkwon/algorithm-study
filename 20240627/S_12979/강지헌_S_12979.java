class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, l;
        for (int i = 0; i <= stations.length; i++) {
            if(i == 0) l = stations[i] - 1 - w;
             else if(i == stations.length) l = n - stations[i - 1] - w;
             else l = stations[i] - stations[i - 1] - 2 * w - 1;
            if (l >= 0) {
                answer += l / (2 * w + 1);
                if (l % (2 * w + 1) != 0) answer++;
            }
        }
        return answer;
    }
}
