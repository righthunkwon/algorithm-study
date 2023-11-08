package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17404_RGB거리2 {
	static int N, min;
	static int[][] cost, house;
	static boolean[] visited;
	static int[] color = {1,2,3};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cost = new int [N][3];

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력끝

		house = new int [2][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		// 1-빨강, 2-초록, 3-파랑
		paint(1,2,0);
		paint(1,3,0);
		paint(2,1,0);
		paint(2,3,0);
		paint(3,1,0);
		paint(3,2,0);
		System.out.println(min);

	}//main
	static void paint(int start, int last, int cnt) {
		if(cnt == N-2) {
			System.out.println(Arrays.deepToString(house));
			int sum =0;
			for(int i=0;i<N;i++) {
				sum += house[1][i];
			}
			min = Math.min(min, sum);
			return;
		}
		//색을 칠한다
		house[0][0]=start;
		house[1][0]=cost[0][start-1];
		visited[0]=true;
		house[0][N-1]=last;
		house[1][N-1]=cost[N-1][last-1];
		visited[N-1]=true;

		for(int i=1;i<N-1;i++) {
			for(int j=1;j<4;j++) {
				if(!visited[i]) {
					if(house[0][i]==0 && j != house[0][i-1] && j != house[0][i+1]) {
						visited[i]=true;
						house[0][i]=j;
						house[1][i]=cost[i][j-1];
						visited[N-1]=false;
						paint(start,last,cnt+1);
						visited[i]=false;
						house[0][N-1]=0; house[1][N-1]=0; house[0][i]=0; house[1][i]=0;
					}
				}
			}
		}
	}//paint

}

