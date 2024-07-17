// DP로는 안되고
// 완탐 이고 횟수가 N으로 제한이니까 DFS
// 정확성 10초 붙었으니까 백트랙킹 조건 있을거니까 그걸 찾아야
// 백트래킹 조건을 못 찾아서
// https://ggjjdiary.tistory.com/113 참고
class Solution {
    private int maxDiff = Integer.MIN_VALUE;
    private int[] bestShotPattern = {-1};

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(info, ryan, n, 0, 0, 0);
        // 경기 결과 라이언이 이길 수 없거나 최선을 다해도 점수가 동일할 경우
        if (maxDiff <= 0) {
            return new int[]{-1};
        }
        return bestShotPattern;
    }

    private void dfs(int[] apeach, int[] ryan, int arrowsLeft, int index, int ryanScore, int apeachScore) {
        if (index == 11) {
            if (arrowsLeft > 0) {
                ryan[10] += arrowsLeft; // 남은 화살 모두 0점에 사용
            }
            int diff = ryanScore - apeachScore;
            if (diff > maxDiff) {
                maxDiff = diff;
                bestShotPattern = ryan.clone();
            } else if (diff == maxDiff && more(ryan, bestShotPattern)) {
                bestShotPattern = ryan.clone();
            }
            if (arrowsLeft > 0) {
                ryan[10] -= arrowsLeft; // 화살 수 원상복구
            }
            return;
        }

        // 어피치보다 1발 더 많이 쏘아 점수를 가져오는 경우
        if (arrowsLeft > apeach[index]) {
            ryan[index] = apeach[index] + 1;
            dfs(apeach, ryan, arrowsLeft - ryan[index], index + 1, ryanScore + (10 - index), apeachScore);
            ryan[index] = 0; // 원상복구
        }

        // 해당 점수를 포기하고 다음 점수로 넘어가는 경우
        dfs(apeach, ryan, arrowsLeft, index + 1, ryanScore, apeach[index] > 0 ? apeachScore + (10 - index) : apeachScore);
    }

    // 현재 패턴이 이전에 찾은 최선의 패턴보다 낮은 점수에서 더 많은 화살을 쏘는 경우 true 반환
    private boolean more(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] != best[i]) {
                return current[i] > best[i];
            }
        }
        return false;
    }
}