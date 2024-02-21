package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 지뢰 하나는 세 칸에 영향을 줌
// 양쪽 끝 빼고(양쪽 끝은 두 칸)
public class BOJ_9082_지뢰찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				cnt += input.charAt(i) - '0';
			}
			br.readLine();
			
			System.out.println((cnt+2)/3);
		}
	}
}
