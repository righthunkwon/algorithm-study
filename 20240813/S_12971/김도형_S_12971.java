class Solution {
    public int solution(int sticker[]) {
        
        //테스트 33 반례..
        if(sticker.length==1){
            return sticker[0];
        }
        
        //첫 스티커 고르는 경우(마지막 스티커 선택 불가)
        int [] dp = new int [sticker.length];
        dp[0]=sticker[0];
        dp[1]=sticker[0];
        for(int i=2;i<sticker.length;i++){
            dp[i]=Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        int a = dp[sticker.length-2];
        
        //첫 스티커 안고르는 경우
        int [] dp2 = new int [sticker.length];
        dp2[0]=0;
        dp2[1]=sticker[1];
        for(int i=2;i<sticker.length;i++){
            dp2[i]=Math.max(dp2[i-2]+sticker[i],dp2[i-1]);
        }
        int b = dp2[sticker.length-1];
        
        return Math.max(a,b);
        
    }
}
