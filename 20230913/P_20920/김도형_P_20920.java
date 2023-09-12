import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 입력받을 단어 수 N
		int M = Integer.parseInt(st.nextToken()); // 최소 단어 길이(이거보다 작으면 단어장에서 out)

		// 해시 맵을 통해 입력받은 문자는 key 값으로 받고(중복X),
		// 빈도수는 value로 받아 같은 key 입력시 하나씩 늘려줌
		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine(); // 단어 입력받고

			if (word.length() < M)
				continue; // 길이 M보다 작으면 쳐내

			Integer count = wordMap.getOrDefault(word, 0);
			// getOrDefault 메소드
			// HashMap내에 찾는 key(word)가 존재하면 key값의 value를 반환,
			// 존재 안하면 0(default) 반환

			wordMap.put(word, count + 1);
			// 단어와 빈도수를 HashMap에 넣어줌(key 중복되면 value 덮어써짐!)

		} // for i

		//List<String> words = wordMap.keySet().stream().collect(Collectors.toList());
        // Java의 Stream API를 사용하여 Map의 Key 값을 List로 변환하는 코드
        
        
        List<String> words = new ArrayList<>(wordMap.keySet());
		//이게 더 쉽다...
		

		
		
		words.sort((o1, o2) -> {   //람다 표현식으로 단어 리스트 정렬하기
			int c1 = wordMap.get(o1);
			int c2 = wordMap.get(o2);   //각 단어의 빈도수 가져오기
			

			if (c1 == c2) {  //빈도수 동일하면...
				if (o1.length() == o2.length()) { //단어 길이 같다면..
					
					return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
					
				}
				return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
			}
			return c2 - c1; // 자주 나오는 단어일수록 앞에
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
			sb.append(words.get(i)).append("\n");
		}
		System.out.println(sb);

	}// main

}// class
