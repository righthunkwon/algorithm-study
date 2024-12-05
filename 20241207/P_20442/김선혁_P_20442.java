package 백준;

import java.util.*;

public class Main {
	static String N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 부분 수열 중 가장 긴 타겟 문자열 길이를 출력		
		// R로만 이루어진 문자열 혹은 R로만 이루어진 문자열 양 옆에 K가 있어야 타겟 문자열
		// 문자열 최대길이로 인해 투포인터 사용
		
		// 1. R의 왼쪽과 오른쪽에 존재하는 K의 개수
		// 부분 수열 중 가장 긴 타겟 문자열이라고 했기 때문에 K중간에 R이 있어도 무시하고 K의 개수를 저장
		// 2. 투포인터를 통해 두개 포인터의 범위내에서 R의 개수를 찾고 
		// start의 왼쪽 k개수와 end의 오른쪽 k개수를 비교해 
		// 공통으로 가질수 있는 개수를 R개수와 합해주면 타겟 문자열의 길이
		// 단 R사이에는 K가 들어가면 안됨!!!
		N = "K" + sc.next() +"K";
		// R이 양 옆에서 먼저 시작하는 경우를 제외시키고자 양 옆에 K를 하나씩 붙여서 시작
		int lk = -1; // 왼쪽에서 누적된 K의 개수
		int rk = -1; // 오른쪽에서 누적된 K의 개수
		int rsum = 0; // 전체에서 R의 총 개수
		char target = 'K';
		int cnt = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		// 우선 K를 만날때마다 개수를 count 해주고
		// R을 만나게되면 해당 개수만큼 리스트에 더해주고 다시 초기화 진행
		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) == target)
				cnt++;
			if (N.charAt(i) != target) {
				ar.add(cnt);
				if (target == 'R') {
					rsum += cnt;
				}
				target = target == 'K' ? 'R' : 'K';
				cnt = 1;
			}
		}
		ar.add(cnt);
		// 양쪽에서 투포인터 시작
		int left = 0;
		int right = ar.size() - 1;
		lk += ar.get(left);
		rk += ar.get(right);
		int max = 0;
		while (rsum > 0) {
			int sum = Math.min(lk, rk)*2+rsum;
			max = Math.max(sum, max);
			int tmp = lk;
			if(tmp<=rk) {
				rsum -= ar.get(++left);
				lk += ar.get(++left);
			}
			if(tmp>=rk) {
				rsum -= ar.get(--right);
				rk += ar.get(--right);
			}
		}
		System.out.println(max);
		
		
		
	}
	
	
	
}
