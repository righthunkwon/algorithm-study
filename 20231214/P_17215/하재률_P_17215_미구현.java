package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_17215_볼링점수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int idx = 0;
		int res = 0;
		while(idx < str.length()) {
			// 스트라이크 친 경우
			if(str.charAt(idx) == 'S') {
				res += 10; // 일단 10점 더하고
				// 9프레임까지라면 보너스 점수 부여할거야
				if(idx < str.length() - 3 || (str.charAt(str.length()-2) != 'S' && idx < str.length() - 2)) {
					// 다음 스트라이크라면 10점
					if(idx+1 < str.length() && str.charAt(idx+1) == 'S' ) res += 10;
					// 다음 쳤으면 그 점수
					else if(idx+1 < str.length() && str.charAt(idx+1) - '0' > 0 && str.charAt(idx+1) - '0' < 10) res += str.charAt(idx+1) - '0';
					// 다다음 스트라이크라면 10점
					if(idx+2 < str.length() && str.charAt(idx+2) == 'S') res += 10;
					// 다다음 스페어면 해당 점수 ( - P 면 10점 부여)
					else if(idx+2 < str.length() && str.charAt(idx+2) == 'P') {
						if(str.charAt(idx+1) != '-') res += 10 - (str.charAt(idx+1)-'0');
						else res += 10;
					}
					// 다다음 쳤으면 그 점수
					else if(idx+2 < str.length() && str.charAt(idx+2) - '0' > 0 && str.charAt(idx+2) - '0' < 10) res += str.charAt(idx+2) - '0';					
				}
			// 스페어 친 경우
			} else if (str.charAt(idx) == 'P') {
				// 해당 점수 ( - P 면 10점 부여)
				if(str.charAt(idx-1) != '-') res += 10 - (str.charAt(idx-1)-'0');
				else res += 10;
				// 보너스 점수 부여
				if(idx < str.length() - 2) {
					// 다음 스트라이크 쳤으면 10점 
					if(idx+1 < str.length() && str.charAt(idx+1) == 'S') res += 10;
					// 다음 쳤으면 그 점수 
					else if(idx+1 < str.length() && str.charAt(idx+1) - '0' > 0 && str.charAt(idx+1) - '0' < 10) res += str.charAt(idx+1) - '0';
				}
			// 못쳤으면 넘어가
			} else if (str.charAt(idx) == '-') {
			// 쳤으면 해당 점수
			} else {
				res += str.charAt(idx) - '0';
			}
			idx++;
		}
		System.out.println(res);
	}
}
