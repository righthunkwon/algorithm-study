package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 식을 - 기준으로 나눈다
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		// 최솟값을 물었으므로 일단 답을 최댓값으로 설정한다.
		int ans = Integer.MAX_VALUE;
		
		// 처음에 -를 가지고 나눈 토큰이 존재하는 동안 아래 행위를 반복한다.
		while(st.hasMoreTokens()) {
			int sum = 0;
			// -로 나뉜 식 안에는 이제 숫자랑 +밖에 없으니까 +로 나누면 더할 숫자들이 나온다
			StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
			// +로 나눈 숫자들이 존재하는 동안 sum에다가 더해준다
			while(plus.hasMoreTokens()) {
				sum += Integer.parseInt(plus.nextToken());
			}
			
			// 만약에 ans가 최댓값이면 아직 첫번째 토큰이라는 소리이고,
			// 이땐 처음 더해진 sum은 앞에 뺄 수가 없으므로 ans로 한다
			if(ans == Integer.MAX_VALUE) ans = sum;
			// ans가 최댓값이 아니라면 첫번째 토큰이 아니라는 소리이고,
			// 이떈 더해서 나온 sum의 값을 ans에서 빼준다
			else ans -=sum;
		}
		
		System.out.println(ans);
	
	}//main

}
