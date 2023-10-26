import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class pos implements Comparable<pos> {
		int st;
		int end;
		int cost;

		public pos(int st, int end, int cost) {
			this.st = st;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(pos o) {
			return this.cost - o.cost;
		}
	}
	static int N;
	static int M;
	static int[] arr;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 일단 cost가 있으니깐 다 넣고..
		// 우선순위 큐에다가 다 넣은다음에
		// cost가 적은거부터 하나씩 넣고 
		// 갱신해가는 방식?
		PriorityQueue<pos> pq = new PriorityQueue<>();
		arr = new int[N+1];
		for(int i =0;i<M;i++) {
			int a= sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			pq.add(new pos(a,b,c));
		}
		// 일단 arr에서 자신이 부모가 자신을 향하게 설정
		for(int i =1;i<=N;i++) {
			arr[i] = i;
		}
		sum = 0;
		int last = 0;// 마지막 연결되는 두개의 숫자는 떨어질 마을의 숫자로 마지막에 빼줌
		// 일단 입력해서 cost가 작은거부터
		// pq에 다 넣어놨음
		while(true) {
			// cost가 작은거부터 하나씩 꺼내서
			// 두개를 서로 잇는다.
			// 그리고 두개의 값을 arr에 넣고
			// 이러한 과정을 반복
			pos po = pq.poll();
			// 현재 꺼낸거의 서로 시작점과 끝점의 부모확인
			// 서로 안이어져 있으면
			// 이어준다
			if(!check(po.st, po.end)) {
				union(po.st,po.end);
				// 이은다음 현재의 cost를 sum에 더해줌
				sum += po.cost;
				last = po.cost; // 마지막 2개숫자는 떨어져아함
			}
			// 큐에 넣은거 다 확인했으면 break
			if(pq.size()==0) {
				break;
			}			
		}
		System.out.println(sum-last);


	}
	public static boolean check(int x, int y) {
		// 현재 x와 y의 향해있는곳이 
		// 서로 같은 곳을 향하고 있으면 false
		// 아니면 true 반환
		int nx = find(x);
		int ny = find(y);
		if (nx != ny) {
			return false;
		} 		
		return true;

	}
	// 현재 x의 값이 누구랑 이어져있는지 찾기위함
	public static int find(int x) {
		// 현재의 x값이 자신을 기록하고 있다면 x반환
		if (x == arr[x]) {
			return x;
		} 
		// 아니라면 적혀있는 값이 부모를 찾으러 이동	        
		return arr[x] = find(arr[x]);

	}

	// x와 y를 서로 잇는것으로 
	// x와 y가 서로 향해있는 수를 찾아가지고
	// nx를 부모로 
	// ny를 자식으로 보냄
	public static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		arr[ny] = nx;
	}
}
