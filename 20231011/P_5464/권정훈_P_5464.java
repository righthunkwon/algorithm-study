package level_16_stack_queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 주차장
// 주차장 = 배열(순서)
// 대기열 = 큐(FIFO)
public class P_5464 {
	
	private static int n, m, ans;
	private static int[] charge, weight, parkinglot;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 주차 공간의 수
		m = sc.nextInt(); // 차량의 수
		ans = 0; // 총 수입
		
		charge = new int[n+1]; // 주차장의 단위 무게당 요금(인덱스는 주차장의 번호, 인덱스별 값은 무게당 요금)
		weight = new int[m+1]; // 차량의 무게(인덱스는 차량의 번호, 인덱스별 값은 차량의 무게)
		parkinglot = new int[n+1]; // 주차장에 주차된 차량 번호(인덱스는 주차장의 번호, 인덱스별 값은 차량 번호, 0일 경우 주차되지 않음)
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			charge[i] = sc.nextInt();
		}
		for (int i = 1; i <= m; i++) {
			weight[i] = sc.nextInt();
		}
		for (int i = 1; i <= 2*m; i++) {
			int tmp = sc.nextInt(); // 입차 혹은 출차한 차량 번호
			boolean flag = true; // 대기열에 담는지 여부
			
			// 차량이 들어오는 경우
			// 주차장 자리를 순서대로 비었는지 확인하고, 비어있으면 주차, 비어있지 않으면 대기열(큐)에 세움
			if (tmp > 0) {
				for (int j = 1; j <= n; j++) {
					// 빈자리가 있으면
					if (parkinglot[j] == 0) {
						parkinglot[j] = tmp; // 주차
						flag = false;
						break;
					} 
				}
				if (flag) q.add(tmp); // 대기열에 더함
			} 
			
			// 차량이 나가는 경우(요금 정산)
			else {
				for (int j = 1; j <= n; j++) {
					if (parkinglot[j] == -tmp) {
						ans += weight[-tmp] * charge[j];
						parkinglot[j] = 0;
						
						// 출자했을 경우 대기열에 있는 차가 있는지 확인하고 있으면 그 자리에 넣는다
						if (!q.isEmpty()) parkinglot[j] = q.poll();
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
