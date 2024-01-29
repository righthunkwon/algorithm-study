import java.io.*;
import java.util.*;

public class Pro_11497_통나무건너뛰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] h = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
//			5310246 =>0~1과 N-1~N제외 2차이
			Arrays.sort(h);
			int max=0;
			for(int i=0;i<N-2;i++) {
				max=Math.max(max, h[i+2]-h[i]);
			}
			max=Math.max(h[1]-h[0], max);  //0~1
			max=Math.max(h[N-1]-h[N-2], max);  //N-1~N
			System.out.println(max);
		}
	}
}
