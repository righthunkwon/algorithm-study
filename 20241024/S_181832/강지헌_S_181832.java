class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i=0;i<n;i++) answer[0][i]=i+1;
        int x=0,y=n-1,t=n-1,r=0,cnt=n+1;
        int[] xx={1,0,-1,0},yy={0,-1,0,1};
        while(t>0) {
            for(int i=0;i<t;i++) {
                x+=xx[r%4];
                y+=yy[r%4];
                answer[x][y]=cnt++;
            }
            r++;
            if(r%2==0) t--;
        }
        return answer;
    }
}
