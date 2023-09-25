package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q1342_행운의_문자열 {

	static int N;
	static char[] arr;
	static int cnt; // 갯수 세기
	static boolean[] visit; // 알파벳 방문 여부 확인용 배열
	static char[] alphabet = new char[27];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		arr = S.toCharArray();

		N = arr.length;

//		System.out.println(Arrays.toString(arr));//출력확인

////		swap(1,2);
////		System.out.println(Arrays.toString(arr));//출력확인
//		System.out.println('a'-'0' -49); //알파벳 인덱스 확인용
//		System.out.println(arr[0]-'0'-49); //이러면 알파벳 인덱스 나옴!!
//		System.out.println('z'-'a');

		for (int i = 0; i < N; i++) {
			alphabet[arr[i] - 'a']++; // -'a' 해주니 0부터 나옴 a:0 b:1 c:2 ... z:25
		}

		dfs(0, "", N);

		System.out.println(cnt);

	}// main
		// 인덱스, 문자열 임시저장, 단어 길이

	public static void dfs(int idx, String temp, int len) {

		if (idx == len) { // 이렇다는건 성공적으로 돌았다는 것..
			cnt++;
			return;
		}

		for (int i = 0; i < 26; i++) {
			// 쓸 알파벳 없으면 패스..
			if (alphabet[i] == 0)
				continue;

			// 이전 알파벳이 현재 알파벳과 같은지
			if (temp != "" && temp.charAt(temp.length() - 1) == (char) ('a' + i))
				continue;

			// 두 조건에 안걸렸으면 진행
			alphabet[i]--; // 하나 빼주고
			dfs(idx + 1, temp + (char) ('a' + i), len);
			alphabet[i]++; // 다시 더해줌

		}

	}

//	//밑에 다 쓸모 없음...........
//	
//	
//	//a,b 스왑하는 메서드
//	public static void swap(int a,int b) {
//		char tmp = arr[a];
//		arr[a]=arr[b];
//		arr[b]=tmp;
//	}
//	
//	//행운의 문자인지 체크하는 메서드
//	public static boolean luckeck() {
//		
//		for(int i = 0;i<arr.length-1;i++) {
//			
//			if(arr[i]==arr[i+1]) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public static void permutation(int idx, boolean[]visit) {
//		
//		//기저조건
//		if(idx == N) {
//			cnt++;
//			return;
//		}
//		
//		visit[arr[idx-'0'-49]]=true; //자기자신과 같은 알파벳 바꿀 필요 x
//		
//		for(int i=idx; i<N;i++) {
//			
//		}
//		
//		
//
//	}
//	
	//https://steady-life.tistory.com/157 참고..

}
