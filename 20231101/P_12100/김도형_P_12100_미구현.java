package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q12100_2048_Easy {

	static int N, ans;
//	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int [][]arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력끝

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//
//		moveleft(arr);
//		System.out.println("------------이동후 ---------");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		
		ans = 0; //답 초기화

		dfs(0, arr); 
		
		System.out.println(ans);

	}

	public static void dfs(int depth, int[][] arr) {

		// 기저
		if (depth >= 5) {
			ans = Math.max(ans, maxNum(arr));
			return;
		}

		int[][]tmp = new int [N][N];  //배열 복사해주기.. 원본 arr 안건들도록
		
		// 재귀
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp[i][j]=arr[i][j];
			}
		}
		dfs(depth + 1, moveup(tmp)); //위로이동
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp[i][j]=arr[i][j];
			}
		}
		dfs(depth + 1, movedown(tmp)); //아래이동
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp[i][j]=arr[i][j];
			}
		}
		dfs(depth + 1, moveleft(tmp)); //왼쪽이동
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp[i][j]=arr[i][j];
			}
		}
		dfs(depth + 1, moveright(tmp)); //오른쪽이동
		

	}
	
	
	/*이동하는 로직
	 * 
	 * 0. 배열을 순차적으로 돌면서 이동한다
	 * 1. 자기가 0이면 패쓰
	 * 2. 자기가 이동할 위치가 0이면 이동 (합쳐진 배열이면 합쳤었다는 boolean도 같이 이동)
	 * 3. 자기가 이동할 위치가 이번 이동때 합쳐진 적 없고 자기와 같은 숫자면 합치고 합 여부 boolean도 true처리
	 * 
	 * 
	 * */
	

	// 위로이동
	public static int[][] moveup(int[][] arr) {
		int L = arr.length;
		boolean[][] hapcomplete = new boolean[L][L]; //합친적 있는지 여부 확인용 배열(이동마다 초기화)
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				int x = i;  //i,j는 유지하기 위해서 x,y로 대체
				int y = j;
				
				if(arr[i][j]==0)continue; //0이면 패쓰
				
				while (true) {
					if (x - 1 >= 0 && arr[x - 1][y] == 0) { //이동할 곳이 범위 안이고 0이면 이동한다
						arr[x - 1][y] = arr[x][y];  //이동하고
						arr[x][y] = 0; //원래있던 자리 0으로
						hapcomplete[x - 1][y] = hapcomplete[x][y];   //합침 여부도 이동시키고
						hapcomplete[x][y] = false;  //원래자리의 합침여부는 false로
						x--; //옮겨간곳에서 다시 while문 돈다
					} else if (x - 1 >= 0 && arr[x - 1][y] == arr[x][y] && !hapcomplete[x - 1][y] //이동할 곳이 범위 안이고 자기와 숫자가 같고 함친적 없으면
							&& !hapcomplete[x][y]) { // 합체
						arr[x - 1][y] += arr[x][y]; //합체하고
						arr[x][y] = 0; //원래자리는 0으로
						hapcomplete[x - 1][y] = true; //합침여부 true처리
						x--;//옮겨간곳에서 다시 while문 돈다
					} else
						break; //합치거나 이동 불가능하면 while 종료
				}
			}
		}
		return arr;
	}
	
	//이하 동일한 로직으로..

	// 아래로이동
	public static int[][] movedown(int[][] arr) {
		int L = arr.length;
		boolean[][] hapcomplete = new boolean[L][L];
		for (int i = L - 1; i >= 0; i--) {
			for (int j = 0; j < L; j++) {
				int x = i;
				int y = j;
				if(arr[i][j]==0)continue;
				
				while (true) {
					if (x + 1 < L && arr[x + 1][y] == 0) { // 이동
						arr[x + 1][y] = arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x + 1][y] = hapcomplete[x][y];
						hapcomplete[x][y] = false;
						x++;
					} else if (x + 1 < L && arr[x + 1][y] == arr[x][y] && !hapcomplete[x + 1][y]
							&& !hapcomplete[x][y]) { // 합체
						arr[x + 1][y] += arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x + 1][y] = true;
						x++;
					} else
						break;
				}
			}
		}
		return arr;
	}

	// 좌로이동
	public static int[][] moveleft(int[][] arr) {
		int L = arr.length;
		boolean[][] hapcomplete = new boolean[L][L];
		for (int j = 0; j < L; j++) {
			for (int i = 0; i < L; i++) {
				int x = i;
				int y = j;
				if(arr[i][j]==0)continue;
				
				while (true) {
					if (y - 1 >= 0 && arr[x][y - 1] == 0) { // 이동
						arr[x][y - 1] = arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x][y - 1] = hapcomplete[x][y];
						hapcomplete[x][y] = false;
						y--;
					} else if (y - 1 >= 0 && arr[x][y - 1] == arr[x][y] && !hapcomplete[x][y - 1]
							&& !hapcomplete[x][y]) { // 합체
						arr[x][y - 1] += arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x][y - 1] = true;
						y--;
					} else
						break;
				}
			}
		}
		return arr;
	}

	// 우로이동
	public static int[][] moveright(int[][] arr) {
		int L = arr.length;
		boolean[][] hapcomplete = new boolean[L][L];
		for (int j = L - 1; j >= 0; j--) {
			for (int i = 0; i < L; i++) {
				int x = i;
				int y = j;
				if(arr[i][j]==0)continue;
				
				while (true) {
					if (y + 1 < L && arr[x][y + 1] == 0) { // 이동
						arr[x][y + 1] = arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x][y + 1] = hapcomplete[x][y];
						hapcomplete[x][y] = false;
						y++;
					} else if (y + 1 < L && arr[x][y + 1] == arr[x][y] && !hapcomplete[x][y + 1]
							&& !hapcomplete[x][y]) { // 합체
						arr[x][y + 1] += arr[x][y];
						arr[x][y] = 0;
						hapcomplete[x][y + 1] = true;
						y++;
					} else
						break;
				}
			}
		}
		return arr;
	}

	// 배열 내 최대값 구하기
	public static int maxNum(int[][] arr) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		return max;
	}

}
