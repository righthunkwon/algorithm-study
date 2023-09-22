package AlgoStudy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaekJoon_Q9375_패션왕_신해빈 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int n = sc.nextInt(); // 해빈이가 가진 의상 수 0~30

			Map<String, Integer> map = new HashMap<>();

			int tmp = 1;
			int ans = 0;

			for (int i = 0; i < n; i++) {

				String a = sc.next();
				String b = sc.next();

				if (!map.containsKey(b)) {
					map.put(b, 1); // 처음 들어온 키(옷종류)면 1 넣어주기
				} else {
					map.replace(b, (int) map.get(b), (int) map.get(b) + 1);
					// 원래있는 키(옷종류)면 value에 +1

				}

			} // for

			Collection<Integer> nums = map.values(); 
			//HashMap.valuse 메서드를 쓰면 HashMap에 저장된 value들을 Collection 객체로 리턴
			
			//(종류별 옷의 수+1)을 다 곱해주고 공집합의 경우 1을 빼주면 모든 조합의 수 계산 가능
			
			for(Integer num : nums) {
				tmp *= (num+1);  //
			}

			ans = tmp - 1;

			System.out.println(ans);

		} // tc

	}// main

}// class
