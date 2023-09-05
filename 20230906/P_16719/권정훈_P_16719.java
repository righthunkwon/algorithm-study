package level_21_recursion;

import java.util.Scanner;

// ZOAC
// 분할정복(문자열마다 계속해서 가장 작은 문자를 찾는 행위를 반복)
public class P_16719 {
	private static String str; // 입력 문자열
	private static StringBuilder sb; // 출력 결과 저장
	private static boolean[] visited; // 방문여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세팅
		str = sc.next();
		sb = new StringBuilder();
		visited = new boolean[str.length()];

		// 메소드 호출
		zoac(0, str.length()-1);
		
		// 정답 출력
        System.out.println(sb.toString());
	}

	private static void zoac(int st, int ed) {
		// 기저부분(종료조건)
		// 시작 인덱스가 종료 인덱스보다 크면 함수 종료
		if (st > ed) {
			return;
		}
		
		// 재귀부분(반복수행)
		// 알파벳 순서가 가장 빠른 글자 찾기(아스키 코드가 가장 작은 글자의 인덱스 찾기)
        int idx = st;
        for (int i = st; i <= ed; i++) {
            if (str.charAt(i) < str.charAt(idx)) {
                idx = i;
            }
        }
        
        // 알파벳 순서가 가장 빠른 글자의 인덱스에 대해 방문처리
        visited[idx] = true;

        // 현재까지 방문한 문자들을 StringBuilder에 저장
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        
        // 기존 방문 기록과 구분하기 위해 공백문자 추가
        sb.append("\n"); 

        // 분할정복 수행
        zoac(idx+1, ed); // 오른쪽 부분문제
        zoac(st, idx-1); // 왼쪽 부분문제
	}

}
