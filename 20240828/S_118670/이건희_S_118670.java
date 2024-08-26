// 문제: 118670번 (행렬과 연산)
// 등급: Level 4
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/118670
// [풀이]
// 1차는 그냥 배열로 연속되는 중복 연산 누적해서 했는데, 배열길이가 커서 시간초과로 실패
// 2차는 Deque로 회전 할 때 코너에 있는 원소만 회전시키면 알아서 전체 회전 되는 원리 이용
// Deque에서는 중복 연산 누적해서 하는게 의미가 없어서 하나하나 실행
// deque 구역을 다양하게 쪼개서 작업해도 상관없는데 shift 연산 고려하면 지금 구조가 용이해서, 고정 될 수 밖에 없음
// [---------]
// []-------[]
// [---------]
// 2차 코드(힌트 참고) => Deque, https://school.programmers.co.kr/questions/37312
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length;
        int c = rc[0].length;

        Deque<Deque<Integer>> rows = new ArrayDeque<>();
        for (int[] row : rc) {
            Deque<Integer> newRow = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++) {
                newRow.add(row[j]);
            }
            rows.add(newRow);
        }

        Deque<Integer> firstCol = new ArrayDeque<>();
        Deque<Integer> lastCol = new ArrayDeque<>();
        for (int[] row : rc) {
            firstCol.add(row[0]);
            lastCol.add(row[c - 1]);
        }

        for (String op : operations) {
            if (op.equals("ShiftRow")) {
                rows.addFirst(rows.removeLast());
                firstCol.addFirst(firstCol.removeLast());
                lastCol.addFirst(lastCol.removeLast());
            } else if (op.equals("Rotate")) { // 한칸씩 밀면 알아서 회전
                rows.getLast().addLast(lastCol.removeLast());
                firstCol.addLast(rows.getLast().removeFirst());
                rows.getFirst().addFirst(firstCol.removeFirst());
                lastCol.addFirst(rows.getFirst().removeLast());
            }
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            result[i][0] = firstCol.pollFirst();
            int j = 1;
            for (int val : rows.pollFirst()) {
                result[i][j++] = val;
            }
            result[i][c - 1] = lastCol.pollFirst();
        }

        return result;
    }
}

// 1차 코드 => 효율성 2번 시간 초과
class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length;
        int c = rc[0].length;
        int currentCount = 0;
        String currentOp = operations[0];

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals(currentOp)) {
                currentCount++;
            } else {
                if (currentOp.equals("ShiftRow")) {
                    rc = shift(rc, currentCount, r, c);
                } else if (currentOp.equals("Rotate")) {
                    rc = rotate(rc, currentCount, r, c);
                }
                currentOp = operations[i];
                currentCount = 1; 
            }
        }
        // 마지막 누적 연산 실행
        if (currentOp.equals("ShiftRow")) {
            rc = shift(rc, currentCount, r, c);
        } else if (currentOp.equals("Rotate")) {
            rc = rotate(rc, currentCount, r, c);
        }

        return rc;
    }

    public int[][] shift(int[][] rc, int num, int r, int c) {
        num = num % r;
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            tmp[(i + num) % r] = rc[i];
        }
        return tmp;
    }

    public int[][] rotate(int[][] rc, int num, int r, int c) {
        num = num % (2 * (r + c - 2));
        int[] border = new int[2 * (r + c - 2)];
        int index = 0;
        for (int i = 0; i < c; i++) border[index++] = rc[0][i];
        for (int i = 1; i < r; i++) border[index++] = rc[i][c-1];
        for (int i = c-2; i >= 0; i--) border[index++] = rc[r-1][i];
        for (int i = r-2; i > 0; i--) border[index++] = rc[i][0];
        int[] rotated = new int[border.length];
        for (int i = 0; i < border.length; i++) {
            rotated[(i + num) % border.length] = border[i];
        }
        index = 0;
        for (int i = 0; i < c; i++) rc[0][i] = rotated[index++];
        for (int i = 1; i < r; i++) rc[i][c-1] = rotated[index++];
        for (int i = c-2; i >= 0; i--) rc[r-1][i] = rotated[index++];
        for (int i = r-2; i > 0; i--) rc[i][0] = rotated[index++];
        return rc;
    }
}