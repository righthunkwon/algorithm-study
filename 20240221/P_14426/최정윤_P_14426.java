import java.io.*;
import java.util.*;

//61퍼 시간초과 해결 ...해..
public class Pro_14426_접두사찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= input.length(); j++) {
				set.add(input.substring(0, j));
			}
		}
		int result = 0;
		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine())) {
				result++;
			}
		}

		System.out.println(result);
	}
}
