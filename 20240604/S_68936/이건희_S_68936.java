// 문제: 68936번 (쿼드압축 후 개수 세기)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68936
// 1024 -> 512 -> 256 -> 128 -> 64 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1
// 1024 = 2^10
// 2^10*2 + 2^9*2*2^2 + 2^8*2*2^4 + ~ 1*1*2^400? 
// 메모리 생각하면 배열 카피를 하면 안되고 static으로 올려야 할까?
// 중복연산을 막을 방법이 있나?
class Solution {
    static int one;
    static int zero;
    static int[][] input;
    public int[] solution(int[][] arr) {
        one = 0; zero = 0;
        input = arr;
        int n = arr.length;
        dfs(0, n, 0, n);
        int[] answer = {zero,one};
        return answer;
    }
    
    public void dfs(int xs, int xe, int ys, int ye) {
        int tmp = input[xs][ys];
        boolean toggle = true;

        L: for (int i = xs; i < xe; i++) {
            for (int j = ys; j < ye; j++) {
                if (input[i][j] != tmp) {
                    toggle = false;
                    break L;
                }
            }
        }

        if (toggle) {
            if (tmp == 1) {
                one++;
            } else {
                zero++;
            }
        } else {
            int midX = (xs + xe) / 2;
            int midY = (ys + ye) / 2;
            dfs(xs, midX, ys, midY);
            dfs(xs, midX, midY, ye);
            dfs(midX, xe, ys, midY);
            dfs(midX, xe, midY, ye);
        }
    }
}