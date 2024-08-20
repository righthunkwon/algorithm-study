function solution(n, tops) {
    const MOD = 10_007;
    const dp = Array.from(Array(2*n + 1), () => 0);
    
    dp[0] = 1;
    dp[1] = tops[0] ? 3 : 2;
    
    for(let i = 2; i < n * 2 + 1; i++) {
        if(i%2 === 1 && tops[Math.floor(i/2)] === 1)
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % MOD;
        else dp[i] = (dp[i-1] + dp[i-2]) % MOD;
    }
    
    // console.log(dp)
    
    return dp[2*n];
}
