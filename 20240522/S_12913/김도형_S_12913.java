class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length; //행의 개수 N
        //dp 메모이제이션
        int [][]dp = new int[N][4]; //열은 4개 고정
        
        //첫줄은 그대로
        for(int i=0;i<4;i++){
            dp[0][i]=land[0][i];
        }
        
        //바로 전 행의 최대값과 land의 현재 값 더해주기
        for(int i=1;i<N;i++){
            dp[i][0]=land[i][0]+Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][3]);
            dp[i][1]=land[i][1]+Math.max(Math.max(dp[i-1][0],dp[i-1][2]),dp[i-1][3]);
            dp[i][2]=land[i][2]+Math.max(Math.max(dp[i-1][1],dp[i-1][0]),dp[i-1][3]);
            dp[i][3]=land[i][3]+Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][0]);
        }
        
        answer = Math.max(Math.max(dp[N-1][0],dp[N-1][1]),Math.max(dp[N-1][2],dp[N-1][3]));
        
        System.out.println(N);

        return answer;
    }
}
