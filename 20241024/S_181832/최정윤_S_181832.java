class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr=new int[]{0,1,0,-1};
        int[] dc=new int[]{1,0,-1,0};
        answer[0][0]=1;
        int num=2;
        int r=0;
        int c=0;
        int idx=0;
        while(num<=n*n){
            while(true){
                int nr=r+dr[idx];
                int nc=c+dc[idx];
                //범위 넘어가거나 이미 숫자 있다면
                if(nr<0||nc<0||nr>=n||nc>=n||answer[nr][nc]!=0) idx=(idx+1)%4; 
                else {
                    answer[nr][nc]=num;
                    r=nr;
                    c=nc;
                    break;
                }
            }
            num++;
        }
        
        return answer;
    }
}
