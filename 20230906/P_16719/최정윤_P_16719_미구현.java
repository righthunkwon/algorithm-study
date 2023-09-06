package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//시작점과 끝점을 stack에 저장하여 사용하는 방식으로 접근

public class Pro_16719_ZOAC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		arr = input.toCharArray();// 입력값 char 배열로 받기
		print = new int[arr.length];// 출력된 문자자리는 1로 바꿈 끝나는 지점 잡기 위해 사용

		Stack<Integer> stack = new Stack<>();
		int minindex = -1;// 시작 초기값, for문의 시작값을 minindex+1로 하려고 초기값-1로 설정
		int maxindex = arr.length;

		while (check()) {// check는 모든 문자가 출력되었는지 확인하는 메소드, 모든 문자 출력되었으면 종료
			int min = Integer.MAX_VALUE;
			for (int i = minindex + 1; i < maxindex; i++) {
				if (arr[i] < min) {// for문 범위중 가장 작은 알파벳과 그 인덱스 찾기
					min = arr[i];
					minindex = i;
				}
			}
			// 알파벳 가장 낮은 것 구한 뒤 그 자리 1로 바꾸고 stack에 넣어라
			print[minindex] = 1;
			stack.add(minindex);

			while (true) {
				if (minindex + 1 >= maxindex) {
					if (!stack.isEmpty()) {
						maxindex = stack.pop();
					} else {// 마지막 한글자 출력시에는 스택이 비게 되고, 굳이 maxindex다시 설정 안해도 괜찮음
						break;
					}
					if (!stack.isEmpty())
						minindex = stack.peek();
					else {//여기서 스택이 비는 경우는, 처음 가장 작은 알파벳이 첫글자가 아닐 수 있기 때문.
							//스택이 비는 경우는 minindex -1로 설정하여 다시 앞부터 max까지 돌게하기
						minindex = -1;
					}
				} else {
					break;
				}
			}
			print();// 1로 바뀐 것만 출력해주는 메소드
		}

	}

	public static int[] print;
	public static char[] arr;

	public static void print() {
		for (int i = 0; i < print.length; i++) {
			if (print[i] == 1) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}

	public static boolean check() {
		for (int i = 0; i < print.length; i++) {
			if (print[i] == 0) {
				return true;
			}
		}
		return false;
	}
}
