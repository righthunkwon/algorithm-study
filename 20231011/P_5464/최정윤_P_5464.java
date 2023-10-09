package baek;

import java.io.*;
import java.util.*;

public class Pro_5464_주차장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] price = new int[N + 1];
		int[] kg = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= M; i++) {
			kg[i] = Integer.parseInt(br.readLine());
		}

		int[] car = new int[M + 1];// 각 인덱스의 차가 주차한 자리 , 만약 3번 차가 4번 자리에 주차하였다면 car[3]=4로 설정

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();// 빈 주차자리 인덱스 넣는 큐, 가장 작은 값을 꺼내기 위해 우선순위큐 사용
		Queue<Integer> wait = new LinkedList<Integer>();// 기다리고 있는 차량번호 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);//처음에는 모든 자리 비어있다. queue에 저장
		}
		int money = 0;
		for (int i = 1; i <= 2 * M; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now > 0) {// 주차장에 들어올떄
				if (queue.isEmpty() || !wait.isEmpty()) {//빈자리가 없거나, 기다리고 있는 차들이 있는 경우 
					wait.add(now);                       //대기열에 차 번호를 넣는다.
				} else {//빈자리가 있고 , 기다리고 있는 차들이 없으면 차를 넣을 수 있다. 차 넣을 때 금액 계산하기
					int num = queue.poll();//현재 비어있는 자리 중 가장 작은 값 꺼내기
					car[now] = num;//차가 들어간 자리 번호 저장
					money += price[num] * kg[now];//돈 계산
				}
			} else {// 주차장에서 나갈 때
				queue.add(car[-now]);//현재 차가 들어있는 자리 큐에 다시 넣고
				if (!wait.isEmpty()) {//대기하는 차가 있다면 자리가 비었으니까 차 넣고 금액계산
					int num = queue.poll();
					int carnum = wait.poll();
					car[carnum] = num;
					money += price[num] * kg[carnum];
				}
			}
		}
		System.out.println(money);
	}
}
