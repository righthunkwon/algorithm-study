// 블로그 보고 했어요 ㅎㅎ....
// https://suminii.tistory.com/entry/Level-3-%EC%88%AB%EC%9E%90-%ED%83%80%EC%9E%90-%EB%8C%80%ED%9A%8CPython
class Solution {
    // 두 숫자 간 이동 가중치를 미리 계산하여 저장한 배열
    private static final int[][] distMap = new int[10][10];

    // distMap 초기화 블록
    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int[] posI = getPos(i); // i의 위치 좌표 (행, 열)
                int[] posJ = getPos(j); // j의 위치 좌표 (행, 열)
                
                // 두 숫자 간 행, 열 차이 계산
                int diffR = Math.abs(posI[0] - posJ[0]);
                int diffC = Math.abs(posI[1] - posJ[1]);
                
                // 가중치 계산: 대각선 이동 3, 상하좌우 이동 2, 같은 위치 1
                distMap[i][j] = 3 * Math.min(diffR, diffC) + 2 * Math.abs(diffR - diffC);
                if (i == j) distMap[i][j] = 1; // 같은 위치일 경우 가중치는 1
            }
        }
    }

    public int solution(String numbers) {
        // 두 손가락 위치에서 각 숫자까지의 최소 가중치를 저장할 배열
        int[][] weights = new int[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                weights[i][j] = Integer.MAX_VALUE;// 초기 값은 무한대로 설정
            }
        }
        weights[4][6] = 0; // 시작 위치는 왼손 4, 오른손 6

        // 입력된 숫자 문자열의 각 숫자에 대해 최소 가중치 계산
        for (char num : numbers.toCharArray()) {
            int n = num - '0'; // 다음에 눌러야 할 숫자
            int[][] temp = new int[10][10]; // 현재 단계에서의 최소 가중치를 임시로 저장할 배열
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    temp[i][j] = Integer.MAX_VALUE; // 초기값 무한대

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (weights[i][j] != Integer.MAX_VALUE) { // 기존 가중치가 유효한 경우에만 진행
                        // 만약 두 손가락 중 하나가 이미 목표 숫자에 있다면 가중치 1을 추가
                        if (i == n || j == n) {
                            temp[i][j] = Math.min(temp[i][j], weights[i][j] + 1);
                            temp[j][i] = temp[i][j]; // 대칭적으로 설정
                        } else {
                            // `distMap`을 활용하여 현재 위치에서 목표 숫자까지의 가중치를 계산
                            temp[i][n] = Math.min(temp[i][n], weights[i][j] + distMap[j][n]);
                            temp[j][n] = Math.min(temp[j][n], weights[i][j] + distMap[i][n]);
                            temp[n][i] = temp[i][n];
                            temp[n][j] = temp[j][n];
                        }
                    }
                }
            }
            weights = temp; // 갱신된 가중치 배열을 현재 weights로 업데이트
        }

        // 모든 숫자를 다 누른 후, 최종적으로 최소 가중치를 찾음
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = Math.min(answer, weights[i][j]);
            }
        }
        return answer; // 최종 최소 가중치 반환
    }

    // 숫자의 위치를 키패드 좌표로 변환하는 메서드
    private static int[] getPos(int num) {
        if (num == 0) return new int[]{3, 1}; // 숫자 0의 좌표는 (3,1)
        return new int[]{(num - 1) / 3, (num - 1) % 3}; // 나머지 숫자의 좌표
    }
}