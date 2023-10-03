package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int pack = 987654321;
		int piece = 987654321;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pack = Math.min(pack, Integer.parseInt(st.nextToken())); // 가장 저렴한 패키지 가격만 필요
			piece = Math.min(piece, Integer.parseInt(st.nextToken())); // 가장 저렴한 낱개 가격만 필요
		}
		int ans = 0;
		
		// 낱개 6개 가격이 패키지 가격보다 싸다면
		if(piece * 6  <= pack) {
			ans = piece * N; // 모두 낱개로 구매하자!
		} else { // 패키지 가격이 더 싸다면
			ans = (N / 6)  * pack; // 패키지로 살 수 있을만큼 사고
			// 나머지를 패키지로? 낱개로?
			if((N % 6) * piece <= pack) {
				ans += (N % 6) * piece; // 나머지를 낱개로 사기
			} else {
				ans += pack; // 나머지를 패키지로 사기
			}
		}
		
		System.out.println(ans);
	}
}
