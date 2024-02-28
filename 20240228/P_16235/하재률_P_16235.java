package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	
	static int N, M, K;
	static PriorityQueue<Integer>[][] tree;
	static Queue<Integer>[][] tmp;
	static int[][] bob, map, dead;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new PriorityQueue[N][N];
		tmp = new Queue[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tree[i][j] = new PriorityQueue<>();
				tmp[i][j] = new LinkedList<>();
			}
		}
		bob = new int[N][N];
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				bob[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken()));
		}
		
		while(K-->0) {
			spring();
			summer();
			fall();
			winter();
		}
		int res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(tree[i][j].size() == 0) continue;
				res += tree[i][j].size();
			}
		}
		System.out.println(res);
		
	}
	
	static void spring() {
		dead = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(tree[i][j].isEmpty()) continue;
				while(!tree[i][j].isEmpty()) {
					int poll = tree[i][j].poll();
					if(poll <= map[i][j]) {
						tmp[i][j].add(poll+1);
						map[i][j] -= poll;
					} else dead[i][j] += poll/2;
				}
			}
		}
	}
	
	static void summer() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] += dead[i][j];
			}
		}
	}
	
	static void fall() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				while(!tmp[i][j].isEmpty()) {
					int poll = tmp[i][j].poll();
					if(poll % 5 == 0) {
						for(int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							tree[nx][ny].add(1);
						}
					}
					tree[i][j].add(poll);
				}
			}
		}
	}
	
	static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] += bob[i][j];
			}
		}
	}
}
