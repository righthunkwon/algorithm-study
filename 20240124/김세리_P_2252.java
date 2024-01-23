package _20240124;

import java.io.*;
import java.util.*;

public class _2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		int[] arr = new int [N+1];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			arr[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			// 앞에 와야하는 수가 없는 애들
			// (연관관계에서 앞에 해당하거나 관계가 주어지지 않은 애들)
			if(arr[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp +" ");
			for(int next : graph.get(tmp)) {
				// 앞에 와야하는 애(tmp)가 출력되었으므로 이제 걔와 연계된 애는
				// 무조건 tmp보다 뒤에 출력되므로
				// arr에 저장된 값에서 -1을 해준다.
				arr[next]--;
				// 그렇게 1을 빼줬을 때 arr값이 0이 된단 소리는
				// 더이상 앞에 올 수가 없다는 의미이므로
				// q에 더해준다
				if(arr[next]==0) q.add(next);
			}
		}
		
	}//main

}
