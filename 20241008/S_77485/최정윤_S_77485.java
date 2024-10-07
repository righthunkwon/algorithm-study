import java.util.*;
class Solution {
    //400*10000완탐가능
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                board[i][j] = i*columns+j+1;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0]-1;
            int c1 = queries[i][1]-1;
            int r2 = queries[i][2]-1;
            int c2 = queries[i][3]-1;
            
            int temp = board[r1][c1]; 
            int min = temp;
            // 왼쪽 열 회전
            for (int j = r1; j < r2; j++) {
                board[j][c1] = board[j + 1][c1];
                min = Math.min(min, board[j][c1]);
            }
            // 아래 행 회전
            for (int j = c1; j < c2; j++) {
                board[r2][j] = board[r2][j + 1];
                min = Math.min(min, board[r2][j]);
            }
            // 오른쪽 열 회전
            for (int j = r2; j > r1; j--) {
                board[j][c2] = board[j - 1][c2];
                min = Math.min(min, board[j][c2]);
            }
            // 위 행 회전
            for (int j = c2; j > c1; j--) {
                board[r1][j] = board[r1][j - 1];
                min = Math.min(min, board[r1][j]);
            }
            board[r1][c1 + 1] = temp;
            answer[i] = min;
        }
        
        return answer;
    }
}
