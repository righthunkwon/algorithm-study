import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M ;
	static int D;
	static int ans;
	static int[][] arr;
	static int[][] arr2;
	static int[] att;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M =sc.nextInt();
		D = sc.nextInt();
		arr = new int[N][M]; // 기존 적의 위치를 담을 배열
		arr2 = new int[N][M]; // 적위치 복사 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		// 일단 배열에서 궁수 3명을 먼저 선별함
		// 선별된 궁수를 기준으로 계속 턴마다
		// 공격진행 -> 
		// 하나씩 좌표 내리고 다시 진행
		// 죽이는 수 중 최대점 골라냄
		att = new int[M]; // 궁수가 들어갈 수 있는 배열
		for (int i = 0; i < M; i++) {
			att[i] = i;
		}
		ans = 0;
		int[] pos = new int[3]; // 3명의 궁수를 선정할 배열
		choose(0,0,pos);

		System.out.println(ans);
	}

	private static void choose(int cnt, int idx, int[] pos) {
		if (cnt == 3) {
			// 3명이 선정되었으면 게임 진행
			// ans에는 최대죽이는 수 저장
			int tmp = solve(pos);
			ans = Math.max(tmp, ans);
			return;
		}
		// att배열에서 3개를 선정하는 과정
		for (int i = idx; i < att.length; i++) {
			pos[cnt] = att[i];
			choose(cnt+1,idx+1, pos);
		}
	}

	private static int solve(int[] pos) {
		for(int i = 0 ; i < N ; i++) {
			arr2[i] = Arrays.copyOf(arr[i], M);
		}
		int tmp = 0;
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();

		while (sum < N) {
			for (int k = 0; k < 3; k++) {
				int x = N - sum;
				int y = pos[k];

				int min = Integer.MAX_VALUE;
				int minX = -1;
				int minY = -1;

				for (int i = N - sum - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (arr2[i][j] == 1) {
							int dist = Math.abs(i - x) + Math.abs(j - y);

							if(dist > D) continue;

							if (dist < min) {
								min = dist;
								minX = i;
								minY = j;
							} else if (dist == min) {
								if (j < minY) {
									minX = i;
									minY = j;
								}
							}
						}
					}
				}

				if(minX == -1 || minY == -1) continue;

				q.offer(new int[]{minX, minY});
			}

			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.poll()[1];

				if(arr2[x][y] == 1){
					arr2[x][y] = 0;
					tmp += 1;
				}
			}
			sum += 1;
		}
		return tmp;
	}
}
