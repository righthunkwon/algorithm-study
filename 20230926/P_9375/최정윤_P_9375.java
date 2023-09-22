package baek;

import java.io.*;
import java.util.*;

public class Pro_9375_패션왕신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();//종류가 키값, value값은 그 종류에 해당하는 의상 수
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();//사실상 필요없음
				String kind = st.nextToken(); 
				int su = map.getOrDefault(kind, 0);//종류를 키값으로 하는 value가 이미 있다면 그 값을 반환 , 없다면 0을 반환
				map.put(kind, su + 1);//의상수 +1하여서 다시 넣어준다.
			}
			Set<String> set = map.keySet();// 모든 의상 종류(key 값)만 뽑아서 set에 넣어줌
			
			
			// 그 종류의 의상 아무것도 안찰 수 있으니까 value+1을 모두 곱한다.
			// 마지막에 모든 것이 0일 때(아무것도 안입었을때)일 경우 1개 빼줘야함
			// 일단 0일 때까지 포함하여 곱하고 모두 0일경우 빼기
			
			int count = 1;

			for (String key : set) {
					count = count * (map.get(key) + 1);//그 종류의 의상 안입었을 경우도 포함해주려고 +1
			}

			System.out.println(count - 1);
		}
	}
}
