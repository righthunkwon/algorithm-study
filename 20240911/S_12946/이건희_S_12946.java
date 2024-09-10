import java.util.*;
class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        move(1, 2, 3, n);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        return answer;
    }
    static void move(int start, int mid, int end, int n) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        move(start, end, mid, n - 1);
        list.add(new int[]{start, end});
        move(mid, start, end, n - 1);
    }
}