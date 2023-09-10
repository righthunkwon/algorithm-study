package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19699_소난다 {
	public static int N; // 소들의 수
	public static int M; // 선별할 소의 수
	public static int[] arr; // 소들 무게 입력받을 배열
	public static boolean[] chk; // combination을 위한 boolean배열
	public static HashSet<Integer> tmp = new HashSet<>(); // 중복 제거를 위해 HashSet에 먼저 저장하자
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		chk = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료
		
		comb(0, M, 0); // 재귀를 통해 N마리 소 중 M마리를 선택하자
		
		// HashSet은 순서가 없기 때문에 정렬을 위해
		// HashSet의 요소를 ArrayList에 복사
		List<Integer> res = new ArrayList<>(tmp);
		
		Collections.sort(res); // 정렬
		
		// 소수가 없으면 "-1"출력 있다면 순서대로 출력
		if(res.size() == 0) System.out.println(-1);
		else {
			for(int a : res) System.out.print(a + " ");
		}
	}
	
	// N마리의 소 중 M마리를 선택하는 combination 재귀
	// 합을 HashSet에 넣어야 하기 때문에 들고 다니자
	public static void comb(int idx, int M, int sum) {
		// 기저 파트
		if(M == 0) {
			if(isPrime(sum)) tmp.add(sum);
			return;
		}
		if(idx == N) return;
		
		// 재귀 파트
		chk[idx] = true;
		comb(idx+1, M - 1, sum+arr[idx]);
		chk[idx] = false;
		comb(idx+1, M, sum);
	}
	
	// 받아온 값이 소수인지 확인하는 에라토스테네스의 체
	public static boolean isPrime(int x) {
		if(x <= 1) return false; // 1 이하의 수는 소수가 아니다
		// 2부터 받아온 루트x까지만 확인하면 된다
		// (a, b가 자연수) x = a x b 인데, x의 약수인 a, b중 하나는 무조건 x의 제곱근보다 작거나 같기 때문에
		// x의 제곱근 만큼만 확인해보면 된다!
		// 12를 예로 들어보면 1,12 2,6, 3,4 /// 4,3 6,2 12,1 -> 12의 제곱근 3.xx(3) 까지만 확인하면
		// 그 뒤엔 순서만 바뀐 모습을 볼 수 있다
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) return false;
		}
		return true;
	}
}
