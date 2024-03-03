import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static HashMap<Integer, Integer> pick;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		// 위문제는 dfs돌리면 무조건 시간초과 계속 뜸
		// 입력받으면서 hash에 넣고 해야함 
		pick = new HashMap<>();
		ans = 1;

		// 입력받으면서 이미 있는것은 value에 +1해주고
		// 없으면 추가
		for(int i = 0;i<N;i++) {
			arr[i] = sc.nextInt();
			if(!pick.containsKey(arr[i])) {
				pick.put(arr[i], 1);
			}
			// 기존의 개수에 +1해줌
			else {
				pick.put(arr[i], pick.get(arr[i])+1);
			}
		}
		// 1 1 2 3 -> 11( 3 * 2 * 2 -1)
		// 1 1 1 3 -> 7 (4 * 2 -1)
		// 1 1 2 2 3 4 -> 35 ( 64 - 28) ( 3 * 3 * 2 * 2 -1)
		
		
		// 각 value의 +1한 것을 계속 곱해나감
		for(int value : pick.keySet()) {
			ans *= pick.get(value)+1;
			ans %= (long) (Math.pow(10, 9)+7);
		}
		
		System.out.println((long)((ans-1)%(Math.pow(10, 9)+7)));
		

	}



}
