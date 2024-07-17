class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0,n=board.length,m=board[0].length;
        int[][] hap=new int[n+2][m+2];
        for(int[] i:skill) {
            int t=i[0]==1?-1:1;
            hap[i[1]+1][i[2]+1]+=t*i[5];
            hap[i[3]+2][i[4]+2]+=t*i[5];
            hap[i[3]+2][i[2]+1]-=t*i[5];
            hap[i[1]+1][i[4]+2]-=t*i[5];
        }
        for(int i=1;i<n+2;i++) {
            for(int j=1;j<m+2;j++) hap[i][j]+=hap[i][j-1]+hap[i-1][j]-hap[i-1][j-1];
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) if(board[i][j]+hap[i+1][j+1]>0) answer++;
        }
        return answer;
    }
}
