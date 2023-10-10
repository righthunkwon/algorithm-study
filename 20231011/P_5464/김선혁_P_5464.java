import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //주차 공간수
		M = sc.nextInt(); // 차량의 수
		arr = new int[N+1]; // 현재 주차구역에 무슨차가 있는지
		int[] weight = new int[M+1]; // 차량의 무게  
		int[] cost = new int[N+1]; // 주차구역의 금액
		
		for(int i =1;i<=N;i++) {
			cost[i] = sc.nextInt();
		}
		for(int i =1;i<=M;i++) {
			weight[i] = sc.nextInt();
		}
		// 입력끝
		int sum = 0;
		Queue<Integer> q = new LinkedList<>();
		// 큐에다가 이제 들어오는 차 넣을거임
		
		for(int i =0;i<2*M;i++) {
			int num = sc.nextInt();
			// 양수면 들어오는차 , 음수면 나가는 차
			if(num>0) {
				for(int j=1;j<=N;j++) {
					if(arr[j] ==0) {
						//현재 빈자리가 있으면 
						// 그 자리에 차를 넣고 break
						// 없으면 큐에다가 넣음
						arr[j] = num;
						break;
					}
					if(j==N) {
						// 빈자리가 없으면 큐로
						q.add(num);
					}
				} // j for
			} // if
			// 차가 나가는 경우
			else {
				num *= -1;
				for(int j=1;j<=N;j++) {
					if(arr[j] == num) {
						arr[j] = 0; 
						// 현재의 자리 가중값에 무게를 곱한것을
						// sum에 더한다.
						sum+= cost[j] * weight[num];
						// 그리고 큐에 차가 있는 것을 자리에 넣음 
						if(q.size()!=0) {
							arr[j] = q.poll();
						}
					}					
				} // j for
				
			} // else
						
		}
		
		System.out.println(sum);

	}
}
