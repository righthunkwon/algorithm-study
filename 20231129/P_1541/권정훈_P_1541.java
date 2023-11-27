package level_25_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 잃어버린 괄호
// 괄호를 쳐서 식의 값을 최소로 만들기
// 괄호의 개수에 제한이 없으므로 가능한 한 많은 요소들을 빼줘야 한다.
// 뺄셈을 기준으로 문자열을 분리하고 나머지 요소들을 더해서 더한 값들을 빼준다.
// 식은 양수와 기호만으로 구성되므로 처음으로 - 기호가 나오기 전까지는 무조건 양수이다.

// 정규표현식 패턴과 관련된 유의점
// 문자열의 ?, *, +, [, ], {, }, (, )와 같은 문자를 
// replace, replaceAll, split할 때는 반드시 해당 문자 앞에 \\를 붙여야 한다. 
public class P_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sarr = s.split("-");

		int ans = 0; // 정답
		for (int i = 0; i < sarr.length; i++) {
			String[] narr = sarr[i].split("\\+"); // 더해서 빼줄 수들의 배열
			
			int sum = 0; // 임시합
			for (int j = 0; j < narr.length; j++) {
				sum += Integer.parseInt(narr[j]);
			}
			
			// -가 나오기 전 첫번째 식은 항상 양수이므로 더해준다
			if (i == 0 ) {
				ans += sum;
			} else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}

}

