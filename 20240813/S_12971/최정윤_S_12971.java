class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[][] dp=new int[sticker.length][2];
        //N이 1일경우
        if(sticker.length==1){
            return sticker[0];
        }
        //첫번째꺼 포함 0
        //미포함 1
        for(int i=0;i<sticker.length;i++){
            if(i==0) dp[i][0]=sticker[0];
            else if(i==1) {
                dp[i][0]=Math.max(dp[0][0],sticker[1]);
                dp[i][1]=Math.max(dp[0][1],sticker[1]);
            }
            else{
                dp[i][0]=Math.max(dp[i-2][0]+sticker[i],dp[i-1][0]);
                dp[i][1]=Math.max(dp[i-2][1]+sticker[i],dp[i-1][1]);
            }
        }
        answer=Math.max(dp[sticker.length-2][0],dp[sticker.length-1][1]);
        return answer;
    }
}
