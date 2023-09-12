package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Pro_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int su = Integer.parseInt(br.readLine());
		int[] minx = new int[su];
		int[] miny = new int[su];
		for (int i = 0; i < su; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			minx[i] = Integer.parseInt(st.nextToken());
			miny[i] = Integer.parseInt(st.nextToken());
		}

		int[][] paper = new int[100][100];
		for (int i = 0; i < su; i++) {
			for (int x = minx[i]; x < minx[i] + 10; x++) {
				for (int y = miny[i]; y < miny[i] + 10; y++) {
					paper[y][x] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
