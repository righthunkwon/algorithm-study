package level_22_backtracking;

import java.util.Scanner;

// 행운의 문자열
// 백트래킹, 문자열의 길이를 depth로 해서 탐색 제한
// 이전에 입력한 알파벳과 같은지 다른지를 통해 유망성 검사
// 알파벳이 중복될 수 있으므로 boolean의 visited 배열이 아니라,
// 알파뱃 개수를 저장하는 카운팅 배열을 활용하여 해당 배열의 요소가 0일 경우 없다고 판단
public class P_1342 {
	private static int ans; // 정답
	private static int[] arr = new int[26]; // 알파벳 개수 저장 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 입력 문자열
		int len = s.length(); // 문자열의 길이(dfs의 depth)
		for (int i = 0; i < len; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		dfs(0, ' ', len); // 시작점, 이전 문자, 총 탐색 횟수(depth)
		System.out.println(ans);
	}
	
	private static void dfs(int st, char before, int len) {
		// 기저부분(종료조건)
		if (st == len) {
			ans++;
			return;
		}
		
		// 재귀부분(반복수행)
		for (int i = 0; i < 26; i++) {
			
			// 새로 탐색할 알파벳이 존재하고,
			// 이전에 입력받은 알파벳과 새로 탐색할 알파벳이 다를 경우에
			if (arr[i] != 0 && before != (char) (i+'a')) {
				arr[i]--; // 알파벳의 개수를 줄이고(방문처리)
				dfs(st+1, (char)(i+'a'), len); // 새로 입력받은 알파벳을 기준으로 다음 깊이 우선 탐색을 한 뒤
				arr[i]++; // 알파벳의 개수를 되돌린다(방문처리 해제)
				
			}
		}
	}
}
