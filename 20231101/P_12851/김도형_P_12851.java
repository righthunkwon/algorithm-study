package AlgoStudy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q12851_숨바꼭질2 {

	static int N, K; 
	static int cnt;
	static Queue<Integer> queue = new LinkedList<Integer>(); //bfs용 큐
	static Queue<Integer> queue2 = new LinkedList<Integer>(); //bfs2용 큐
	static int[] visited; //수빈이가 해당 위치까지 가는 데 걸린 시간을 저장해두는 배열(0이면 방문한적 없는 것)
	static int kinds;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치

		visited = new int[100001]; // 방문 확인용 배열(0이면 방문 안한것, 방문하면 그 위치까지 가는 데 걸린 시간이 배열에 저장됨)
		kinds = 0; //가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수 초기화

		if (N == K) {
			System.out.println(0); 
			System.out.println(1); 
			return; //
		} //처음 수빈이 위치와 동생 위치가 같으면  0,1을 출력하고 끝
			
		bfs(); 
		System.out.println(cnt); //수빈이가 동생을 찾는 가장 빠른 시간 출력
		
		visited[N]=0;  //출발지 다시 0으로 넣어줘야됨 (0은 미방문과 같아서, bfs과정에서 다른 숫자가 들어가버린다..)
		bfs2(); 
		System.out.println(kinds);
		

	}// main

	// 위치를 인자로 받는 bfs
	// N => K 로 가는 최소시간 구하기
	static void bfs() {

		queue.add(N); // 수빈 현 위치 큐에 삽입
		visited[N] = 0; 

		while (!queue.isEmpty()) {
			int t = queue.poll(); // 하나 꺼냄

			if (t == K) {
				cnt = visited[t];
				return;
			}
			
			//X-1 / X+1 / X*2 가 각각 범위 안에 있고 아직 방문안했으면 
			//t까지 걸린시간 +1을 그 위치까지 가는데 걸린 시간으로 넣어주고, 큐에 삽입
			if (t + 1 <= 100000 && visited[t + 1] == 0) {
				visited[t + 1] = visited[t] + 1;
				queue.add(t + 1);
			}
			if (t - 1 >= 0 && visited[t - 1] == 0) {
				visited[t - 1] = visited[t] + 1;
				queue.add(t - 1);
			}
			if (t * 2 <= 100000 && visited[t * 2] == 0) {
				visited[t * 2] = visited[t] + 1;
				queue.add(t * 2);
			}

		}

	}//bfs
	
	
	// K => N
	//각 위치 방문까지 걸린 최소 시간이 들어있는 visit 배열을 거꾸로 타고 올라가면서 경우의 수를 센다. 
	//단, 모든 경우의 수를 알아야하므로 방문처리는 따로 하지 않음!
	static void bfs2() {
		
		queue2.add(K); //동생 위치 큐에 삽입

		while (!queue2.isEmpty()) {
			int t = queue2.poll(); // 하나 꺼냄

			if (t == N) {
				kinds++; //수빈이 위치로 왔으면 경우의 수 +1 해준다
			}
			
			//범위 안에 있고 1작으면
			if(t+1<=100000 && visited[t+1]==visited[t]-1) {
				queue2.add(t+1);	
			}
			
			if(t-1>=0 && visited[t-1]==visited[t]-1) {
				queue2.add(t-1);
			}
			
			if(t%2==0 && visited[t/2]==visited[t]-1) { //t가2로 나누어떨어지고, 2로 나눈 위치로 가는데 걸린 시간이 visited[t]보다 1작으면 
				queue2.add(t/2);
			}

		}
		
	}

}// class
