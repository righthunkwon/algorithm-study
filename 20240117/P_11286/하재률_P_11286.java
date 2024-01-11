package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 절댓값 기준으로 바꿔주자
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if(Math.abs(a) > Math.abs(b)) return Math.abs(a) - Math.abs(b);
			else if(Math.abs(a) == Math.abs(b)) return a - b;
			else return -1;
		});
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp != 0) pq.add(tmp);
			else {
				if(!pq.isEmpty()) System.out.println(pq.poll());
				else System.out.println(0);
			}
		}
	}
}
