import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static long N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c=  sc.nextLong();
		long d = sc.nextLong();
		// N개의 개수를 구매할 때
		// 더 낮은 가격을 구매하게 하고
		// 가성비 개수보다 낮은 숫자일때만
		// 어떤게 더 이득인지 계산하면 됨
		// 정답

		// 가성비가 좋지않은 것을 앞에다 놓는것
		if (b * c < d * a) { // D/C > B/A ->  D / C * A > B -> D * A > B * C (가성비가 안 좋은 것을 선택)
			// 뒤에있는 것이 가성비가 더 좋지 않은 것으로
			// a와b랑 c와d의 자리 바꾸는 과정
			long tmp = b;
			b = d;
			d = tmp;
			tmp = a;
			a = c;
			c = tmp;
		}
		// 이과정을 거치면
		// 앞에있는게 더 가성비가 안좋음
		long ans = Long.MAX_VALUE; 
		// 가성비가 안좋은 다발을 0개 구매할 떄부터
		// c-1개까지 구매할 경우를 for문 돌림
		for (int i = 0; i < c; i++) { //가성비가 안 좋은 것을 돌림 
			long tmp = (long) Math.ceil((double)(N - i * a)/c);
			// tmp가 음수가 나온것은
			// 이미 정답은 방금전 ans였던것으로
			// 비싼 a를 더 살 필요가 없음
			if (tmp < 0) {
				break;
			}
			// d로 나머지 곱해서 더한거랑, i개에 b가격으로 곱한거 계산
			ans = Math.min(ans, i * b + tmp * d);

		}
		System.out.println(ans);
	}
}
