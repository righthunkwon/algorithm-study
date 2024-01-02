package _20240103;

import java.util.*;
import java.io.*;

public class _4920_테트리스게임2 {

    static int[][][] figure = {
    		// 앞부분이 행값이고 뒷부분이 열값임
        { // ㅡ
            {0, 0, 0, 0}, {0, 1, 2, 3}
        },
        { // ㅣ
            {0, 1, 2, 3}, {0, 0, 0, 0}
        },

        { // Z
            {0, 0, 1, 1}, {0, 1, 1, 2}
        },
        { // Z 90도 회전
            {0, 1, 1, 2}, {0, 0, -1, -1}
        },

        { // ㄱ
            {0, 0, 0, 1}, {0, 1, 2, 2}
        },
        { // ㄱ 90도 회전
            {0, 1, 2, 2}, {0, 0, 0, -1}
        },
        { // ㄱ 180도 회전, ㄴ
            {0, 1, 1, 1}, {0, 0, 1, 2}
        },
        { // ㄱ 270도 회전
            {0, 0, 1, 2}, {0, 1, 0, 0}
        },

        { // ㅗ
            {0, 1, 1, 1}, {0, -1, 0, 1}
        },
        { // ㅏ
            {0, 1, 1, 2}, {0, 0, 1, 0}
        },
        { // ㅜ
            {0, 0, 0, 1}, {0, 1, 2, 1}
        },
        { // ㅓ
            {0, 1, 1, 2}, {0, -1, 0, 0}
        },

        { // ㅁ
            {0, 0, 1, 1}, {0, 1, 1, 0}
        },

    };
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=0;
        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
        	tc++;
            arr = new int[N][N];
            int max = Integer.MIN_VALUE;
            for (int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    for (int a=0;a<figure.length;a++) {
                        int sum = 0;
                        boolean flag = true;
                        for (int b=0;b<4;b++) {
                            int nx = i +figure[a][0][b];
                            int ny = j +figure[a][1][b];
                            if (nx>=0 && nx<N && ny>=0 && ny<N) {
                                sum += arr[nx][ny];
                            } else {
                            	// 범위 벗어난건 더 구하지 않고 다음으로 넘어간다
                                flag = false;
                                break;
                            }
                        }
                        // 범위 내에서 구해진 합을 바탕으로 max값을 구한다
                        if (flag) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(tc+". "+max);
        }
    }
}
