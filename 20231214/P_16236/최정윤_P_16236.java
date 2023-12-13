package baek;

import java.util.*;
import java.io.*;
//bfs를 통해 잡아먹을 물고기들을 pq에 넣고 (같은 시간에 잡아먹을 수 있는 물고기들)
//우선순위큐를 통해 꺼내서 잡아먹고 본인 몸집 키우고 , 
//그 자리에서 다시 bfs로 잡아먹을 물고기 찾기 ->pq로 잡아먹기 반복함 ..
public class Pro_16236_아기상어 {
	static class Shark implements Comparable<Shark> {
		int r, c, time, size;
		public Shark(int r, int c, int time, int size) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.size = size;
		}
		@Override
		public int compareTo(Shark o) {//우선순위 큐로 꺼낼 때 제일 위, 제일 왼쪽부터 꺼내려고
			if (this.r == o.r)
				return this.c - o.c;
			return this.r - o.r;
		}
	}

	static Queue<Shark> q; //bfs를 통해서 이동하려고 (먹는 물고기 없어도 이동을 해서 찾으려고 )
	static PriorityQueue<Shark> pq; //먹을 물고기 넣어서 우선순위로 잡아먹는 물고기 정하려고
	static int[] dr, dc;
	static int[][] arr;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					q = new LinkedList();
					visited = new boolean[N][N];
					visited[i][j] = true;
					arr[i][j] = 0;
					q.add(new Shark(i, j, 0, 2));
				}

			}
		} // 입력끝
		int eating = 0;
		int result = 0;
		while (true) {//잡아먹을 물고기 찾기
			pq = new PriorityQueue();
			bfs();	//먹는 물고기 pq에 넣어서 고르기 위해 돌리는 거
			if (pq.isEmpty()) //먹을 물고기가 없다면 종료 
				break;
			else { //먹을 물고기가 있다면 
				q = new LinkedList(); //while문으로 다시 bfs돌리기 위해 새로 만들어 놓기
				Shark curr = pq.poll(); //잡아먹을 물고기 꺼내기
				result = curr.time; // 이 물고기 먹는데까지의 시간을 결과값으로 일단 저장
				eating++; //먹은 물고기 수 +1
				if (eating == curr.size) { //현재 사이즈와 같다면 
					curr.size += 1;        //내 사이즈 증가 시키고
					eating = 0; 		   //다시 0으로 초기화
				}
				visited = new boolean[N][N];    
				visited[curr.r][curr.c] = true;  //잡아먹고 여기서 다시 잡아먹을 물고기 찾으니까 
				arr[curr.r][curr.c]=0;           //잡아먹은 자리는 0으로 세팅
				q.add(curr);					 //다시 잡아먹을 물고기 찾기 ㄱㄱ
			}
		}
		System.out.println(result);
	}

	public static void bfs() {//잡아먹을 물고기를 pq에 다 넣는다 
		int time = 0;
		while (!q.isEmpty()) {
			Shark curr = q.poll();
			if (!pq.isEmpty()) { //이미 먹을 수 있는 물고기가 있는데 그 물고기 만나는 시간보다 걸리는 시간이 더 크면 의미가 없다 .
				if (curr.time > time)
					return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || curr.size < arr[nr][nc] || visited[nr][nc])
					continue; //범위 밖이거나 방문했거나, 지나갈 수 없는 물고기가 있다면 
				if (arr[nr][nc] != 0 && curr.size > arr[nr][nc]) {//물고기가 있고 먹을 수 있다면 일단 바로 먹지말고 우선순위 높은 애 먹기 위해 pq에 담는다.
					pq.add(new Shark(nr, nc, curr.time + 1, curr.size)); 
					time = curr.time;
				} else {//그냥 q에 담는다. 이동의 의미
					q.add(new Shark(nr, nc, curr.time + 1, curr.size));
				}
				visited[nr][nc]=true;
			}
		}
	}
}
