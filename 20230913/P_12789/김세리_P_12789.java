package _20230913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12789_도키도키간식드리미 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //학생수
		//Queue에 현재 있는 대기열을 저장한다
		//입력되었던 순서대로 나와야 하기 때문에 queue를 사용한다
		Queue<Integer> q = new LinkedList<>(); // 대기열

		//Stack에는 새로 만드는 추가 대기열을 저장한다
		//공간이 협소하여 나중에 들어간 사람이 나오는
		//후입선출의 원리가 적용되어야 하기 때문에 stack을 이용한다
		Stack<Integer> s = new Stack<>(); // 추가 대기열

		StringTokenizer st = new StringTokenizer(br.readLine());

		// q에 학생들의 번호를 집어넣는다
		for(int i=0;i<n;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}

		int turn = 1; //간식 먹는 순서, 1부터 시작

		// q가 비워질때까지 반복한다
		while(!q.isEmpty()) {
			// q(기존 대기열)맨 앞의 사람이 간식먹을 순서이면 q에서 꺼내고 다음 순서로 넘어간다
			if(q.peek()==turn) {
				q.poll();
				turn++;
			}
			// s(추가 대기열)에서 맨 앞에 있는 사람이 간식먹을 순서이면 s에서 꺼내고 다음 순서로 넘어간다
			else if(!s.isEmpty() && s.peek()==turn) {
				s.pop();
				turn++;
			}
			// 대기열, 추가 대기열 맨 앞에 있는 사람 둘 다 간식 받을 순서가 아니라면 대기열에 있는 사람이 추가 대기열로 이동한다
			else {
				s.push(q.poll());
			}
		}

		// 이제 q가 다 비워졌다(추가 대기열에만 사람이 있는 상황)
		while(!s.isEmpty()) {
			// s(추가 대기열)에서 맨 앞에 있는 사람이 간식먹을 순서이면 s에서 꺼내고 다음 순서로 넘어간다
			if(s.peek()==turn) {
				s.pop();
				turn++;
			}
			// s맨 앞에 있는 사람이 받을 순서가 아닌데 s에 사람이 남아있는 경우는 승환이가 간식을 받을 수 없다
			else {
				System.out.println("Sad");
				return;
			}
		}


		// Sad가 나오지 않았다면 이제 승환이는 간식을 받을 수 있다
		System.out.println("Nice");


	}//main
}
