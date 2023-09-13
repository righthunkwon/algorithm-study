package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int su = Integer.parseInt(br.readLine());
		int[] minx = new int[su];//x시작점
		int[] miny = new int[su];//y시작점
		for (int i = 0; i < su; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			minx[i] = Integer.parseInt(st.nextToken());
			miny[i] = Integer.parseInt(st.nextToken());
		}

		int[][] paper = new int[100][100];
		//가로,세로 100 0~99 2차원배열 선언
		for (int i = 0; i < su; i++) {
			for (int x = minx[i]; x < minx[i] + 10; x++) {
				for (int y = miny[i]; y < miny[i] + 10; y++) {
					paper[y][x] = 1;//중복이였어도 무조건 1로 바뀜
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] == 1) {//1인거 카운트 =>검은색 영역의 넓이
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
