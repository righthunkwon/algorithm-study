public class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dy = new int[2][n];
        dy[0][0]=dy[0][1]=money[0];
        dy[1][1]=money[1];
        for(int i=2;i<n;i++) {
            dy[0][i]=Math.max(dy[0][i-1], dy[0][i-2]+money[i]);
            dy[1][i]=Math.max(dy[1][i-1], dy[1][i-2]+money[i]);
        }
        return Math.max(dy[0][n-2], dy[1][n-1]);
    }
}
