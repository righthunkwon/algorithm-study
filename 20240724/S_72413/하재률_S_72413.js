function solution(n, s, a, b, fares) {
    // 플로이드와샬 dp
    const dp = Array.from(Array(n+1),()=> Array.from(Array(n+1), ()=> Infinity));
    // 자기 자신까지 비용은 0
    for(let i = 0; i <= n; i++) dp[i][i] = 0;
    fares.forEach(e => {
        const [st, end, w] = e;
        dp[st][end] = w;
        dp[end][st] = w;
    });
    
    // k는 경유지
    for(let k = 1; k <= n; k++) {
        for(let i = 1; i <= n; i++) {
            for(let j = 1; j <= n; j++) {
                if(i===j) continue;
                // k를 들르는게 더 cost가 작게 든다면, dp[i][j]는 k를 경유하도록 하여라
                if(dp[i][k] + dp[k][j] < dp[i][j])
                    dp[i][j] = dp[i][k] + dp[j][k];
            }
        }
    }
    // console.log(dp)
    
    // 각자 갈 길 가기를 ans로 놓기
    let ans = dp[s][a] + dp[s][b];
    // 동승하는게 더 나을까?
    for(let i = 1; i <= n; i++)
        ans = Math.min(ans, dp[s][i] + dp[i][a] + dp[i][b]);
    
    return ans;
}
