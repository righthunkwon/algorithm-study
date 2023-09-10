package level_13_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 영단어 암기는 괴로워
// 자바 개념을 학습하게 해준 고마운 문제

// Map collection
// key와 value로 구성된 Entry 객체
// Map<K, V> map = new HashMap<K, V>();
// key는 중복 저장 불가, 값은 중복 저장 가능
// 단어는 key로 저장하고 빈도는 value로 저장 후 갱신

// Comparable
// 객체를 비교하기 위해 사용(나와 얘를 비교)
// 인터페이스이므로 선언된 메소드를 구현해야 함
// Comparable에서 선언된 메소느는 compareTo(T o)
// lang 패키지에 있으므로 import 불필요

// Comparator
// 객체를 비교하기 위해 사용(얘와 쟤를 비교)
// 인터페이스이므로 선언된 메소드를 구현해야 함
// Comparator에서 선언된 메소드는 compare(T o1, o2)
// util 패키지에 있으므로 import 필요
public class P_20920 {
	public static void main(String[] args) throws IOException {

		// 단어장
		// 1. 빈도
		// 2. 길이
		// 3. 사전순
		
		// 입력 10만개라 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 단어의 개수
		int m = Integer.parseInt(st.nextToken()); // 단어의 길이
		
		// Map<단어, 단어의 개수>
		Map<String, Integer> wordbook = new HashMap<>(); 

		for (int i = 0; i < n; i++) {
			String word = br.readLine();

			// 처음 길이가 m 이상인 단어를 저장할 경우 key를 저장하고 value는 1
			if (word.length() >= m && !(wordbook.containsKey(word))) {
				wordbook.put(word, 1);
			}

			// 이미 단어가 존재할 경우 value를 1 증가시켜 key를 갱신(중복 단어는 자동으로 제거)
			else if (wordbook.containsKey(word)) {
				int cnt = wordbook.get(word);
				wordbook.put(word, ++cnt);
			}
		}

		// wordbook에서 단어들(keySet)을 가져와 ArrayList에 저장
		List<String> wordlist = new ArrayList<>(wordbook.keySet());

		// 익명 객체를 활용하여 wordlist를 정렬
		Collections.sort(wordlist, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				
				// (1) 빈도순으로 정렬
		        int count1 = wordbook.get(o1); // 빈도
		        int count2 = wordbook.get(o2); // 빈도

		        // 빈도가 다르면 빈도에 맞게 단어를 정렬
		        // count2 > count1 일 경우 count2 count1 순으로 정렬
		        // count2 < count1 일 경우 count1 count2 순으로 정렬
		        if (count1 != count2) {
		            return count2 - count1;
		        }
		        
				// (2) 빈도가 같으면 길이순으로 정렬
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				
				// (3) 빈도와 길이가 같으면 사전순으로 정렬
				// Collections.sort()는 문자열 타입의 원소를 가진 List를 정렬할 경우 사전편찬 순으로 정렬하도록 구현됨
				return o1.compareTo(o2);
			}
		});

		// 정렬된 단어들을 출력
		StringBuilder sb = new StringBuilder();
		for (String word : wordlist) {
			sb.append(word + "\n");
		}
		System.out.println(sb);
	}

}
