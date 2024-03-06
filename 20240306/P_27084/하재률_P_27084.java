package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 1 2 3 1 일 경우 선택 가능성
 * 첫번째 1을 선택하는 경우 / 두 번째 1을 선택 / 1을 선택 X => 3가지
 * 2를 선택 / 2를 선택X => 2가지
 * 3을 선택 / 3을 선택X => 3가지
 * -> 모두 선택하지않는 경우 1가지를 - => 11가지
 * 총 가지수는 (2^n) = 2*2*2*2 에서 모두 선택하지 않는 경우 1가지 뺀 15가지
 */
public class BOJ_27084_카드뽑기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[Integer.parseInt(st.nextToken())]++;
		
		long res = 1;
		for(int i = 1; i <= n; i++) {
			res *= (arr[i] + 1);
			res %= 1000000007;
		}
		
		System.out.println(res-1);
		
	}
}
