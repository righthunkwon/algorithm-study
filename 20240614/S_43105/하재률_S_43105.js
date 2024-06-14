function solution(triangle) {
    // 바텀업방식
    const dp = triangle.slice();
    
    // 바닥부터 큰 수를 더해가기
    for(let i = dp.length-2; i >= 0; i--) {
        for(let j = 0; j < dp[i].length; j++) {
            dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
        }
    }
    // console.log(dp);
    
    return dp[0][0];
}
