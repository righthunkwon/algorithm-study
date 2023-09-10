package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
// 미구현
public class BOJ_12789_도키도키간식드리미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Queue<Integer> wait = new LinkedList<>(); // 대기줄
		Stack<Integer> birdhit = new Stack<>(); // 새치기한놈들 모아놓는 줄
		int cnt = 1; // 순서
		
		for(int i = 0; i < N; i++) {
			wait.offer(Integer.parseInt(st.nextToken()));
		}// 입력 완료
		
		while(!wait.isEmpty()) { // 대기줄이 빌 때까지 돌거야
			if(wait.peek() == cnt) { // 대기줄 처음 놈이 순서가 맞으면
				wait.poll(); // 간식받고
				cnt++; // 다음 순서로
			} else if(!birdhit.isEmpty() && birdhit.peek() == cnt) { // 새치기줄에 다음순번 있으면
				birdhit.pop(); // 간식받고
				cnt++; // 다음 순서
			} else { // 순서 안맞으면
				birdhit.push(wait.poll()); // 새치기줄로 넣어
			}
		}
		// 이까지 다 돌면 제대로 줄 선 사람들 간식 다 받음
		
		while(!birdhit.isEmpty()) { // 새치기한놈들 줄 빌 때까지 돌거야
			if(birdhit.peek() == cnt) { // 순서 맞으면
				birdhit.pop(); // 빠져나가고
				cnt++; // 다음 순서
			} else { // 순서가 안맞으니까 중간고사 망침
				System.out.println("Sad");
				return; // 프로그램 끝내기
			}
		}
		// 이까지 무사히 돌면 승환이 무사히 간식 받을 수 있다
		System.out.println("Nice");
	}
}