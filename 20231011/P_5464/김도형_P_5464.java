package AlgoStudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q5464_주차장 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주차공간 수
		int M = sc.nextInt(); // 오늘 주차장 이용할 차량 수

		int[] cost = new int[N + 1]; //비용 넣을 배열
		int[] weight = new int[M + 1]; //차량 별 무게 넣을 배열

		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt(); //비용 입력
		}

		for (int i = 1; i <= M; i++) {
			weight[i] = sc.nextInt(); //무게 입력
		}

		// 주차공간에 차량 있는지 확인용 배열
		int[] visit = new int[N + 1];

		// 대기차량용 큐 생성
		Queue<Integer> wait = new LinkedList<Integer>();

		int total = 0; 

		for (int inNout = 0; inNout < M * 2; inNout++) {

			int x = sc.nextInt(); //차 들어오고 나가는 정보 입력받음

			if (x > 0) { //0보다 크면 차가 들어온 것
				wait.add(x); // 일단 큐에 삽입
				for (int i = 1; i <= N; i++) {
					if (visit[i] == 0) { // 주차공간 있으면
						int a = wait.poll(); // 큐에서 빼주고
						visit[i] = a; // 그걸 방문 배열에 넣어줌
						total += cost[i] * weight[a]; // 비용 계산
						break;
					}
				}

			} else { //0보다 작으면 차가 나가는 것
				
				for (int i = 1; i <= N; i++) {
					
					if (visit[i] == x * (-1)) { // -1 곱한 값을 방문배열에서 찾음

						if (!wait.isEmpty()) { // 이때 큐가 비어있지 않으면
							int a = wait.poll(); //큐에서 빼서
							visit[i] = a;  //방문 배열에 넣고
							total += cost[i] * weight[a];  //비용 계산
						} else {
							visit[i] = 0;  //대기중인 차 없으면 빈 자리로 0 넣어줌
						}
						break;
					}

				}

			} // else (음수 들어오면)

		} // inNout

		System.out.println(total);

	}

}
