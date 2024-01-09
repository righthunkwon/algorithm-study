package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ⌊x⌋는 x보다 크거나 같은 가장 작은 정수를 나타내는 내림 기호 -> x의 내림
 * ⌈x⌉는 x보다 크거나 같은 가장 작은 정수를 나타내는 올림 기호 -> x의 올림
 */

public class BOJ_21870_시철이가사랑한GCD {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(sol(arr));
		
	}
	
	private static int sol(int[] arr) {
		// 하나면 그거 출력
		if (arr.length == 1) return arr[0];
		// 두 개면 합 출력
		else if (arr.length == 2) return arr[0] + arr[1];
		
		// 왼쪽은 내림, 오른쪽은 올림 
		// -> 홀수면 0 ~ mid // mid ~ 끝 까지로 나눠져서 걍 2로나눈 mid로 구분하면된다
		int mid = arr.length / 2;
		
		int[] l = Arrays.copyOfRange(arr, 0, mid);
		int[] r = Arrays.copyOfRange(arr, mid, arr.length);
		
		// 재귀로 왼쪽 선택한것들 gcd 합 or 오른쪽 선택한것들 gcd 합 중 큰 거 return
		return Math.max(gcd1(l) + sol(r), sol(l) + gcd1(r));
	}
	
	// 최대공약수(GCD)를 구하는 유클리드 호제법을 이용하여
	// 배열의 모든 수에 대한 GCD를 구하자
	static int gcd1(int[] arr) {
		int res = arr[0];
		for(int i = 1; i < arr.length; i++) res = gcd2(res, arr[i]);
		return res;
	}
	
	static int gcd2(int a, int b) {
		while(b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
	
	/*
	 	유클리드 호제법
	 	
	 	A와 B의 최대공약수 GCD(A, B)를 구해보자!
	 	A = 0 이면 GCD(0, B), GCD(A, B) = B 이다
	 	B = 0 이면 GCD(A, 0), GCD(A, B) = A 이다
	 	A는 A = B * Q + R 일때
	 	GCD(A, B) = GCD(B, R) 이다
	 	
	 	왜??? 
	 	https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
	 	증명은 여기 참고 ㅋ
	 	
	 	30과 12의 최대공약수 GCD(30, 12)을 찾아보자!
	 	A = 30, B = 12
	 	30 / 12 = 2와 나머지 6 -> 30 / 12 = 12 * 2 + 6
	 	GCD(30, 12) = GCD(12, 6) 이므로 GCD(12, 6)을 찾자
	 	
	 	12 / 6 = 2와 나머지 0 -> 12 / 6 = 2 * 6
	 	GCD(12, 6) = GCD(6, 0) = 6
	 	
	 	GCD(30, 12) = GCD(12, 6) = GCD(6, 0) = 6 이다.
	*/
	
}

