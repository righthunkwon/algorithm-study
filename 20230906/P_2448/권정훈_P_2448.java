package level_21_recursion;

import java.util.Scanner;

// 별찍기 - 11
// 알고리즘 문제를 풀 때 문제가 잘 이해되지 않거나 구현이 어려울 경우
// 일부 조건을 제외하고 구현하기 용이한 부분부터 차근차근 구현한 뒤에 조건을 적용하면 나을 수 있다. 

// 먼저, 첫 삼각형(n=3)을 만든다(규칙 찾지 말고 그냥 만든다).
// 이후 첫 삼각형을 감싸는 3*5의 사각형을 기준으로 규칙을 찾는다.
// n이 3*2^k이므로 k=1일 때, k=2일 때, k=3일 때 규칙을 찾아본다.

// n=6(3*2^k에서 k가 1일 때)
// 기존 0~2행의 초기 삼각형에는 양쪽에 공백 3칸 추가(공백=3*1)
// 새로 만들어진 3~5행의 삼각형은 초기 삼각형의 구조를 따르되, 가운데 공백 한 칸을 기준으로 구분
// 인덱스는 0일떄 3, 1일때 4, 2일때 5를 따른다(주기: 3). 

// n=12(3*2^k에서 k가 2일 때)
// 기존 0~5행의 삼각형에는 양쪽에 공백 6칸 추가(공백=3*2)
// 새로 만들어진 6~11행의 삼각형은 기존 삼각형의 구조를 따르되, 가운데 공백 한 칸을 기준으로 구분
// 인덱스는 0일떄 6, 1일때 7, 2일때 8, 3일때 9, 4일때 10, 5일때 11을 따른다(주기: 6).

public class P_2448 {
	private static String[] str; // 별 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 3*2^k의 수 (n=3,6,12,24,28, ...)

		// 삼각형(k=0)
		str = new String[n];
		str[0] = "  *  ";
		str[1] = " * * ";
		str[2] = "*****";

		// 삼각형(k=1,2,3, ...)
		// k번 동안 함수 반복하여 호출
		for (int k = 1; 3*(1<<k) <= n; k++) {
			makestar(k);
		}
		
		// 정답 출력(n행 만큼 출력)
		for (int i = 0; i < n; i++) {
			System.out.println(str[i]);
		}
	}

	private static void makestar(int k) {
		// 위를 기준으로 아래를 만드므로
		// 아래를 만든 뒤 위를 수정하는 방식을 반복한다.
		
		// 위	: 0 ~ middle
		// 아래	: middle ~ bottom 
		int bottom = 3*(1<<k); // 6, 12, 24, 48, ...
		int middle = bottom/2; // 3,  6, 12, 24, ...
		
		// 아래 부분
		// 행마다 별 찍기, 중간은 공백으로 구분
		for (int i = middle; i < bottom; i++) {
			str[i] = str[i - middle] + " " + str[i - middle];
		}
		
		// 위 부분
		// 공백 추가
		// 공백의 크기 = middle
		String space = ""; // 공백 초기화
		while (space.length() < middle) {
			space += " "; 
		}
		
		// 위 부분 행마다 공백 추가
		for (int i = 0; i < middle; i++) {
			str[i] = space + str[i] + space;
		}
	}
}
