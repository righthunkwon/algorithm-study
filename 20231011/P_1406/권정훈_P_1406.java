package stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// 에디터

// 연결리스트로 구현
// Iterator 인터페이스를 상속받은 ListIterator 인터페이스를 활욯하여 시간복잡도를 낮춤

// Iterator 인터페이스의 메소드
// hasNext() 	: iteration이 다음 요소를 가지고 있으면 true 반환, 없으면 false 반환(boolean)
// next()		: iteration의 다음 요소 반환(E)
// remove()		: 컬렉션에서 객체를 제거(iterator로 반환되는 마지막 요소를 제거)(void)

// ListIterator 인터페이스의 메소드
// hasNext() 	: iteration이 다음 요소를 가지고 있으면 true 반환, 없으면 false 반환(boolean)
// hasPrevious(): iteration가 이전 요소를 가지고 있으면 true 반환, 없으면 false 반환(boolean)
// next()		: iteration의 다음 요소 반환(E) 후 커서를 순방향으로 이동
// previous()	: iteration의 이전 요소 반환(E) 후 커서를 역방향으로 이동
// remove()		: next()나 previous() 메소드에 의 해 반환된 마지막 요소를 제거

// 소문자만 기록
// 커서는 앞, 뒤, 중간 모두 가능
// 명령어는 L(왼쪽으로 한 칸), D(오른쪽으로 한 칸), B(커서 왼쪽 문자 삭제), P 문자 (커서 왼쪽에 문자 추가)
public class P_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine(); // 초기 문자열
		int m = Integer.parseInt(br.readLine()); // 명령어의 개수
		
		// 연결 리스트 생성 및 초기 문자 입력
		List<Character> list = new LinkedList<>(); 
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		// iterator 메소드 호출
		ListIterator<Character> iter = list.listIterator();
		
		// 커서를 마지막으로 옮김
		while (iter.hasNext()) {
			iter.next();
		}

		// 명령 실행
		for (int i = 0; i < m; i++) {
			String command = br.readLine();
			char ch = command.charAt(0);
			switch (ch) {
			case 'L': // 커서 왼쪽 이동
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D': // 커서 오른쪽 이동
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B': // 왼쪽 문자 삭제
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove(); // remove는 next나 previous를 통해 반환된 마지막 요소를 리스트에서 제거
				}
				break;
			case 'P': // 왼쪽 문자 추가
				iter.add(command.charAt(2)); // P(0) 공백(1) 추가할문자(2)
				break;
			default:
				break;
			}
		}
		
		// 정답 출력
		for (Character chr : list) {
			sb.append(chr);
		}
		System.out.println(sb);
	}
}
