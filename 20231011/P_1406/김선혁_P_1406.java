import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	static Stack<Character> arr ;
	static Stack<Character> arr2 ;
	static int N;
	static int pos;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new Stack<>();
		arr2 = new Stack<>();
		// 2개의 스택을 준비해서
		// lifo방식이므로 커서에 따라
		// 커서를 중심으로 
		// 앞쪽은 arr
		// 뒤쪽은 arr2 존재하고 그 사이에서 논다고 보면됨
		String tmp = br.readLine();

		for(int i = 0; i < tmp.length(); i++){
			arr.push(tmp.charAt(i));
		}
		// 시작은 arr에서 시작한다.
		// N개의 명령입력
		int N  = Integer.parseInt(br.readLine());

		pos = tmp.length();
		// 위치는 마지막에서부터 시작
		for(int i =0;i<N;i++) {
			str = br.readLine();
			solve(str.charAt(0));		
			// N번만큼의 명령 수행
		}
		
		// 출력을 하면 Lifo방식이므로
		// arr2로 다 옮긴다음
		// arr2에서 꺼내는 순서대로 출력
		while(!arr.empty()) {
			arr2.push(arr.pop());
			// arr에서 다 arr2로 이동
		}
		StringBuilder sb = new StringBuilder();
		
		while(!arr2.empty()) {
			sb.append(arr2.pop());
		}
		System.out.print(sb);

	}

	public static void solve(char a) {
		// 좌측이동
		if(a == 'L') {
			if(arr.size()!=0) {
				arr2.add(arr.pop());
			}
			// 현재 커서를 좌측으로 1칸이동
			// 만약 맨앞이었을 경우			
			// 그대로 나두고 아니면
			// arr에서 1개 arr2로 이동
		}
		// 우측이동
		else if(a== 'D') {
			if(arr2.size()!=0) {
			arr.add(arr2.pop());
			}
			// 우측으로 커서 이동
			// 만약 범위 그대로나두고
			// 아니면 arr2에서 arr로 하나이동
		}
		else if(a== 'B') {
			// 일단 arr에 문자 있는지 확인
//			System.out.println(pos+" "+arr.peek());
			if(arr.size()!=0) {				
				// arr에서 pop을 통해 삭제
				// 커서는 -1해줘야함
				arr.pop();
				pos--;
			}
		}
		else {
			char input = str.charAt(2);
			// 기호를 입력받아서
			// 현재 커서자리에 추가하는 것이므로
			// arr 마지막 자리에 추가해주면 된다.
			arr.add(input);
		}


	}

}
