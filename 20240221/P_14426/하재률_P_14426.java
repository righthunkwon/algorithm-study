package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14426_접두사찾기 {
	
	static class Node {
		Map<Character, Node> n = new HashMap<>(); // 자식노드
		boolean end; // 단어의 마지막인지 체크
	}
	
	static class Trie {
		// root Node 생성
		Node root = new Node();
		
		// Trie에 문자열 저장
		public void insert(String str) {
			// root Node로부터 시작
			Node curNode = this.root;
			
			// 문자열 하나씩 돌면서 자식노드 중에 없으면 새로 생성
			for(char c : str.toCharArray()) {
				curNode = curNode.n.computeIfAbsent(c, key -> new Node());
			}
			// 마지막 단어의 노드에는 마지막 문자임을 명시
			curNode.end = true;
		}
		
		// Trie에 문자열 검색
		public boolean search(String str) {
			// root Node로부터 시작
			Node curNode = this.root;
			
			// 문자열 하나씩 돌면서 노드가 존재하면 가져오고 아니면 null
			for(char c : str.toCharArray()) {
				curNode = curNode.n.getOrDefault(c, null);
				// null이면 Trie에 해당 문자열 없음
				if(curNode == null) return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			trie.insert(input);
		}
		
		int res = 0;
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			if(trie.search(input)) {
				res++;
			}
		}
		
		System.out.println(res);
		
	}
}

//61% 시간초과..
//int res = 0;
//
//for(int i = 0; i < M; i++) {
//	String str = br.readLine();
//	for(int j = 0; j < N; j++) {
//		int cnt = 0;
//		for(int k = 0; k < str.length(); k++) {
//			if(str.charAt(k) == strArr[j].charAt(k)) cnt++;
//			else break;
//		}
//		if(cnt == str.length()) {
//			res++;
//			break;
//		}
//		
//	}
//}
//System.out.println(res);
