package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	
	static class Tmp {
		int s, e;

		public Tmp(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Tmp[] arr = new Tmp[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Tmp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 시작 시간 빠른순 정렬, 시작 시간이 같으면 종료 시간 빠른순 정렬
		Arrays.sort(arr, (a, b) -> a.s == b.s ? a.e - b.e : a.s - b.s);
//		for(int i = 0; i < N; i++) System.out.println(arr[i].s + " " + arr[i].e);
		
		// 종료 시간들만 우선순위 큐에 넣는다
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < N; i++) pq.add(arr[i].e);
		
		// (정렬된)시작 시간들 돌면서 종료 시간보다 크면 종료시간을 우선순위 큐에서 뺀다 (한 강의실에서 수업 가능하다는 뜻)
		for(int i = 0; i < N; i++) if(arr[i].s >= pq.peek()) pq.poll();
		
		// 큐에 남은 것들은 새로운 강의실이 필요한 개수와 같다
		System.out.println(pq.size());
		
	}
}
