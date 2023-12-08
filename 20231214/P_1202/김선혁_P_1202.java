
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {	
	static int N;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		ArrayList<Integer> bag = new ArrayList<>();
		PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price); // 우선순위 큐를 만듬
		// 가격이 높은순서대로 정렬 (여러개 저장시켜놓고 해당 가방에 들어갈 수 있는 물건들 중
		// 가장 값이 높은 애만 넣을 거임
		ArrayList<node> item = new ArrayList<>(); 
		// 물건들이 들어가는대로 pq에서 졍렬되도록 한다 가격중심
		for(int i =0;i<N;i++) {
			item.add(new node(sc.nextInt(),sc.nextInt()));
			// 숫자가 들어오는대로 pq에다가 넣음
		}
		for(int i=0;i<K;i++) {
			bag.add(sc.nextInt());
		}
		// 입력끝		
		Collections.sort(item, (o1, o2) -> o1.size - o2.size); // 사이즈가 낮은것이 젤 먼저오게 정렬
		Collections.sort(bag); // 무게가 적은거부터 정렬

		long ans = 0;
		int idx = 0;
		for(int i =0;i<K;i++) {
			while(true) {
				// 해당 가방하나를 설정한 후 
				// 무게가 낮은 애들부터 현재 가방에 들어갈 수 있는 최고의 값을 가진 애들 구해줌
				// 그 이후에 어차피 또 다음가방에 들어갈 수 있는 애들 중
				// 값이 가장 큰애가 큐의 첫번째 저장될 거라 큐에서 k개만큼만 뽑으면됨
				if(idx < N && item.get(idx).size<= bag.get(i)) {
					// idx가 N보다 작거나 현재 idx번째 사이즈가 가방에 들어갈 수 있어야함
					node tmp = item.get(idx++); 
					pq.add(new node(tmp.size , tmp.price));
				}
				else {
					break; 
				}
//				System.out.println(idx);
			}
			// 사이즈가 0이면 i번째 가방에 아무것도 못들어간거라 패스
			if(pq.size()==0) {
				continue;
			}
			ans += pq.poll().price;
		}

		System.out.println(ans);

	}

	public static class node {
		int size;
		int price;
		public node(int size, int price) {
			this.size = size;
			this.price = price;
		}

		//		@Override
		//		public int compareTo(node o) {
		//			return o.size - this.size; // 이렇게하면 size가 낮은거부터 정렬된다!
		//		}

	}

}    
