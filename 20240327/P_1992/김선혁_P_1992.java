import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		for(int i = 0 ; i<N;i++) {
			String tmp = sc.next();
			for(int j = 0; j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		// 입력끝
		
		// 재귀를 통해서 해당 지점을 기준으로
		// 왼쪽위 오른쪽위 왼쪽 아래 오른쪽아래 재귀해서
		// 만약 해당지점부터 크기만큼 다 같으면 1 출력
		solve(0,0,N);
		System.out.println();
		
	}
	static void solve(int x, int y, int size) {
		// 만약 size크기만큼 사각형으로 
		// 다 같으면 true 출력하고 좌표반환
	if(check(x,y,size)) {
		System.out.print(arr[x][y]);
		return;
	}
		int tmp = size/2;
		// 괄화출력하고 좌표 탐색
		System.out.print("(");
		solve(x, y, tmp);
		solve(x ,y+tmp, tmp);
		solve(x+tmp , y , tmp);
		solve(x+tmp, y+tmp ,tmp);
		System.out.print(")");
	}
	static boolean check(int x, int y, int size) {
		for(int i = x ;i<x+size;i++) {
			for(int j = y;j < y+size;j ++) {
				if(arr[i][j] != arr[x][y]) {
					return false;
				}
			}
		}
		
		// 다같으면 true
		return true;
	}
}
