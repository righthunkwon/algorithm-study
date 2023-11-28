package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린괄호 {
	// '-' 를 기준으로 자른다음 가장 큰 수를 만들어 빼버리자 !
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int ans = 987654321;
		
		while(st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			int tmp = 0;
			
			// "-"기준으로 자른거 안에 다 더해주기
			while(st2.hasMoreTokens()) tmp += Integer.parseInt(st2.nextToken());
			
			// "-"로 자른 첫 번째 그룹에서 모두 빼주어야함
			if(ans == 987654321) ans = tmp;
			else ans -= tmp;
		}
		
		System.out.println(ans);
	}
}
