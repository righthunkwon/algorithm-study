package _20240320;

import java.util.*;
import java.io.*;

public class _2342_DanceDanceRevolution {
	static int[] steps;
    static int size;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 0 전까지 입력 받는다
        List<Integer> stepList = new ArrayList<>();
        while (true) {
            int step = Integer.parseInt(st.nextToken());
            if (step == 0) {
                break;
            }
            stepList.add(step);
        }
        size = stepList.size();
        steps = new int[size];
        for (int i = 0; i < size; i++) {
            steps[i] = stepList.get(i);
        }
        
        // dp: [지시사항][왼][오]
        dp = new int[size][5][5];
        
        // 전부 -1로 채운다(했는지 아닌지 구분 위해서)
        for (int i=0;i<size;i++) {
            for (int j=0;j<5;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        System.out.println(ddr(0, 0, 0));
    }

    static int ddr(int idx, int left, int right) {
        if (idx == size) {
            return 0;
        }
        // -1 아닐 땐 dp값을 반환
        if (dp[idx][left][right] != -1) {
            return dp[idx][left][right];
        }

        int next = steps[idx];
        
        // 움직이는 쪽 발에 따라서 ddr값+움직일 때 추가해야 하는힘을 각각 구한다
        int leftMove = ddr(idx+1, next, right) + move(left, next);
        int rightMove = ddr(idx+1, left, next) + move(right, next);
        
        // 그리고 두 발을 움직이는 것 중에 더 작은 힘이 드는 값을 dp에 저장한다.
        dp[idx][left][right] = Math.min(leftMove, rightMove);
        return dp[idx][left][right];
    }

    static int move(int from, int to) {
        if (from == 0) return 2; // 중앙에서 다른 곳으로 이동
        if (from == to) return 1; // 같은 곳으로 이동
        if (Math.abs(from - to) == 2) return 4; // 반대편으로 이동
        return 3; // 인접한 위치로 이동
    }
}
