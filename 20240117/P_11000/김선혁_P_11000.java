import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 시작지점에서 끝나는 지점까지
		// 가장 짧은 시간에 끝나는 작업을 수행하면 될듯
		
		// 일단 처음부터보면 가장 먼저 끝나는거를 기준
		node[] arr = new node[N];
		for(int i = 0;i<N;i++) {
			int a = sc.nextInt();
			int b=  sc.nextInt();
			arr[i] = new node(a,b);
			// a랑 b로 노드에 추가
		}
		// 이제 arr배열을 정렬해서 시작지점이 낮은순서대로
		// 오게 정렬하고
		
		// 시작지점이 되는거부터
		// 큐에다 넣자
		Arrays.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0].en);
		// 이제 하나씩 뽑아서 
		// 이 끝지점보다 시작지점이 최대한 비슷한거 나오면
		// 큐에다가 추가
		for(int i = 1;i<N;i++) {
			// 최대한 st가 작은거부터 나옴
			if(arr[i].st>= pq.peek()) {
				pq.poll();
			}
			pq.add(arr[i].en);
		}
		System.out.println(pq.size());
	}
	static class node implements Comparable<node> {
		int st;
		int en;
		public node(int st, int en) {
			super();
			this.st = st;
			this.en = en;
		}
		@Override
		public int compareTo(node o) {
			if (st == o.st) {
				return en - o.en;
			}

			return st - o.st;
		}
	}

}
