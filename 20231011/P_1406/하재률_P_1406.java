package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class BOJ_1406_에디터 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// ListIterator 를 활용하자
		List<Character> str = new LinkedList<>();
		ListIterator<Character> it = str.listIterator();
		String input = br.readLine();
		for(int i = 0; i < input.length(); i++) {
			it.add(input.charAt(i));
		}// 입력 완
		int M = Integer.parseInt(br.readLine()); // 명령어 개수
		
		for(int i = 0; i < M; i++) {
			char[] tmp = br.readLine().toCharArray();
			switch (tmp[0]) {
			case 'L': if(it.hasPrevious()) it.previous(); // 커서 왼쪽으로 옮기기
				break;
			case 'D': if(it.hasNext()) it.next(); // 커서 오른쪽으로 옮기기
				break;
			case 'B': if(it.hasPrevious()) { // 커서 왼쪽 삭제
				it.previous();
				it.remove();
			}
				break;
			case 'P': // 커서 왼쪽에 문자 삽입
				it.add(tmp[2]);
				break;
			}
		}
		
		for(char c : str) sb.append(c);
		System.out.println(sb);
		
	}
}