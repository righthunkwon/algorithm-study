package _20230913;

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


public class _20920_영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//단어의 개수 n, 최소단어길이 m
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//HashMap을 사용하여 길이가 'm'이상인 단어와 그 갯수를 저장(m 안넘는건 아예 저장X)
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			if(s.length()<m) continue;
			map.put(s, map.getOrDefault(s, 0)+1); //이미 나온 단어인 경우 카운트 증가, 처음 나온 단어는 1카운트
		}
		//map에서 단어들 가져와서 ArrayList에 저장한다
		List<String> words = new ArrayList<>(map.keySet());
		//words리스트를 조건에 맞게 정렬한다
		Collections.sort(words, new Comparator<String>() {
			public int compare(String o1, String o2) {
				//자주 등장하는 단어 순서대로 정렬
				if(Integer.compare(map.get(o1), map.get(o2)) != 0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				//등장 횟수 같으면 길이 긴 단어 먼저 오도록 정렬
				if(o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				return o1.compareTo(o2);
			}
		});
		
		//정렬된 단어들 출력
		StringBuilder sb = new StringBuilder();
		for(String str : words) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
		
		
	}//main

}
