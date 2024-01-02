import java.io.*;
import java.util.*;

public class Pro_4920_테트리스게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][][] t=new int[][][] {{{0,0},{0,1},{0,2},{0,3}},{{0,0},{1,0},{2,0},{3,0}},
			{{0,0},{0,1},{1,1},{1,2}},{{0,0},{1,0},{1,-1},{2,-1}},
			{{0,0},{0,1},{0,2},{1,2}},{{0,0},{1,0},{2,0},{2,-1}},{{0,0},{1,0},{1,1},{1,2}},{{0,0},{0,1},{1,0},{2,0}},
			{{0,0},{0,1},{0,2},{1,1}},{{0,0},{1,0},{2,0},{1,1}},{{0,0},{1,0},{2,0},{1,-1}},{{0,0},{0,1},{0,2},{-1,1}},
			{{0,0},{0,1},{1,0},{1,1}}};
		int tc=0;
		while (true) {
			tc++;
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {
				System.exit(0);}
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//이게 핵심 .. 이것 때문에 많이 틀렸다 ..
			int max=-Integer.MAX_VALUE;
			
			//ㅁㅁㅁㅁ   ㅁㅁ      ㅁㅁㅁ     ㅁㅁㅁ     ㅁㅁ
			//        ㅁㅁ          ㅁ       ㅁ         ㅁㅁ
			//그냥 다 돌면서 .. 범위가 벗어나면 max값 계산 X
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					c: for(int[][] a:t) {
						int sum=0;
						for(int[] b:a) {
							int nr=i+b[0];
							int nc=j+b[1];
							if(nr<0||nc<0||nr>=N||nc>=N)continue c;
							sum+=board[nr][nc];
						}
						max=Math.max(sum, max);
					}
					
				}
			}
			System.out.println(tc+". "+max);
		}

	}
}
