package silver;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_Q12789_도키도키_간식드리미 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();    //순서에 맞지 않는 사람들 넣어둘 스택 생성

		int N = sc.nextInt(); // 1<= N <= 1000

		String ans = "Nice";  //정답은 일단 Nice로 초기화, 안되는 경우 발생시 ans를 Sad로 바꾸고 끝냄
		
		int [] arr = new int[N];  //줄서있는 사람들 번호표를 순서대로 입력받을 배열 생성
		
		
		for(int i = 0;i<N;i++) {
			arr[i]=sc.nextInt();    //번호표 입력받기
		}
		
		int idx = 0;   //배열의 인덱스
		int order = 1;  //올바른 순서(번호표와 동일한 사람 패쓰)
		
		while( idx < N) {  //인덱스가 N이 되기 전까지 반복(마지막 사람까지 처리 완료하면 인덱스가 N이 될 것)
			
			if (!stack.empty() && stack.peek() == order) {   //스택이 비어있고 스택 맨 윗부분이 순서에 맞는 번호표를 가진 사람이면 pop하고 다음 순서 사람 찾기
				stack.pop();
				order++;
				continue;
			}
			
			if(order == arr[idx]) {   //순서에 맞는 번호표를 가진 사람 차례이면 패쓰하고 idx, order 1씩 증가시키고 다시 탐색
				idx++;
				order++;
				continue;
			}else {
				//순서에 맞는 번호표가 아닌 경우 중, 스택이 비어있거나, 스택 맨 윗 사람보다 번호표 숫자가 작아야 스택에 넣을 수 있음
				if (stack.isEmpty() || stack.peek() > arr[idx]) {  
					stack.add(arr[idx++]);
					continue;
				}
				else if (stack.peek() < arr[idx]) {  //스택 맨 윗사람보다 번호표 숫자가 클 경우 순서 꼬임 ㅅㄱ
					ans = "Sad";
					break;
				}
		
			}
	
		}//while
	

		System.out.println(ans);

	}// main

}// class
