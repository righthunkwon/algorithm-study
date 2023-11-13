/*
 * 
Group of size 5: caret carte cater crate trace .
Group of size 4: abet bate beat beta .
Group of size 4: ate eat eta tea .
Group of size 1: displayed .
Group of size 1: singleton .

테케는 나오지만 gg 겹치는거 때문인듯한데 구현 못해먹겠음 
 * 
 * 
 * 
 * 
 * */



package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class BOJ_Q6566_애너그램_그룹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, StringBuilder> anagram = new HashMap<>();
		HashMap<String, Integer> anagram2 = new HashMap<>();   //key 값 똑같이 받고, value 는 단어 수

		List<String> arr = new ArrayList<>();
		while (true) {
			String str = br.readLine();
			if (str == null || str.isEmpty()) {
				break;
			}
			arr.add(str);
		}

		Collections.sort(arr); // 사전순 정렬

		for (int i = 0; i < arr.size(); i++) {
			char[] tmp = arr.get(i).toCharArray(); // 문자단위로 쪼개서
			Arrays.sort(tmp); // 정렬하고

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < tmp.length; j++) {
				sb.append(tmp[j]);
			}
			String tmpkey = sb.toString(); //// 다시합쳐준걸 key로 hashmap에 넣어줌

			if (!anagram.containsKey(tmpkey)) {
				sb = new StringBuilder();
				sb.append(": " + arr.get(i) + " ");
				anagram.put(tmpkey, sb);
			} else {
				anagram.put(tmpkey, anagram.get(tmpkey).append(arr.get(i) + " "));
			}
		}

		TreeSet<String> sortedKeys = new TreeSet<>(anagram.keySet());

		List<String> lastpang = new ArrayList<>();

		for (String key : sortedKeys) {

			StringBuilder sb = new StringBuilder();
			sb.append("Group of size " + countSpaces(anagram.get(key).toString()) + anagram.get(key).toString().trim());
			lastpang.add(sb.toString());
//			System.out.println();
//			System.out.println(anagram.get(key).toString().trim());
//			System.out.println(countSpaces(anagram.get(key).toString()));
		}

		Collections.sort(lastpang);

		lastpang.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int size1 = countSpaces(o1); // 공백순 정렬
				int size2 = countSpaces(o2);

				if (size1 != size2) {
					return size2 - size1; // 크기에 따라 내림차순 정렬
				} else {
					String substring1 = o1.substring(14);
					String substring2 = o2.substring(14);
					return substring1.compareTo(substring2); // 크기가 같으면 15번째부터 사전순 정렬
				}
			}

			// 문자열에서 공백의 개수를 세는 메서드
			private int countSpaces(String str) {
				int spaceCount = 0;
				for (int i = 0; i < str.length(); i++) {
					if (Character.isWhitespace(str.charAt(i))) {
						spaceCount++;
					}
				}
				return spaceCount;
			}

		});

		int len = lastpang.size();

		if (len >= 5) {

			for (int i = 0; i < 5; i++) {
				System.out.println(lastpang.get(i) + " .");
			}
		}else {
			for (int i = 0; i < len; i++) {
				System.out.println(lastpang.get(i) + " .");
			}
		}
//		for (StringBuilder group : anagram.values()) {
//		    System.out.println(group.toString().trim());
//		}

		// 추가: 프로그램 종료
		return;

	}// main

	// 문자열에서 공백의 개수를 세는 메서드
	private static int countSpaces(String str) {
		int spaceCount = -1;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				spaceCount++;
			}
		}
		return spaceCount;
	}

}// class
