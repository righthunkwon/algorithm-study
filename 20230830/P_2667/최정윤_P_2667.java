
import java.io.*;
import java.util.*;

public class Problem_2667_단지번호붙이기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();

		} // 입력끝
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '1') {
					arr[i][j]='0';
					list.add(danji(i, j)+1);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static char[][] arr;
	public static int N;

	public static int danji(int R, int C) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (R + dr[i] >= 0 && R + dr[i] < N && C + dc[i] >= 0 && C + dc[i] < N
					&& arr[R + dr[i]][C + dc[i]] == '1') {
				count++;
				arr[R + dr[i]][C + dc[i]] = '0';
				count += danji(R + dr[i], C + dc[i]);
			}
		}
		return count;
	}
}
