import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			
			// 소세지 개수가 사람수보다 많으면
			// 일단 소세지를 사람수로 나눈 나머지로 바꿈
			// 이제 나머지 소세지에서 계산해보자
			N %= M;
			int ans = M;
			// 두개의 최대공약수를 구해서
			// M에서 그만큼 빼면 그만큼 칼질
			while(true) {
				// 나누는 수가 0보다작아지면 끝
				if(M<=0) {
					break;
				}
				// 최대 공약수 구하는 공식
					int tmp = N;
					N = M;
					M = tmp % M;
			}
			System.out.println(ans-N);
			
	}
}
