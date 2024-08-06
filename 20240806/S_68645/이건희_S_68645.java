class Solution {
    public int[] solution(int n) {
        // 패턴을 모르겠어서 그냥 다 넣는걸로
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }
        int x = -1, y = 0;// 시작 위치 설정
        int num = 1;// 채워 넣을 숫자
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i % 3 == 0) {// 아래 방향
                    x++;
                } else if (i % 3 == 1) {// 오른쪽 방향
                    y++;
                } else {// 위로 가는 대각선 방향
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }
        // [1]
        // [2, 9]
        // [3, 10, 8]
        // [4, 5, 6, 7]
        // 결과 반환
        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}