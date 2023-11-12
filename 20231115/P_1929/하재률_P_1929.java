package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라스토테네스의 체 알고리즘을 이용하여 N의 제곱근만큼만 판단하면 된다잉
public class BOJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N+1]; // 소수는 false
		arr[0] = arr[1] = true; // 0과 1은 소수가 아님 ㅎ
		
		// 2의 배수부터 N제곱근의 배수까지 모두 소수가 아니므로 true로 만들어뿌자
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(arr[i]) continue; // 이미 쳌 했으면 continue
			for(int j = i*i; j <= N; j += i) arr[j] = true;
		}
		// N ~ M 까지 false만 출력
		for(int i = M; i <= N; i++) if(!arr[i]) System.out.println(i);
	}
}
