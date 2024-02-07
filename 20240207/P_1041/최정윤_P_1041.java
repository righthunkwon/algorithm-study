import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int[] dice = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min_1 = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			// 한개 중 최솟값 구하기
			min_1 = Math.min(min_1, dice[i]);
		}
		if(N==1) {
			Arrays.sort(dice);
			int sum=0;
			for(int i=0;i<5;i++) {
				sum+=dice[i];
			}
			System.out.println(sum);
		}
		else {
		// 세개 조합 중 최솟값 구하기
		long min_3 = Integer.MAX_VALUE;
		long[][] arr = new long[][] { { 4, 0, 2 }, { 4, 0, 3 }, { 0, 1, 2 }, { 0, 1, 3 }, { 1, 5, 2 }, { 1, 5, 3 },
				{ 4, 5, 3 }, { 4, 5, 2 } };
		for (int i = 0; i < arr.length; i++) {
			long sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += dice[(int) arr[i][j]];
			}
			min_3 = Math.min(min_3, sum);
		}

		// 두개 조합 중 최솟값 구하기
		long min_2 = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (j == 5 - i)
					continue;
				min_2 = Math.min(min_2, dice[i] + dice[j]);
			}
		}

//		3개짜리는 4개, 2개짜리는 4+(N-2)*8, 1개짜리는 (N-2)*(N-1)*4+(N-2)*(N-2)
//		System.out.println(min_1 + "dddddd" + min_2 + "dddddddd" + min_3);
		long result = 4 * min_3 + (4 + (N - 2) * 8) * min_2 + ((N - 2) * (N - 1) * 4 + (N - 2) * (N - 2)) * min_1;
		System.out.println(result);}
	}
}
