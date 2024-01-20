import java.util.ArrayList;
import java.util.Scanner;


public class Main {
static int[][] arr;	
static ArrayList<Integer> ax;
static ArrayList<Integer> ay;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이거 그냥 
		// 모든 dfs 다도는데
		// 하나 넣을때마다 
		// 백트래킹해볼까??
		arr = new int[9][9];
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		for(int i = 0;i<9;i++) {
			String tmp = sc.next();
			for(int j =0;j<9;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
				if(arr[i][j] ==0) {
					ax.add(i);
					ay.add(j);
				}
			}
		}
		// 입력끝
		solve(0);
		
		
		
		
		
	}	
	public static boolean solve(int index) {
		if(index == ax.size()) {
			// 여기까지 온거는 다 만족한다는 소리
			// 출력하고 종료
			for(int i = 0;i<9;i++) {
				for(int j =0;j<9;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		int x =ax.get(index);
		int y =ay.get(index);
		// x,y에 해당하는 좌표에 
		// 1~9를 넣고
		// 3가지 경우 모두 check
		for(int i = 1;i<=9;i++) {
			arr[x][y] = i;
			// 세로 + 가로 체크하고 , 9개 탐색
			// 두개를 모두 만족하면 다음 dfs 돌고
			// 그걸 다 만족해서 끝까지 가게
			if(check1(x,y) && check2(x,y)) {
				if(solve(index+1)) {
					return true;
				}
			}
		}
		arr[x][y] = 0;
		return false;
	}
	// 가로 탐색 + 세로 탐색
	public static boolean check1(int x , int y) {
		for(int i = 0;i<9;i++) {
			// 가로탐색
			if(y!=i && arr[x][y] == arr[x][i]) {
				return false;
			}
			// 세로탐색
			if(x!=i && arr[x][y] == arr[i][y]) {
				return false;
			}
		}		
		return true;		
	}
	public static boolean check2(int x, int y) {
		// 9개를 나눈거 탐색 ... 3을 나눈거로 시작해서 3곱한거부터 시작해서
		for(int i = (x/3)*3;i<(x/3)*3+3;i++) {
			for(int j = (y/3)*3;j<(y/3)*3+3;j++) {
				if(x!=i && y!=j && arr[x][y] == arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
