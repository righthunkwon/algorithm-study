import java.io.IOException;
import java.util.Scanner;

// 테트리스 게임
// 좌표 지정 후 푸는 게 제일 빠를지도...
public class P_4920 {

	// 선조의 지혜
    private static int[][][] figure = {
        {
            {0, 0, 0, 0}, 
            {0, 1, 2, 3}
        },
        {
            {0, 1, 2, 3}, 
            {0, 0, 0, 0}
        },
        {
            {0, 0, 1, 1}, 
            {0, 1, 1, 2}
        },
        {
            {0, 1, 1, 2}, 
            {0, 0, -1, -1}
        },
        {
            {0, 0, 0, 1}, 
            {0, 1, 2, 2}
        },
        {
            {0, 1, 2, 2}, 
            {0, 0, 0, -1}
        },
        {
            {0, 1, 1, 1}, 
            {0, 0, 1, 2}
        },
        {
            {0, 0, 1, 2}, 
            {0, 1, 0, 0}
        },
        {
            {0, 1, 1, 1}, 
            {0, -1, 0, 1}
        },
        {
            {0, 1, 1, 2}, 
            {0, 0, 1, 0}
        },
        {
            {0, 0, 0, 1}, 
            {0, 1, 2, 1}
        },
        {
            {0, 1, 1, 2}, 
            {0, -1, 0, 0}
        },
        {
            {0, 0, 1, 1}, 
            {0, 1, 1, 0}
        },
    };
    
    private static int N, ans;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int testCase = 1;
		while ((N = sc.nextInt()) != 0) {
			map = new int[N][N];
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < figure.length; k++) {
						int sum = 0; // 임시 합
						boolean flag = true;
						for (int l = 0; l < 4; l++) {
							int nx = i + figure[k][0][l];
							int ny = j + figure[k][1][l];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								sum += map[nx][ny];
							} else {
								flag = false;
								break;
							}
						}
						if (flag) {
							ans = Math.max(sum, ans);
						}
					}
				}
			}
			System.out.println(testCase++ + ". " + ans);
		}
	}
}
