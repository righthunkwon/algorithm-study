
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
					arr[i][j]='0';//1이면 0으로 우선 바꾸고 나중에 cnt+1
					list.add(danji(i, j)+1);//리스트에 단지 수 넣기
				}
			}
		}
		Collections.sort(list);//오름차순 정렬
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static char[][] arr;
	public static int N;

	public static int danji(int R, int C) {//4방탐색하는 메소드,count를 반환
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int count = 0;
		for (int i = 0; i < 4; i++) {//4방 탐색
			if (R + dr[i] >= 0 && R + dr[i] < N && C + dc[i] >= 0 && C + dc[i] < N
					&& arr[R + dr[i]][C + dc[i]] == '1') {
				//범위 안이고 1이면
				count++;//카운트 +1
				arr[R + dr[i]][C + dc[i]] = '0';//그 자리 0,
				count += danji(R + dr[i], C + dc[i]);//그 자리부터 다시 탐색
			}
		}
		return count;
	}
}
