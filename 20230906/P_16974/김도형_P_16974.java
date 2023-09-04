//햄버거 번을 0으로, 패티를 1로 계산해서 
//0번 인덱스부터 X-1번 인덱스까지 더하면 패티 수 구할 수 있을듯  
//=> 실패 ... charAt()은 int로만 가능...=> 범위 초과

package silver;

import java.util.Scanner;

public class BaekJoon_Q16974_레벨_햄버거 {

	public static long[] patties, burgersize; // 패티 수 배열 (인덱스를 N값으로 하는 패티 수)
	public static int N; // 레벨 N 버거
	public static long X; // 아래 X장 먹음
	public static long ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 레벨-N 버거를 주문
		X = sc.nextLong(); // 햄버거 아래 X장을 먹음(21억 넘을 수 있어서 long 사용)

		patties = new long[51]; // 버거 패티 수 1<= N <= 50 이므로
		burgersize = new long[51]; // 버거 크기 ( 빵 + 패티 )
		
		// 패티 수와 버거 크기를 미리 계산해 두기
        patties[0] = 1;     
        burgersize[0] = 1;   //0번 인덱스는 따로 입력해줘야 이어서 구할 수 있음!
		for (int i = 1; i <= 50; i++) {
            patties[i] = 2 * patties[i - 1] + 1;
            burgersize[i] = 2 * burgersize[i - 1] + 3;
        }

		ans = countPatti(N, X);

		System.out.println(ans);

	}

	public static long countPatti(int n, long x) { // 버거 레벨 : n , 아래 x장 먹음
		// n이 0이면 패티 1장인 상태
		if (n == 0) {
			if (x == 0) { 
				return 0;
			} else if (x == 1) { //패티만 1장 먹고 끝
				return 1;
			}

		} else if (x == 1) { //n이 0이 아니고 1개만 먹으면 빵만 먹고 끝
			return 0;
		}

		// x장이 버거사이즈 절반보다 작으면..
		if (x < burgersize[n - 1] + 2)
			return countPatti(n - 1, x - 1); // 맨앞 빵 빼주고 ( x-1 ) 그 전 레벨 버거 패티 카운팅으로 재귀

		// x장이 정확히 n레벨 버거사이즈의 중심까지면
		else if (x == burgersize[n - 1] + 2) {
			return patties[n - 1] + 1; // 딱 그전 레벨 버거 패티 수에서 중앙꺼 1개 더해주면 된다!
		}

		// x장이 버거사이즈 절반보다 크면..
		else if (x < ((burgersize[n-1])*2)+2) {
			return patties[n - 1] + 1 + countPatti(n - 1, x - burgersize[n - 1] - 2);
		} // 앞에 절반은 n-1버거의 패티 수를 더해주면 되고,
			// 절반 뒤에 있는 n-1 버거의 패티 수 카운팅을 해주되, x값은 앞 절반까지를 빼줘야 함

		else
			return (patties[n - 1]) * 2 + 1;

	}

}

//참고 : https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-16974-%EA%B2%89%EB%84%93%EC%9D%B4-%EA%B5%AC%ED%95%98%EA%B8%B0-Java%EC%9E%90%EB%B0%94
