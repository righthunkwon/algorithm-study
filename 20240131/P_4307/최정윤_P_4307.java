
import java.io.*;
import java.util.*;
//충돌하고 돌아서도 결국 같은 방향으로 간다고 생각하는 그런 ..... 어려운 문제 ....
public class Pro_4307_개미 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] idx = new int[n];
			for (int i = 0; i < n; i++) {
				idx[i] = Integer.parseInt(br.readLine());
			}
			int max = 0;
			int min = 0;
			// 일단 최단시간 출력
			for (int i = 0; i < n; i++) {
				if (idx[i] >= len / 2) {
					max = Math.max(max, len - idx[i]);
					min = Math.max(min, idx[i]);
				} else {
					max = Math.max(max, idx[i]);
					min = Math.max(min, len - idx[i]);
				}
			}
			System.out.println(max+" "+min);
		}
	}
}
