// 1 <= N <= 100,000 이기 때문에 DP or 그리디
// 원형큐 문제는 아닌게 0번째 스티커를 때냐 안때냐로 마지막 스티커 사용 여부가 결정되는 거라
// 그냥 배열을 2가지 경우로 나누어서 풀면 해결
// 다음 스티커를 고를 때 그리디하게 하면 최대값 보장이 안되어서 DP로 풀어야 한다
// 원형 배열에서의 부분합 유형
// 시작점과 종료점 설정 체크
// 배열 사용 DP
class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[][]dp = new int[2][sticker.length];
        dp[0][0] = dp[0][1] = sticker[0];
        dp[1][0] = 0; dp[1][1] = sticker[1];
        
        for(int i = 2; i < sticker.length-1; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+sticker[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+sticker[i]);
        }
        dp[1][sticker.length-1] = Math.max(dp[1][sticker.length-2], dp[1][sticker.length-3]+sticker[sticker.length-1]);
        return Math.max(dp[1][sticker.length-1], dp[0][sticker.length-2]);
    }
}
// 배열 없이 DP
class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        // 첫 번째 스티커 때는 경우
        int el1i2 = sticker[0];
        int el1i1 = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < sticker.length - 1; i++) {
            int tmp = Math.max(el1i1, el1i2 + sticker[i]);
            el1i2 = el1i1;
            el1i1 = tmp;
        }

        // 첫 번째 스티커 때지 않는 경우
        int el2i2 = sticker[1];
        int el2i1 = Math.max(sticker[1], sticker[2]);
        for (int i = 3; i < sticker.length; i++) {
            int tmp = Math.max(el2i1, el2i2 + sticker[i]);
            el2i2 = el2i1;
            el2i1 = tmp;
        }
        return Math.max(el1i1, el2i1);
    }
}