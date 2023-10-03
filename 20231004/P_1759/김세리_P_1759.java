import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class _1759_암호만들기 {
	static int L,C;
	static char[] arr;
	static boolean[] visited;
	static HashSet<String> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		L = Integer.parseInt(st[0]); // 암호 글자수(뽑을 문자 개수)
		C = Integer.parseInt(st[1]); // 주어진 문자 개수
		arr = new char [C]; // 주어진 전체 문자
		visited = new boolean [C];
		result = new HashSet<>();


		String[] s = br.readLine().split(" ");
		for(int i=0;i<C;i++) {
			arr[i] = s[i].charAt(0);
		}

		// 답이 정렬된 문자열로 나와야 하므로 정렬하고 시작한다
		Arrays.sort(arr);

		// 처음 시작점 0, 뽑은 문자 개수0으로 시작, 개수 늘면서 password도 추가된다
		combination(0, 0, "");

		for (String password : result) {
			System.out.println(password);
		}

	}//main

	public static void combination(int start, int count, String password) {
		//count가 L이될때 자음, 모음 조건 만족하는지 판별한다
		if (count == L) {
			if (isVowel(password) && isConsonant(password)) {
				// 자음, 모음 조건을 만족하면 result에 추가한다
				result.add(password);
			}
			return;
		}
		// 조합
		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(i + 1, count + 1, password + arr[i]);
				visited[i] = false;
			}
		}
	}//combination

	// 모음개수가 1 이상이면 true
	public static boolean isVowel(String password) {
		int count = 0;
		for (char c : password.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}
		}
		return count >= 1;
	}//isVowel

	// 자음개수가 2이상이면 true
	public static boolean isConsonant(String password) {
		int count = 0;
		for (char c : password.toCharArray()) {
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
				count++;
			}
		}
		return count >= 2;
	}//isConsonant
}
