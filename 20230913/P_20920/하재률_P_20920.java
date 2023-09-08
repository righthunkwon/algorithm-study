package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20920_영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 단어의 개수 1 <= N <= 100,000
		int M = Integer.parseInt(st.nextToken()); // 외울 단어 기준 1 <= M <= 10
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine(); // 한 줄씩 입력 받아서
			if(input.length() >= M) { // 길이 제한으로 거르기
				if(hm.containsKey(input)) hm.replace(input, hm.get(input)+1); // 이미 나온거면 value만 1 증가
				else hm.put(input, 1); // 처음 나오는거면 삽입해주기
			}
		} // 입력 완료
		
//		System.out.println(hm);
		
		// Collections.sort를 써먹기 위해 HashMap을 List로 옮겨준다
		List<String> keyList = new ArrayList<String>(hm.keySet());
		
		Collections.sort(keyList,(o1,o2) -> {
			if(hm.get(o2)==hm.get(o1)) { // 만약  빈도 수(value)가 같고
				if(o1.length()==o2.length()) { // 길이가 같으면?
					return o1.compareTo(o2); // 사전순으로!! (우선순위 3)
				}
				return o2.length()-o1.length(); // 길이순으로 (우선순위 2)
			}
			return hm.get(o2)-hm.get(o1); // 빈도순으로 (우선순위 1)
			
		});
		// 이렇게 정렬을 3번 해주니까 당연히 시간초과가 뜬다
//		keyList.sort(String::compareTo); // 사전순
////		System.out.println(keyList);
//		Collections.sort(keyList, (v2, v1) -> v1.length()-v2.length()); // 길이순
////		System.out.println(keyList);
//		Collections.sort(keyList, (v2,v1) -> (hm.get(v1).compareTo(hm.get(v2)))); // 빈도순
////		System.out.println(keyList);
		
		// StringBuilder를 쓰지 않으면 시간초과가 뜬다
		for(int i = 0; i < keyList.size(); i++) {
			sb.append(keyList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
