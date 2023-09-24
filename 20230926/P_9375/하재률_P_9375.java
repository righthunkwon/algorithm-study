package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();// 해시맵에 의상 = 의상 종류의 수로 저장
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 몇 종류인지만 필요
				String cloth = st.nextToken();
				map.put(cloth, map.getOrDefault(cloth, 0) + 1); // 이미 존재하는 의상 종류라면 그 값, 없다면 0 반환
			}// 입력 완료
			
			int cnt = 1;
			/*
			 Map.Entry
			 Map 내부에 저장되는 key-value 쌍을 다루는 Map 내부의 Interface
			 entrySet() : key-value 쌍을 결합된 형태로 Set에 저장하여 반환해준다
			 	keySet()을 이용하여 모든 key를 불러온 뒤 vlaue를 하나하나 찾는 방법은 비효율적
			 	key-value 쌍이 묶인 데이터를 가져오기 때문에 좋은듯?
			 Iterator 를 사용하는 방법도 있다..나중에 알아보자
			*/
			
			// 어떤 종류의 의상을 안 입는 경우도 있으니
			// (n+1) C 1 * (n+1) C 1 * ...
			// 의상의 종류 + 1을 모두 곱하고
			// 아무것도 입지 않는 경우(공집합)을 빼주기
			for(Map.Entry<String, Integer> m : map.entrySet()) {
				cnt = cnt * (m.getValue() + 1);
			}
			
			System.out.println(cnt - 1);
		}
	}
}
