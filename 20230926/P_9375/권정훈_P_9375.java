package level_19_combination;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 패션왕 신해빈
// 의상의 종류에 따른 의상의 개수를 저장해야 하므로
// HashMap<Key, Value> 클래스를 사용하는 게 유리하다.

// 옷의 종류별로 경우의 수를 구한 뒤
// 각 경우의 수를 곱한 것에서 아무것도 입지 않은 경우의 수(1)을 빼면 된다.
// 이때 각 의상은 입지 않을 수도 있으므로 우선 의상 종류별 개수에 + 1 해준 것에서 뽑는 것으로 고려해야 한다.
public class P_9375 {
	private static int n; // 의상의 수
	private static int ans; // 정답
	private static Map<String, Integer> clothes; // 의상의 종류와 의상 종류별 개수를 저장하는 HashMap
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			clothes = new HashMap<String, Integer>();  
			
			for (int i = 0; i < n; i++) {
				String cname = sc.next(); // 의상의 이름, 같은 이름을 가진 의상이 존재하지 않으므로 필요하지 않다.
				String ctype = sc.next(); // 의상의 종류
				
				// 의상 종류가 이미 존재할 경우 개수 1 증가
				if (clothes.containsKey(ctype)) {
					clothes.put(ctype, clothes.get(ctype)+1); // 의상의 종류(key), 의상의 종류에 따른 개수(value)
				} 
				// 의상 종류를 처음 추가할 경우 개수에 1 대입
				else {
					clothes.put(ctype, 1); // 의상의 종류(key), 의상의 종류에 따른 개수(value)
				}
			}
			
			ans = 1;
			for (int value : clothes.values()) {
				ans *= value + 1;
			}
			System.out.println(ans - 1);
		}
	}
}
