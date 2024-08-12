class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n <= 3) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (sticker[i] > max) max = sticker[i];
            }
            return max;
        }
        int[][] dy = new int[2][n];
        dy[0][0]=dy[0][1]=sticker[0];
        dy[1][1]=sticker[1];
        for (int i = 2; i < n - 1; i++) {
            dy[0][i]=Math.max(dy[0][i-2]+sticker[i],dy[0][i-1]);
            dy[1][i]=Math.max(dy[1][i-2]+sticker[i],dy[1][i-1]);
        }
        return Math.max(Math.max(dy[0][n-2], dy[0][n-3]), Math.max(dy[1][n-3] + sticker[n-1], dy[1][n-2]));
    }
}
