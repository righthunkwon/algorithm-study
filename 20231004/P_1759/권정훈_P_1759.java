package level_19_combinatorics;

import java.util.Arrays;
import java.util.Scanner;

// 암호 만들기
// 사전 순서(Arrays.sort())
// 최소 하나의 모음과 두 개의 자음(개수 직접 카운트)
public class P_1759 {
	private static int l, c, vowelCnt, consonantCnt;
	private static String[] sarr, parr;
	private static boolean isVowel;
	private static String[] vowel = { "a", "e", "i", "o", "u" };
	private static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder(); // 정답을 담을 스트링빌더

		l = sc.nextInt(); // 사용한 알파벳의 개수
		c = sc.nextInt(); // 문자의 종류 개수
		sarr = new String[c]; // 선택할 수 있는 문자 배열
		parr = new String[l]; // 출력할 문자 배열

		// 선택 가능한 문자 배열 요소 입력
		for (int i = 0; i < c; i++) {
			sarr[i] = sc.next();
		}

		Arrays.sort(sarr); // 사전순 반영
		recursion(0, 0); // 재귀
		System.out.println(sb); // 정답 출력
	}

	public static void recursion(int st, int depth) {
		// 기저부분
		// l개를 선택
		if (depth == l) {
			// 모음이 최소 하나이고 자음이 최소 두 개인 조건을 만족하면 암호 후보
			if (check()) {
				for (int i = 0; i < l; i++) {
					sb.append(parr[i]);
				}
				sb.append("\n");
			}
			return;
		}

		// 재귀부분
		for (int i = st; i < sarr.length; i++) {
			parr[depth] = sarr[i];
			recursion(i + 1, depth + 1);
		}
	}

	public static boolean check() {
		vowelCnt = 0; // 모음의 개수
		consonantCnt = 0; // 자음의 개수

		for (int i = 0; i < l; i++) {
			isVowel = false;

			// 모음일 경우
			for (int j = 0; j < vowel.length; j++) {
				if (parr[i].equals(vowel[j])) {
					isVowel = true;
					vowelCnt++;
				}
				if (isVowel) {
					break;
				}
			}
			// 자음일 경우
			if (!isVowel) {
				consonantCnt++;
			}

			// 조건을 만족할 경우 true
			if (vowelCnt >= 1 && consonantCnt >= 2) {
				return true;
			}
		}

		// 조건을 만족하지 못했을 경우 false
		return false;
	}
}
