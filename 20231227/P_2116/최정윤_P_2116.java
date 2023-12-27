import java.io.*;
import java.util.StringTokenizer;

public class Pro_2116_주사위쌓기 {
  	static int result;
  	static int N, Max;
  	static int[][] dice;
  	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		// 0,5 //1,3 //2,4 => 0,3 /1,4/2,5로 변경하자
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}
		Max = 0;
		// 1번이 바닥일때 ~ 6번이 바닥일때 구현
		for (int i = 0; i < 6; i++) {
			result = 0;
			build(dice[0][i], 0);
		}
		System.out.println(Max);
	}

	private static void build(int i, int idx) { //바닥에 i가 오도록 만들어라!!!!!!!!!!, idx층이다!!!!!
		if (idx == N) {//N개 쌓였을때
			Max = Math.max(result, Max); //최댓값
			return;
		}
		int max = 0;
		int rev_i = -1;
		for (int j = 0; j < 6; j++) {//6면확인
			if (dice[idx][j] == i) { //바닥에 와야하는 값이면 
				rev_i = (j + 3) % 6; //반대면 구하기 
			} else if (dice[idx][(j + 3) % 6] != i) {
				max = Math.max(max, dice[idx][j]); //옆면일떄만
			}
		}
		result += max;//옆면중 최댓값 더하기
		build(dice[idx][rev_i], idx + 1); //반복
	}
}
