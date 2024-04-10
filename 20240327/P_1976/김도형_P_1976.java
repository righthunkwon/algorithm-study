import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 수 N
		int M = Integer.parseInt(br.readLine()); // 여행할 도시의 수 M

		ArrayList<Integer> link[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			link[i] = new ArrayList();
		}
		StringTokenizer st;
		// 연결 정보 입력
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					link[i].add(j);
					link[j].add(i);
				}
			}
		}
		
		//여행계획
		st = new StringTokenizer(br.readLine());
		
		boolean []visit = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>(); 
		
		int startpoint = Integer.parseInt(st.nextToken());
		q.add(startpoint);
		
		visit[startpoint]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next: link[now]) {
				if(visit[next])continue;
				visit[next]=true;
				q.add(next);
			}
		}
		
		boolean ans = true;
		
		for(int i = 0;i<M-1;i++) {
			if(!visit[Integer.parseInt(st.nextToken())]) { //한번도 방문한적 없는 곳이 여행계획에 있으면 false
				ans = false;
			}
		}
		
		if(ans)System.out.println("YES");
		else System.out.println("NO");
		

	}// main
}// class
