function solution(m, n, puddles) {
    const dp = Array.from(Array(n), () => Array.from(Array(m), () => 0));
    
    // 물웅덩이
    puddles.forEach(([x, y]) => {
        dp[y-1][x-1] = -1;
    });
    
    // 시작지점
    dp[0][0] = 1;
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(i === 0 && j === 0 || dp[i][j] === -1) continue;
            // 위에서
            if(i > 0 && dp[i-1][j] !== -1) dp[i][j] += dp[i-1][j] % 1_000_000_007;
            // 왼쪽에서
            if(j > 0 && dp[i][j-1] !== -1) dp[i][j] += dp[i][j-1] % 1_000_000_007;
            dp[i][j] %= 1_000_000_007;
        }
    }
    
    // console.log(dp)
    
    return dp[n-1][m-1];
}
