function solution(n) {
    var answer = 0;
    
    const dp = Array.from(Array(15), ()=>0);
    dp[0] = dp[1] = 1;
    
    // 0 n-1 + 1 n-2 ... n-2 1 + n-1 0
    for(let i = 2; i <= n ; i++) {
        for(let j = 1; j <= i; j++) {
            dp[i] += dp[j-1] * dp[i-j];
        }
    }
    // console.log(dp)
    
    return dp[n];
}
