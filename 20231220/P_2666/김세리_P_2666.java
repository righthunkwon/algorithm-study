package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2666_벽장문의이동 {
    static int N, M;
    static int[] use;
    static Integer[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int door1 = Integer.parseInt(st.nextToken());
        int door2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        use = new int[M];
        for (int i = 0; i < M; i++) {
            use[i] = Integer.parseInt(br.readLine());
        }

        // 동적 프로그래밍을 위한 메모리 할당
        dp = new Integer[M][N + 1][N + 1];
        System.out.println(move(0, door1, door2));
    }

    private static int move(int useIndex, int door1, int door2) {
        if (useIndex == M) return 0;

        if (dp[useIndex][door1][door2] != null) {
            return dp[useIndex][door1][door2];
        }

        int next = use[useIndex];
        int move1 = Math.abs(next - door1);
        int move2 = Math.abs(next - door2);

        // 문을 이동한 다음 재귀적으로 다음 상태 계산
        // 첫번째 벽장문 이동시키는 경우
        int moveNext1 = move(useIndex+1, next, door2) + move1;
        // 두번째 벽장문 이동시키는 경우
        int moveNext2 = move(useIndex+1, door1, next) + move2;

        dp[useIndex][door1][door2] = Math.min(moveNext1, moveNext2);
        return dp[useIndex][door1][door2];
    }
}
