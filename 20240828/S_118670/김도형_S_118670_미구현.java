import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        
        String[]testOp = {"ShiftRow"};
        
        int n = rc.length;
        int m = rc[0].length;
        int[][] answer = new int[n][m];
        
        // 2차원 deque??
        Deque<Deque<Integer>> rd = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Deque<Integer> cd = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                cd.add(rc[i][j]);
            }
            rd.add(cd);
        }
        
        // 연산 수행
        for (String op : testOp) {
            if (op.equals("ShiftRow")) {
                // 행을 아래로 이동
                rd.addFirst(rd.pollLast());
            } else if (op.equals("Rotate")) {
                // 모르겠음..
            }
        }
        
        // 결과를 answer 배열로 변환
        int i = 0;
        for (Deque<Integer> row : rd) {
            int j = 0;
            for (Integer num : row) {
                answer[i][j++] = num;
            }
            i++;
        }
        
        return answer;
    }
}
