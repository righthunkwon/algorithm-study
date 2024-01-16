
import java.io.*;
import java.util.*;

public class Pro_11000_강의실배정 {
	static class Class implements Comparable<Class> {
		int s, e;
		public Class(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Class o) {
			return this.s - o.s;// this-o 오름차순
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Class> pq = new PriorityQueue<Class>(); // 강의 시작시간 작은 것 부터 뽑기 위해
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();//끝나는 시간 저장 
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Class(start, end));
		}//입력끝
		
		
		while (!pq.isEmpty()) {//강의 뽑기
			Class curr = pq.poll();
			if (pq2.isEmpty()) {//강의실이 없으면 
				pq2.add(curr.e);
				continue;
			}
			//처음 뽑는 것이 시간이 가장 일찍 종료되는 강의실이므로 한개만 비교하면 된다.
			if (pq2.peek() <= curr.s) {//강의실 종료시간이 수업시작 시간과 같거나 빠르다면 강의실 종료시간만 바꿔준다.
				pq2.poll(); 
				pq2.add(curr.e);
			} else {//쓸 수 있는 강의실이 없다는 뜻 강의실 새로 만들기
				pq2.add(curr.e);
			}
		}
		System.out.println( pq2.size());
	}

}
