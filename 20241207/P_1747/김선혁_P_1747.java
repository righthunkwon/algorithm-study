package 백준;

import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 우선 N이상이고 소수이면서 팰린드롬이려면
		// N부터시작해서 소수아닌 수부터 찾고
		// 팰린드롬인 수를 찾으면된다.
		ArrayList<Integer> ar = new ArrayList<Integer>();
		boolean[] flag = new boolean[10000001];
		// 소수가 아닌 수들은 모두 리스트에 추가한다.
		for(int i= 2;i< flag.length;i++) {
			if(i >= N && !flag[i]) {
				ar.add(i);
			}		
			// 이제 i의 배수들을 true처리함
			for(int j= i;j< flag.length;j+=i) {			
				flag[j] = true;
			}
		}
		// 이과정을 거쳤을 때 값이 1인 애들은 모두 소수임
		for(int i = 0;i< ar.size();i++) {
			// 해당 수가 팰린드롭수인지 확인
			// i를 그대로 뒤집었을 때 두수가 같은지 확인하면된다.
			String tmp = Integer.toString(ar.get(i));
			String reverse = new StringBuilder(tmp).reverse().toString();
			if(reverse.equals(tmp)) {
				System.out.println(tmp);
				break;
			}
			
		}
		
		
	}

}
