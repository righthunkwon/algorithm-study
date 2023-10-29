package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 저번 문제(숨바꼭질 1)에서 조건 하나만 추가했다..
public class BOJ_12851_숨바꼭질2 {
	
	static int N, K, cnt; // 수빈 위치 N, 동생 위치 K
	static int[] time; // 각 좌표 걸리는 시간 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		
		sol(N);
		System.out.println(time[K]);
		System.out.println(cnt);
	}
	
	static void sol(int N) {
		cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N); // 시작점을 큐에 넣고
		// while문을 적당히 break 시킬 수 있는 조건 넣으면 좋을듯... 없어도 맞았습니다 뜨긴해요
		while(!q.isEmpty()) {
			int poll = q.poll(); // poll은 현재 위치
			if(poll == K) {
				cnt++; // 수빈이가 동생한테 도착하면 cnt ++
				continue;
			}
			int next; // 다음 위치
			
			// 현재 위치에서 -1, +1, *2
			for(int i = 0; i < 3; i++) {
				if(i == 0) next = poll - 1; // 현재위치 - 1
				else if(i == 1) next = poll + 1; // 현재위치 + 1
				else next = poll * 2; // 현재위치 * 2
				
				if(next < 0 || next > 100000) continue; // 범위 벗어나면 continue
				// 첫 방문이거나, 방문 했더라도 같은 시간이 걸리면 q에 넣기
				if(time[next] == 0 || time[next] == time[poll] + 1) {
					q.add(next);
					time[next] = time[poll] + 1;
				}
			}
			
		}
	}
}
