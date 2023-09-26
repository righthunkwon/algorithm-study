package baek;

import java.io.*;
import java.util.*;

public class Pro_1342_행운의문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();// word의 length 만큼의 숫자 조합 ㄱㄱ
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length; i++) {
			int su = map.getOrDefault(word[i], 0);
			map.put(word[i], su+1);
		}
		int div = 1;
		for (Character key : map.keySet()) {
			for (int i = 1; i <= map.get(key); i++) {
				div *= i;
			}
		}
		pick = new char[word.length];
		visited = new boolean[word.length];
		count = 0;
		pick(0);
		System.out.println(count/div);

	}

	static char[] word;
	static char[] pick;
	static boolean[] visited;
	static int count;

	public static void pick(int pidx) {//순열을 조합하는 메소드 
		if (pidx == word.length) {//단어 길이만큼 골랐다면 return
			if (!same()) //조건에 맞는지 확인 조건맞으면
				count++;//수증가
			return;
		}
		for (int i = 0; i < word.length; i++) {//모든 문자열을 돌기 위해 for문 사용,방문체크해야 이미 들어간 문자열 안들어가니까 visited 사용
			if (visited[i])
				continue;
			pick[pidx] = word[i];
			visited[i] = true;
			pick(pidx + 1);
			visited[i] = false;
		}

	}

	public static boolean same() { //앞뒤글자 같은지 체크하는 메소드
		for (int i = 1; i < pick.length - 1; i++) { //조합된 배열pick 모든 i 체크 
			if (pick[i] == pick[i - 1] || pick[i] == pick[i + 1])
				return true;
		}
		return false;
	}
}
