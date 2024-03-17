import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static long[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 입력되면서 
		// 현재 스택에 저장된 peek의 높이보다
		// 만약 입력된게 크다면
		
		// 입력값보다 적어질떄까지 pop 하고
		// 입력값이 적다면 추가하고 현재 스택에있는것만큼 sum에 더함
		Stack<Integer> s = new Stack<>();
		long sum = 0;
		for(int i = 0 ;i<N;i++) {
			int tmp = sc.nextInt();
			while(true) {
				// 사이즈가 0이거나 tmp값이 적다면 break
				if(s.size()==0 || tmp < s.peek()) {
					break;
				}
				s.pop();
			}
			sum += s.size();
			s.push(tmp);
		}
		System.out.println(sum);
	
	}
}
