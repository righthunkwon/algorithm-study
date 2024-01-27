import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
		N = sc.nextInt();
		// 그냥 숫자 입력받는대로
		// 전부다 우선순위 큐에다가 넣고
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<N;i++) {
			pq.add(sc.nextInt());
		}
		// 이제 하나씩 다 뽑자 
		// 하나는 왼쪽 하나는 오른쪽 배열에
		int[] arr = new int[N];
		int ans = 0;
		int index = 0;
		// 양쪽 끝에서 가운데로
		// 큐에서 숫자뽑아 넣음
		while(pq.size()!=0) {
			int tmp1 = pq.poll();
			arr[index] = tmp1;
			if(pq.size()!=0) {
			int tmp2 = pq.poll();
			arr[N-1-index] = tmp2;
			index ++;
			}
			else {
				break;
			}
			// 하나씩 arr에 각각 저장
		}
		// 맨처음과 맨끝차이를 먼저 ans에 넣고
		// for문으로 쭉 차이 최대값구함
		ans = Math.max(ans, Math.abs(arr[0]-arr[N-1]));
		for(int i = 0;i<N-1;i++) {
			ans = Math.max(ans , Math.abs(arr[i+1]-arr[i]));
		}
		
	System.out.println(ans);
		}
	}
}
