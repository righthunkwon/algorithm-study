package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 기본적인 로직은 숨바꼭질 1, 2와 같다
public class BOJ_13913_숨바꼭질4 {
	
	static int N, K;
	static int[] time, tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		// tmp 배열에는 해당 좌표 도착 전 좌표가 역순으로 저장됨
		tmp = new int[100001];
		
		sol(N); // time 배열에 각 좌표당 최소 도착 시간이 저장됨
		
		Stack<Integer> s = new Stack<>();
		// 스트링빌더에 도착해야하는 (K)좌표 먼저 넣어주고
		s.add(K);
		int idx = K;
		
		// 해당 좌표 직전 좌표들을 담아서
		while(idx != N) {
			s.add(tmp[idx]);
			idx = tmp[idx];
		}
		while(!s.isEmpty()) sb.append(s.pop() + " ");
		
		// 출력
		System.out.println(time[K]);
		System.out.println(sb);
		
	}
	
	static void sol(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			if(poll == K) break;
			int next;
			
			for(int i = 0; i < 3; i++) {
				if(i == 0) next = poll - 1;
				else if(i == 1) next = poll + 1;
				else next = poll * 2;
				
				if(next < 0 || next > 100000) continue;
				if(time[next] == 0) {
					q.add(next);
					time[next] = time[poll] + 1;
					// 해당 좌표 직전 좌표 저장
					tmp[next] = poll;
				}
			}
		}
	}
}
