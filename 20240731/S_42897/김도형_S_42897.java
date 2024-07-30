class Solution {
    public int solution(int[] money) {
        
        //집이 딱 3개면 3개중 가장 돈 많은 집 선택
        if(money.length==3){
            int ans = Math.max(Math.max(money[0],money[1]),money[2]);
            return ans;
        }

        //첫 집 돈 훔친 경우
        int []dp = new int[money.length];

        dp[0]=money[0];
        dp[1]=-987654321; //두번째 집은 선택 안되도록
        dp[2]=money[0]+money[2];
            
        for(int i=3;i<money.length;i++){
            dp[i]=money[i]+Math.max(dp[i-2],dp[i-3]);
        }
        //첫 집 돈 안훔친 경우
        int []dp2 = new int[money.length];
        dp2[0]=-987654321;
        dp2[1]=money[1];
        dp2[2]=money[2];
        for(int i=3;i<money.length;i++){
            dp2[i]=money[i]+Math.max(dp2[i-2],dp2[i-3]);
        }
        
        int a = Math.max(dp[money.length-2],dp[money.length-3]); //마지막 집은 선택 못함
        int b = Math.max(dp2[money.length-1],dp2[money.length-2]);

        int answer = Math.max(a,b);
        return answer;
    }
}
