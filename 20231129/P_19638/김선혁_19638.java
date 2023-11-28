import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int T;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i =0;i<N;i++) {
			pq.offer(sc.nextInt());
		}
		// 일단 우선순위 큐에다가 
		// 다 넣는다.
		// reverseOrder하면은 반대로 순서가 바뀜!!
		
		int tallest=0;
		int tmp = T;
		while(true) {
			tallest = pq.poll();
			// 현재 꺼낸 키 길이가 만약
			// 센티보다 작다면 전체다 작은거라
			// break해버리고
			if(tallest < M) {
				pq.offer(tallest);
				break;
			}
			// 나머지 경우에는 2로 나눴을 때 0이면
			// 더 줄지않는 값 1넣고 break 
			// 아니면 2로 나눈값 큐에다 넣고 다시 진행
			else {
				if(tallest/2 == 0) {
					pq.offer(1);
					break;
				}
				else {
					pq.offer(tallest/2);
				}
			}
			// 계속하다가 망치횟수 0이되면
			// break
			tmp--;
			if(tmp<=0) {
				break;
			}
		}
		
		if(pq.peek() < M) {
			// 현재 큐에 넣어져있는 수가
			// 센티보다 작으면 yes하고 남은횟수
			System.out.println("YES");
			System.out.println(T-tmp);
		}
		// 아니면 no하고 키를출력
		else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}

	

	


}
