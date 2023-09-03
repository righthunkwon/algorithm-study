package 백준;

import java.util.Scanner;

public class BOJ_16974_레벨햄버거 {
	// 햄버거를 전부 구현하려니까 메모리초과 에러뜬다...ㅠ
	public static int N;
	public static long X;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextLong();

		long[] total = new long[N + 1]; // 재료수, index는 레벨
		long[] patty = new long[N + 1]; // 패티수, index는 레벨
		// 0레벨은 패티만 한장
		total[0] = 1; 
		patty[0] = 1;
		
		// 해당 레벨의 총 재료수와 총 패티수를 구하자
		for(int i = 1; i <= N; i++) {
			total[i] = 1 + total[i-1] + 1 + total[i-1] + 1; // 빵 + (레벨-1 버거) + 패티 + (레벨-1 버거) + 빵
			patty[i] = patty[i-1] + 1 + patty[i-1]; // (레벨-1버거의 패티) + 패티 + (레벨-1버거의 패티)
		}
		long res = getPatty(N,X, total, patty);
		System.out.println(res);
		
	}
	
	public static long getPatty(int N, long X, long[] total, long[] patty) {
		// 레벨 0 햄버거는 패티만 딸랑 한 장
		if(N == 0) return X == 0 ? 0 : 1;
		
		long middleP = total[N-1] + 1;
		
		if(X == 1) return 0;
		// X가 중간패티 위치보다 작으면 이전 레벨의 햄버거를 호출
		// 맨 밑에 빵 하나 빼야하니까 X-1을 넘겨주자
		else if(X <= middleP) return getPatty(N-1, X-1, total, patty);
		
		// X가 중간 패티 위치라면 이전 레벨 햄버거 + 가운데 패티 하나
		else if(X == middleP + 1) return patty[N-1] + 1;
		
		// X가 중간패티보다 크고 총 재료수보다 작다면
		// X 에서 (패티 + 이전 레벨 햄버거 총 재료수 + 빵) 을 빼준 값을 넘겨서
		// B [level-1] P [level-1] B
		// ........|................
		// |의 오른쪽 P 너머 값인 patty[N-1] (이전 레벨의 패티 수)와
		// 이전 레벨의 패티 수를 더해주면 된다
		else if(X <= middleP * 2 + 2) 
			return patty[N-1] + 1 + getPatty(N-1, X - middleP - 1, total, patty);
		
		// X가 해당 레벨 총 재료수와 면 현재 레벨 패티수 반환
		else return patty[N];
		
	}
	
}
