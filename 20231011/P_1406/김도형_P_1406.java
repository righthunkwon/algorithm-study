package AlgoStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_Q1406_에디터 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine(); // 초기 문자열 입력
		int M = Integer.parseInt(br.readLine()); // 명령어 수 입력
		int N = str.length(); // 초기 문자열의 길이 N

		// 커서를 기준으로 왼쪽과 오른쪽 스택을 정의해준다
		Stack<Character> ls = new Stack<Character>();
		Stack<Character> rs = new Stack<Character>();

		// 첫 커서는 처음 문자열의 맨 뒤에 있으니까 왼쪽스택에 다 넣어줌
		for (int i = 0; i < N; i++) {
			ls.push(str.charAt(i)); // 문자하나씩 쪼개서 스택에 넣음
		}

		for (int i = 0; i < M; i++) {

			String cmd = br.readLine();
			char c = cmd.charAt(0);

			switch (c) {
			case 'L':
				// 커서 왼쪽 이동 = 왼쪽스택 맨 뒤글자를 꺼내 오른쪽 스택에 넣음
				if (!ls.isEmpty())
					rs.push(ls.pop());
				break;
				
			case 'D':
				// 커서 오른쪽 이동 = 오른쪽스택 맨 앞글자를 꺼내 왼쪽 스택에 넣음
				if (!rs.isEmpty())
					ls.push(rs.pop());
				break;
				
			case 'B':
				// 지우기 : 왼쪽 스택 맨 뒤글자 지우면됨
				if(!ls.isEmpty()) {
					ls.pop();
				}
				break;
				
			case 'P':
				// 문자 추가 : 왼쪽 스택 맨 뒤에 추가하면됨    
				char a = cmd.charAt(2);
				ls.push(a);
				break;
				
			default:
				break;

			}// switch

		} //명령어 수행 for문
		
		//왼쪽 스택에 쌓여있는걸 오른쪽 스택에 몰빵
		while(!ls.isEmpty())
			rs.push(ls.pop());
		
		//오른쪽스택 위에서부터 꺼내면 순서대로 출력됨
		while(!rs.isEmpty())
			bw.write(rs.pop());
		
		bw.flush();
		bw.close();

	}// main

	
	
	// 아래 풀이로 시도했으나 시간초과 ...ㅠ

//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//
//		String str = sc.next(); //처음 문자 입력
//
//		int N = str.length(); //처음 문자 길이
//
//		List<Character> list = new LinkedList<>(); //문자 넣을 리스트 생성
//
//		for (int i = 0; i < N; i++) {
//			list.add(str.charAt(i)); // list에 처음 문자 하나씩 넣기
//		}
//
//		int M = sc.nextInt(); //명령어 수 입력
//		int idx = N; //처음 인덱스는 맨 끝 문자 뒤
//		
//		
//		for (int tc = 0; tc < M; tc++) { //명령어만큼 반복
//
//			String s = sc.next(); //명령어 인식
//			char cmd = s.charAt(0);
//			
//
//			switch (cmd) {
//
//			case 'L':
//				if (idx > 0) {
//					idx--;
//				}
//				
//				break;
//
//			case 'D':
//				if (idx < N) {
//					idx++;
//				}
//				break;
//
//			case 'B':
//				if (idx > 0) {
//					list.remove(idx - 1);
//					idx--;
//					N--;
//				}
//				
//				break;
//
//			case 'P':
//				String a = sc.next();
//				char aa = a.charAt(0);
//				list.add(idx, aa);
//				idx++;
//				N++;
//				
//				break;
//
//			}// switch
//
//		} // tc
//
//		int x = list.size();
//
//		for (int i = 0; i < x; i++) {
//
//			System.out.print(list.get(i));
//
//		}
//
//	}//main

}// class
