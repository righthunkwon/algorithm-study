// 문제: 258705번 (산 모양 타일링)
// 등급: Level 3
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258705
// [풀이] 
// DP
// 위에 삼각형이 붙었냐, 붙지 않았냐로 분기 처리해서 DP 처리
// 정삼각형은 경우의 수 4가지, 사다리꼴은 경우의 수 3가지 가능
// 일단 tops가 0인 경우의 dp 점화식과 tops가 전부 1인 경우의 dp 점화식을 구해보면
// 0인 경우, DP[n] = a*DP[n-1] + b * DP[n-2] + c 에서 시작하면
// dp[0] = 1, dp[1] = 3, dp[2] = 3*3-1(겹치는 거), dp[3] = 21 => DP[n] = 3*DP[n-1]-DP[n-2];
// 1인 경우, 동일하게 점화식을 놓고 시작하면
// dp[0] = 1, dp[1] = 4, dp[2] = 4*4-1(겹치는 거) = 15, dp[3] = 15*4-4(겹치는 거) = 56; => DP[n] = 4*DP[n-1]-DP[n-2];
// 최종적으로 위에 삼각형이 있을때는 DP[n] = 4*DP[n-1]-DP[n-2], 없을 때는 DP[n] = 3*DP[n-1]-DP[n-2];
class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = tops[0] == 1 ? 4 : 3;
        if(n == 1) return dp[1];
        for (int i = 1; i < n; i++) {
            dp[i+1] = ((tops[i] == 1 ? 4 : 3) * dp[i] - dp[i-1]) % 10007;
            if (dp[i+1] < 0) dp[i+1] += 10007;// 음수 처리 이거 안하면 테케 몇 개 틀림
        }
        return dp[n];
    }
}