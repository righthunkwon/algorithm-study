class Solution {
    public int[] solution(int n) {
        int[][] arr=new int[n+1][n+1];
        // 1
        // 2 9
        // 3 10 8
        // 4 5  6 7
        //아래 오른쪽 왼쪽대각선위
        int[] dr=new int[]{1,0,-1};
        int[] dc=new int[]{0,1,-1};
        int num=1;
        int nr=0;
        int nc=1;
        int dir=0;
        //1~n 까지의 합
        while(num<=n*(n+1)/2){
            nr+=dr[dir];
            nc+=dc[dir];
            if(nr<1||nc<1||nc>nr||nr>n||arr[nr][nc]!=0){
                nr-=dr[dir];
                nc-=dc[dir];
                dir=(dir+1)%3;
                continue;
            }
            arr[nr][nc]=num;
            num++;
        }
        int[] answer=new int[n*(n+1)/2];
        int idx=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                answer[idx]=arr[i][j];
                idx++;
            }
        }
        return answer;
    }
}
