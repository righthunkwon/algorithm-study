class Solution {
    public int solution(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = true; dp[1] = true;
        for(int i = 2; i <= n; i++){
            for(int j = i*2; j <= n; j+=i){
                dp[j] = true;
            }
        }
        int cnt = 0;
        for(boolean el : dp){
            if(!el) cnt++;
        }
        return cnt;
    }
}