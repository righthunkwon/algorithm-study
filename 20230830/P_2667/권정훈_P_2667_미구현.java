import java.util.Scanner;

public class P_2667 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 단지의 크기
		int[][] arr = new int[n][n]; // 단지 배열

		// 단지 배열 요소 입력
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		
		// A형 풀숙면 때린 사람으로서
		// 자세한 해설이 필요합니다 (╯︵╰,) 
	}
}
