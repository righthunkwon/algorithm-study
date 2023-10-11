import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686_치킨배달2 {
	static int N,M;
	static int min =9876543;
	static int[][] arr;
	static List<int[]>home = new LinkedList<>();
	static List<int[]>chicken = new LinkedList<>();
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도시 : N*N크기
		N = Integer.parseInt(st.nextToken());
		// 치킨집 수
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N]; //도시
		
		int hdx =0; // 집 인덱스, 여기선 집 수를 카운트해서 차례대로 배열에 넣기 위한 용도
		// arr : 도시 지도 채우기
		// visited : 벽을 세울 수 있는 공간 외엔 true로 입력하기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					home.add(new int[] {i,j}); hdx++;
				}
			}
		}
		//dfs돌려서 0의 최대개수 구한다
		dfs(0);
		System.out.println(min);
		
	}//main
	public static void dfs(int cnt) {
		if(cnt==M) {
			// M개 치킨집 고른걸로 지도 바꿈
			
			int sum=0;
			for(int i=0;i<home.size();i++) {
				int dis = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					int d = Math.abs(home.get(i)[0]-chicken.get(j)[0]) + Math.abs(home.get(i)[1]-chicken.get(j)[1]);
						dis = Math.min(dis, d);
					
					
				}
				sum += dis;
			}
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {

				if(arr[i][j]==2) {
					arr[i][j] = 3;
					chicken.add(new int[] {i,j});
					dfs(cnt+1);
					arr[i][j] = 2;
				}
			}
		}
		
	}//dfs

		
	
}
