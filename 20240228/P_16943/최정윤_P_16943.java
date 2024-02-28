import java.io.*;
import java.util.*;

public class Pro_16235_나무재테크 {
	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws IOException {
		// 봄: 나무가 자신의 나이만큼 양분을 먹고 나이+1 => 양분 못먹으면 죽음
		// 여름: 죽은 나무 나이/2 가 나무가 있던 칸에 양분으로 추가됨
		// 가을: 나이가 5의 배수이면 인접 8칸에 나이가 1인 나무 생김
		// 겨울: 양분 추가 A[r][c]

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		int[][] A = new int[N][N];
		int[][] feed = new int[N][N];
		PriorityQueue<Tree> tree = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			Arrays.fill(feed[i], 5);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(r, c, age));
		} // 입력끝

		for (int q = 0; q < K; q++) {
			int[][] die = new int[N][N];
			int[][] new_tree = new int[N][N];
			Queue<Tree> qe = new LinkedList<>();
			// 봄
			while (!tree.isEmpty()) {
				Tree curr = tree.poll();
				int nr = curr.r;
				int nc = curr.c;
				int age = curr.age;
				if (feed[nr][nc] >= age) {
					feed[nr][nc] -= age;
					qe.add(new Tree(nr, nc, age + 1));
					if ((curr.age + 1) % 5 == 0)
						new_tree[nr][nc]++;
				} else {
					die[nr][nc] += age / 2;
				}
			}
			tree.addAll(qe);

			// 여름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					feed[i][j] += die[i][j];
				}
			}
			// 가을
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					while (new_tree[i][j] > 0) {
						for (int k = 0; k < 8; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							tree.add(new Tree(nr, nc, 1));
						}
						new_tree[i][j]--;
					}
				}
			}
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					feed[i][j] += A[i][j];
				}
			}
		}
		// 계산
		System.out.println(tree.size());
	}
}
